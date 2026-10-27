# MiniTask KMP

MiniTask is a simple task management app built with Kotlin, Jetpack Compose, and Kotlin Multiplatform (KMP).

This project is a learning foundation for understanding KMP project structure, shared business logic, state management with Kotlin Coroutines and StateFlow, and unit testing.

## Features

- Add tasks
- Mark tasks as completed or incomplete
- Delete tasks
- Ignore blank task titles
- Unit tests for task management logic

## Tech Stack

- **Kotlin**
- **Kotlin Multiplatform (KMP)**
- **Jetpack Compose**
- **Material 3**
- **Kotlin Coroutines and StateFlow**
- **Gradle**
- **Kotlin Test**

## Project Structure

```text
MiniTask/
├── androidApp/          # Android application
├── shared/
│   └── src/
│       ├── commonMain/  # Shared models and task logic
│       ├── commonTest/  # Shared unit tests
│       ├── androidMain/ # Android-specific implementations
│       └── jvmMain/     # JVM-specific implementations
├── iosApp/              # iOS app entry point from the project template
├── gradle/              # Gradle configuration and version catalog
└── README.md
```

The `shared` module contains the task model, repository, and state holder. The Android app uses this shared logic to manage the task list.

## Getting Started

### Requirements

- Android Studio
- Android SDK
- A compatible JDK for the project's Gradle configuration

### Run the Android App

Open the project in Android Studio, sync Gradle, and run the `androidApp` configuration on an Android device or emulator.

Alternatively, build the debug APK from the project root on Windows:

```powershell
.\gradlew.bat :androidApp:assembleDebug
```

### Run Shared Unit Tests

To run the shared module's JVM tests on Windows:

```powershell
.\gradlew.bat :shared:jvmTest
```

## Current Limitations

- Tasks are stored in memory and are lost when the app process is restarted.
- The app currently focuses on Android as its runnable user interface.
- The iOS directory comes from the KMP project template; a fully implemented and verified iOS experience is not part of this project's scope.
- The project uses a simple repository and state holder to introduce shared business logic; it does not implement a full Clean Architecture setup.

## Project Status

**Learning project — foundational KMP concepts implemented.**

MiniTask demonstrates basic task management, shared Kotlin logic, state updates with StateFlow, and unit testing. It serves as a starting point for more complete Kotlin Multiplatform projects.
