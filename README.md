# CALCULATOR App

A simple calculator app built using Jetpack Compose for Android. This app supports basic arithmetic operations, dynamic theme switching (light/dark mode), and provides a modern, clean UI.

## Features

- **Basic Arithmetic Operations**: Perform addition, subtraction, multiplication, division, parentheses, and percentage calculations.
- **Dynamic Theme Switching**: Toggle between light and dark themes.
- **Expression Evaluation**: Utilizes the `exp4j` library for mathematical expression parsing and evaluation.
- **Modern UI**: Built with Jetpack Compose, ensuring a responsive and visually appealing user interface.

## Screenshots

![Light Mode](path/to/light_mode_screenshot.png)
![Dark Mode](path/to/dark_mode_screenshot.png)

## Getting Started

### Prerequisites

- Android Studio (latest version recommended)
- Android SDK 33 or higher
- Kotlin 1.8 or higher

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/CALCULATOR.git
    ```
   
2. Open the project in **Android Studio**.

3. Sync the project with Gradle files by clicking on **"Sync Now"** when prompted.

### Running the App

1. Connect your Android device or use an emulator.
2. Click on **"Run"** (green play button) in **Android Studio** or press `Shift + F10`.

## Project Structure

- `MainActivity.kt`: Main entry point of the app, sets up the UI and handles theme switching.
- `Calculator.kt`: Contains the UI components for the calculator, including buttons and text input.
- `ui.theme/`: Custom themes for the app (light and dark).
- `res/drawable/`: Icons used for theme switching.

## Dependencies

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI toolkit for modern native Android UI.
- [exp4j](https://www.objecthunter.net/exp4j/) - Mathematical expression evaluator for Java.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by basic calculator apps.
- Special thanks to the [Jetpack Compose](https://developer.android.com/jetpack/compose) community.
