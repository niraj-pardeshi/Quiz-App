# Quiz Master App 🧠

## Installation

1. **Clone the repository**
2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it
3. **Build and Run**
   - Wait for Gradle sync to complete
   - Connect an Android device or start an emulator
   - Click "Run" or press Shift + F10

## 📱 Features

### Core Functionality
- **10 Question Quiz**: Complete quiz with diverse categories (Geography, Science, Art, Biology, History, Mathematics, Technology, Chemistry, Literature)
- **Real-time Scoring**: Track correct answers, skipped questions, and overall progress
- **Streak System**: Consecutive correct answers tracking with visual streak badge that activates at 3+ correct answers
- **Skip Functionality**: Skip questions when unsure, with skip counter tracking
- **Auto-progression**: Automatically advances to next question after 2 seconds when answer is revealed
- **Results Summary**: Comprehensive results screen showing score, statistics, and performance metrics

### Technical Features
- **Clean Architecture**: Separation of UI, state management, and data layers
- **MVVM Pattern**: ViewModel for state management and business logic
- **Compose Navigation**: Seamless navigation between screens
- **State Management**: Reactive UI updates using StateFlow and Compose State
- **Coroutines**: Asynchronous operations for smooth user experience

## Project Structure

```
app/
├── src/main/java/com/example/quizapp/
│   ├── MainActivity.kt              # Entry point
│   ├── QuizApp.kt                  # Main app navigation
│   ├── QuizViewModel.kt            # State management & business logic
│   ├── data/
│   │   ├── Question.kt             # Question data model
│   │   └── QuizRepository.kt       # Data repository
│   ├── ui/
│   │   ├── screens/
│   │   │   ├── LoadingScreen.kt    # Splash/Loading screen
│   │   │   ├── QuestionScreen.kt   # Main quiz interface
│   │   │   └── ResultsScreen.kt    # Final results display
│   │   ├── state/
│   │   │   └── QuizUiState.kt      # UI state management
│   │   └── theme/
│   │       └── Theme.kt            # App theming
```

## Navigation Flow

```
LoadingScreen → QuestionScreen → ResultsScreen
                     ↓
            (Loop through 10 questions)
                     ↓
            Results with restart option
```

## 📱 Screenshots

