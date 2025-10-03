This is a Kotlin Multiplatform project targeting Android, Web, Desktop (JVM).

## Requirements

- Java 21 or higher (Java 25 is not currently supported due to Kotlin compiler compatibility issues)
- If you have multiple Java versions, ensure Java 21 is active. You can use SDKMAN to manage versions:
  ```shell
  sdk use java 21.0.8.crac-zulu
  ```

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run Desktop (JVM) Application

To build and run the development version of the desktop app, use the run configuration from the run widget
in your IDE’s toolbar or run it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:run
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:run
  ```

### Build and Run Web Application

To build and run the development version of the web app, use the run configuration from the run widget
in your IDE's toolbar or run it directly from the terminal:
- for the Wasm target (faster, modern browsers):
  - on macOS/Linux
    ```shell
    ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
    ```
  - on Windows
    ```shell
    .\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
    ```
- for the JS target (slower, supports older browsers):
  - on macOS/Linux
    ```shell
    ./gradlew :composeApp:jsBrowserDevelopmentRun
    ```
  - on Windows
    ```shell
    .\gradlew.bat :composeApp:jsBrowserDevelopmentRun
    ```

## Code Quality with Detekt

This project uses [Detekt](https://detekt.dev/) for static code analysis and code quality checks. Detekt has been
configured with rules suitable for Compose Multiplatform development.

### Running Detekt

To run code analysis on all source sets:

```shell
./gradlew detekt
```

To run analysis on specific source sets:

```shell
# Analyze common main source (recommended)
./gradlew detektMetadataCommonMain

# Analyze Android specific code
./gradlew detektAndroidDebug

# Analyze JVM specific code  
./gradlew detektJvmMain

# Analyze JS specific code
./gradlew detektJsMain

# Analyze Wasm specific code
./gradlew detektWasmJsMain
```

### Configuration

Detekt configuration is located at `config/detekt/detekt.yml`. The configuration has been customized for:

- Compose Multiplatform development patterns
- Excluding generated files and build directories
- Allowing common Compose wildcard imports
- Lenient magic number rules for UI code
- Support for Composable function naming patterns

### Auto-fixing Issues

Some code style issues can be automatically fixed using the detekt-formatting plugin:

```shell
./gradlew detektMetadataCommonMain --auto-correct
```

### Creating a Baseline

To create a baseline of current issues (useful for legacy code):

```shell
./gradlew detektBaseline --baseline detekt-baseline.xml
```

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [YouTrack](https://youtrack.jetbrains.com/newIssue?project=CMP).