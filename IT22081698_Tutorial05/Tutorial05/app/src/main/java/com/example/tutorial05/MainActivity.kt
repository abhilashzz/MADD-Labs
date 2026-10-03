package com.example.tutorial05

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var sensorManager: SensorManager
    lateinit var accelerometer: Sensor
    lateinit var proximitySensor: Sensor
    lateinit var lightSensor: Sensor
    lateinit var sensorListener: SensorEventListener

    private fun initSensorListener(): SensorEventListener {
        val sensorListener = object : SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // Handle accuracy changes if needed
            }

            val viewModel: MainActivityData =
                ViewModelProvider(this@MainActivity)[MainActivityData::class.java]

            override fun onSensorChanged(event: SensorEvent?) {
                when (event?.sensor?.type) {
                    Sensor.TYPE_ACCELEROMETER -> {
                        val x = event.values[0]
                        val y = event.values[1]
                        val z = event.values[2]
                        viewModel.updateAccelerometerData("X: $x, Y: $y, Z: $z")
                    }
                    Sensor.TYPE_PROXIMITY -> {
                        val distance = event.values[0]
                        viewModel.updateProximityData("Distance: $distance")
                    }
                    Sensor.TYPE_LIGHT -> {
                        val lux = event.values[0]
                        viewModel.updateLightData("Lux: $lux")
                    }
                }
            }
        }
        return sensorListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvAccelaration: TextView = findViewById(R.id.tvAccelaration)
        val tvProximity: TextView = findViewById(R.id.tvProximity)
        val tvLight: TextView = findViewById(R.id.tvLight)

        // Initialize sensors
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!!
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)!!
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)!!
        sensorListener = initSensorListener()

        val viewModel: MainActivityData = ViewModelProvider(this)[MainActivityData::class.java]

        viewModel.accelerometerData.observe(this) { data ->
            tvAccelaration.text = data
        }

        viewModel.proximityData.observe(this) { data ->
            tvProximity.text = data
        }

        viewModel.lightData.observe(this) { data ->
            tvLight.text = data
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(sensorListener, accelerometer,
            SensorManager.SENSOR_STATUS_ACCURACY_HIGH)
        sensorManager.registerListener(sensorListener, proximitySensor,
            SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(sensorListener, lightSensor,
            SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(sensorListener)
    }
}