package com.example.madd_lab_05

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.util.Locale
import kotlin.math.abs

/**
 * MADD Lab Sheet 05 - Advanced Android Concepts (Sensors)
 *
 * Demonstrates the use of SensorManager and SensorEventListener to capture
 * phone accelerometer tilt data (X and Y axes) and smoothly move an ImageView
 * across the screen within bounded limits.
 */
class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    // UI Elements
    private lateinit var arenaLayout: FrameLayout
    private lateinit var ivAndroidLogo: ImageView
    private lateinit var tvAxisX: TextView
    private lateinit var tvAxisY: TextView
    private lateinit var tvAxisZ: TextView
    private lateinit var tvDirection: TextView
    private lateinit var tvSensorStatus: TextView
    private lateinit var btnResetPosition: MaterialButton

    // Motion & Filtering Parameters
    private var smoothX = 0f
    private var smoothY = 0f
    private val filterAlpha = 0.8f // Low-pass filter smoothing coefficient
    private val motionSpeed = 2.5f // Sensitivity multiplier for smooth movement
    private val tiltThreshold = 1.0f // Threshold in m/s² to classify tilt direction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle system bar insets (status bar, navigation bar)
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout)) { v, insets ->
            val systemBars = insets.getInsets(androidx.core.view.WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI component references
        initViews()

        // Initialize SensorManager and Accelerometer
        initSensor()

        // Set up Reset button
        btnResetPosition.setOnClickListener {
            centerImage()
            Toast.makeText(this, "Position reset to center", Toast.LENGTH_SHORT).show()
        }

        // Center the ImageView once the layout has been measured
        arenaLayout.post {
            centerImage()
        }
    }

    private fun initViews() {
        arenaLayout = findViewById(R.id.arenaLayout)
        ivAndroidLogo = findViewById(R.id.ivAndroidLogo)
        tvAxisX = findViewById(R.id.tvAxisX)
        tvAxisY = findViewById(R.id.tvAxisY)
        tvAxisZ = findViewById(R.id.tvAxisZ)
        tvDirection = findViewById(R.id.tvDirection)
        tvSensorStatus = findViewById(R.id.tvSensorStatus)
        btnResetPosition = findViewById(R.id.btnResetPosition)
    }

    private fun initSensor() {
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (accelerometer == null) {
            tvSensorStatus.text = getString(R.string.sensor_unavailable)
            Toast.makeText(
                this,
                "Accelerometer sensor not available on this device",
                Toast.LENGTH_LONG
            ).show()
        } else {
            tvSensorStatus.text = getString(R.string.sensor_active)
        }
    }

    /**
     * Registers the SensorEventListener in onResume() using SENSOR_DELAY_GAME
     * to ensure responsive, low-latency motion updates for real-time movement.
     */
    override fun onResume() {
        super.onResume()
        accelerometer?.let { sensor ->
            sensorManager.registerListener(
                this,
                sensor,
                SensorManager.SENSOR_DELAY_GAME
            )
        }
    }

    /**
     * Unregisters the SensorEventListener in onPause() to save battery
     * and prevent unnecessary sensor polling when the activity is not visible.
     */
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    /**
     * Handles accelerometer sensor event updates.
     * Extracts X, Y, and Z axis values, updates telemetry HUD, applies smoothing,
     * and repositions the ImageView within the boundary of the arena.
     */
    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null || event.sensor.type != Sensor.TYPE_ACCELEROMETER) return

        val rawX = event.values[0]
        val rawY = event.values[1]
        val rawZ = event.values[2]

        // Update real-time HUD telemetry
        updateTelemetryDisplay(rawX, rawY, rawZ)

        // Apply low-pass filter to eliminate sensor jitter
        smoothX = filterAlpha * smoothX + (1 - filterAlpha) * rawX
        smoothY = filterAlpha * smoothY + (1 - filterAlpha) * rawY

        // Calculate motion delta based on smoothed tilt
        val deltaX = smoothX * motionSpeed
        val deltaY = smoothY * motionSpeed

        // Accelerometer Coordinate Mapping:
        // - Tilting right: rawX < 0 -> (ivAndroidLogo.x - deltaX) increases X -> moves right
        // - Tilting left:  rawX > 0 -> (ivAndroidLogo.x - deltaX) decreases X -> moves left
        // - Tilting backward/down: rawY > 0 -> (ivAndroidLogo.y + deltaY) increases Y -> moves down
        // - Tilting forward/up:    rawY < 0 -> (ivAndroidLogo.y + deltaY) decreases Y -> moves up
        val newX = ivAndroidLogo.x - deltaX
        val newY = ivAndroidLogo.y + deltaY

        // Constrain ImageView strictly inside the arena bounds
        val maxX = (arenaLayout.width - ivAndroidLogo.width).toFloat().coerceAtLeast(0f)
        val maxY = (arenaLayout.height - ivAndroidLogo.height).toFloat().coerceAtLeast(0f)

        ivAndroidLogo.x = newX.coerceIn(0f, maxX)
        ivAndroidLogo.y = newY.coerceIn(0f, maxY)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not required for basic accelerometer reading
    }

    /**
     * Updates the on-screen live telemetry and computes tilt direction.
     */
    private fun updateTelemetryDisplay(x: Float, y: Float, z: Float) {
        tvAxisX.text = String.format(Locale.getDefault(), "X: %+.2f", x)
        tvAxisY.text = String.format(Locale.getDefault(), "Y: %+.2f", y)
        tvAxisZ.text = String.format(Locale.getDefault(), "Z: %+.2f", z)

        val horizontal = when {
            x > tiltThreshold -> "Left"
            x < -tiltThreshold -> "Right"
            else -> ""
        }

        val vertical = when {
            y > tiltThreshold -> "Backward"
            y < -tiltThreshold -> "Forward"
            else -> ""
        }

        val direction = when {
            horizontal.isNotEmpty() && vertical.isNotEmpty() -> "$horizontal + $vertical"
            horizontal.isNotEmpty() -> horizontal
            vertical.isNotEmpty() -> vertical
            else -> "Flat / Neutral"
        }

        tvDirection.text = String.format(Locale.getDefault(), "Tilt: %s", direction)
    }

    /**
     * Centers the ImageView in the arena layout and resets smoothed velocities.
     */
    private fun centerImage() {
        val centerX = (arenaLayout.width - ivAndroidLogo.width) / 2f
        val centerY = (arenaLayout.height - ivAndroidLogo.height) / 2f

        ivAndroidLogo.x = centerX.coerceAtLeast(0f)
        ivAndroidLogo.y = centerY.coerceAtLeast(0f)

        smoothX = 0f
        smoothY = 0f
    }
}
