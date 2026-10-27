# MiniTask KMP

A simple task management app built with Kotlin, Jetpack Compose, and Kotlin Multiplatform.

MiniTask is a small portfolio project demonstrating shared business logic, basic task management, and unit testing with Kotlin Multiplatform.

## Features

- Add a task
- Mark a task as completed or incomplete
- Delete a task
- Ignore blank task titles
- Unit tests for task management logic

## Tech Stack

- **Kotlin**
- **Kotlin Multiplatform (KMP)**
- **Jetpack Compose**
- **Material 3**
- **Gradle**
- **Kotlin Test**

## Project Structure

```text
MiniTask/
├── androidApp/    # Android application
├── shared/
│   └── src/
│       ├── commonMain/   # Shared task models and business logic
│       └── commonTest/   # Shared unit tests
├── iosApp/        # Generated iOS application entry point
├── gradle/        # Gradle wrapper configuration
└── README.md
```

## Getting Started

### Requirements

- Android Studio
- Android SDK
- JDK compatible with the project's Gradle configuration

### Run the Android app

On Windows, run:

```powershell
.\gradlew.bat :androidApp:assembleDebug
```

Or open the project in Android Studio, sync Gradle, and run the `androidApp` configuration on an Android device or emulator.

### Run shared unit tests

Run the shared tests supported by your local environment. For example, on Windows:

```powershell
.\gradlew.bat :shared:allTests
```

## Notes

- Tasks are stored in memory and are not persisted after the app process is restarted.
- The current project focuses on the Android app and shared Kotlin business logic.
- The iOS application directory is retained from the generated Kotlin Multiplatform project template.

## Project Status

Mini portfolio project — core task management functionality and shared business logic are implemented. Build, tests, and runtime behavior are validated during development.