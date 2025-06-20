This is sample work to showcase some of the work I am currently working on android.

This repository now features **CI/CD** with GitHub Actions.

## Codebase Overview

This repository demonstrates a cryptocurrency app built with Kotlin, Jetpack Compose, and Hilt. The project follows a clean architecture approach, separating concerns into data, domain, and presentation layers.

### Application Setup
- `CryptoCurrencyApplication.kt` is the Hilt-enabled entry point.
- `AppModule.kt` configures Retrofit services and repository bindings.
- `Constants.kt` defines the API base URL and navigation keys.

### Data Layer
- `CryptoAPI.kt` exposes Retrofit endpoints for currencies and details.
- `DefaultCurrencyRepository` implements `CurrencyRepository` using the API.

### Domain Layer
- Use case classes transform results into domain models and emit `Resource` states.

### Presentation Layer
- ViewModels provide state to Compose UI screens.
- `CurrencyListScreen` and `CurrencyDetailScreen` display lists and details with navigation in `MainActivity`.

### Next Steps
- Add tests for ViewModels and Compose UI.
- Explore Retrofit, coroutines with `Flow`, and Jetpack Compose in depth.

### CI Pipeline
The repository includes a GitHub Actions workflow that builds a release APK on every push and pull request. The APK is placed in a `release/` directory and uploaded as a workflow artifact.
