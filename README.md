# MADD Labs - Mobile Application Development

Welcome to the **MADD Labs** repository. This repository contains practical lab assignments developed for the **Mobile Application Development (MADD)** module. Each laboratory session focuses on core Android development concepts utilizing Android Studio, Kotlin, modern architecture patterns, and Material Design 3.

---

## 👤 Student Information

- **Student Name:** Abhilash K A T W
- **Student ID:** IT22081698
- **Module:** Mobile Application Development (MADD)
- **Degree:** B.Sc. (Hons) in Information Technology

---

## 📂 Repository Structure

```
MADD-Labs/
├── Lab-01/          # Introduction to Android Studio & Core UI Layouts
├── Lab-02/          # CEB Electricity Bill Calculator Application
├── Lab-03/          # Multi-operation Calculator with Fragments
├── Lab-04/          # RecyclerView-based Todo Management Application
├── Lab-05/          # Advanced Android Concepts & Practical Implementation
├── .gitignore       # Android Studio & Gradle ignore configuration
└── README.md        # Project documentation and setup guide
```

---

## 📱 Lab Descriptions

### 🔹 [Lab-01](./Lab-01) - Android Studio Fundamentals & Basic Layouts
- **Focus:** Introduction to the Android Studio IDE, project architecture, and fundamentals of layout design.
- **Key Features:**
  - Layout hierarchies using `ConstraintLayout` and `LinearLayout`.
  - Understanding View hierarchy, XML attribute binding, and event handling.
  - Resource management (colors, dimensions, strings).

### 🔹 [Lab-02](./Lab-02) - Electricity Bill Calculator
- **Focus:** Multi-Activity navigation, input handling, and computational logic.
- **Key Features:**
  - Splash/Welcome screen leading to the calculator activity via explicit `Intent`.
  - Electricity bill calculation based on units consumed, fixed charges, and VAT.
  - Form validation with input feedback (`Toast` notifications).
  - Custom themed UI with responsive styling and CEB branding assets.

### 🔹 [Lab-03](./Lab-03) - Calculator with Fragment Architecture
- **Focus:** Modern Fragment lifecycle, dynamic fragment transactions, and back-stack management.
- **Key Features:**
  - Single-Activity architecture hosting dynamic fragments (`FragmentContainerView`).
  - `CalculatorFragment` supporting addition, subtraction, multiplication, and division.
  - Robust error validation (empty fields, numeric verification, division by zero guard).
  - `AnswerFragment` displaying formatted results with clean back-stack navigation.

### 🔹 [Lab-04](./Lab-04) - RecyclerView Todo Application
- **Focus:** List presentation with `RecyclerView`, dynamic Adapters, and Dialog interactions.
- **Key Features:**
  - In-memory repository (`TodoRepository`) managing task entities.
  - High-performance `RecyclerView` with custom `ViewHolder` and item layout.
  - Full CRUD capabilities: Add new tasks, edit existing items via `AlertDialog`, and delete tasks.
  - Dynamic empty-state handling when no items are present.

### 🔹 [Lab-05](./Lab-05) - Advanced Android Concepts (Sensors & Accelerometer Motion Tracking)
- **Focus:** Hardware sensor integration using `SensorManager` and real-time motion tracking.
- **Key Features:**
  - Capturing real-time accelerometer tilt data (X, Y, and Z axes) implementing `SensorEventListener`.
  - Low-pass filter algorithm to eliminate sensor jitter and provide silky smooth movement.
  - Interactive arena with collision boundary checks constraining view movement to screen limits.
  - Live HUD telemetry displaying real-time axis readings and directional tilt classification.
  - Interactive reset controls and sensor lifecycle management (`onResume`/`onPause`).

---

## 🛠️ Tech Stack & Prerequisites

- **Language:** Kotlin
- **IDE:** Android Studio (Ladybug / Iguana / Koala / Meerkat)
- **Min SDK:** 24 (Android 7.0 Nougat)
- **Target SDK / Compile SDK:** 36+
- **Build System:** Gradle (Kotlin DSL - `build.gradle.kts`)
- **UI Toolkit:** Android XML Layouts with Material Components / Material 3

---

## 🚀 Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/abhilashzz/MADD-Labs.git
   ```
2. **Open in Android Studio:**
   - Open Android Studio.
   - Select **Open** and choose the specific lab directory (e.g., `Lab-01`, `Lab-02`, `Lab-03`, `Lab-04`, or `Lab-05`).
3. **Sync & Build:**
   - Allow Gradle to sync dependencies and project configuration.
   - Run the project on an Android Emulator or connected physical device.

---

## 📄 License
This repository is created for academic coursework and assignment submissions.
