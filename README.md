# 📄 Quote Generator App — Task 2

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-Multiplatform-purple?style=for-the-badge&logo=kotlin" alt="KMP" />
  <img src="https://img.shields.io/badge/Compose-Multiplatform-blue?style=for-the-badge&logo=android" alt="CMP" />
  <img src="https://img.shields.io/badge/Architecture-MVVM-green?style=for-the-badge" alt="MVVM" />
</p>

An elegant, cross-platform **Quote Generator Application** developed as part of the **CodeAlpha Internship (Task 2)**. Built entirely with **Kotlin Multiplatform (KMP)** and **Compose Multiplatform**, this app combines a beautiful, reactive user interface with a robust, asynchronous remote networking layer targeting both Android and iOS from a single shared codebase.

---

## ✨ Key Features

* **🎨 Custom Splash Experience:** A sleek, premium splash entry using optimized vector graphics and smooth transition states.
* **💡 Dynamic Quote Discovery:** Seamlessly browse through a rich collection of inspiring quotes fetched dynamically over the network with a modern Material 3 UI.
* **⚡ Reactive State Management:** Zero UI lag or stutter, utilizing modern asynchronous data streams for real-time network UI synchronization.

---

## 🛠️ Architecture & Tech Stack

The application is engineered using production-grade standards and enterprise design patterns:

| Component | Technology Stack | Purpose |
| :--- | :--- | :--- |
| **Language** | Kotlin 🚀 | Core language for cross-platform logic and type safety. |
| **UI Framework** | Compose Multiplatform (CMP) | Single declarative UI codebase shared across Android & iOS. |
| **Networking** | Ktor Client 🌐 | Multiplatform asynchronous HTTP client to handle REST API requests. |
| **Architecture** | MVVM / Clean Architecture | Strict separation of concerns ensuring testability and scalability. |
| **Concurrency** | Kotlin Coroutines & Flows | Reactive, non-blocking asynchronous state handling (`StateFlow`). |

---

## 🧠 Technical Deep Dive: Asynchronous Networking with Ktor & Flows

When engineering the data layer for this application, a critical focus was ensuring that remote network requests over HTTP would never freeze or block the Main Thread (UI execution pipeline), maintaining an optimal framerate during API interactions.

### 1. Non-Blocking API Requests with Ktor
The core data pipeline uses **Ktor Client** configured with Content Negotiation and JSON serialization. Network requests execute entirely within background coroutine scopes, allowing the application to safely pull raw data across the web without impacting UI rendering performance.

```kotlin
class QuoteRepository(private val httpClient: HttpClient) {
    // Explicit background context fetching to isolate remote API latency from the UI
    suspend fun fetchNextQuote(): QuoteModel = withContext(Dispatchers.Default) {
        httpClient.get("[https://api.quotable.io/random](https://api.quotable.io/random)").body<QuoteModel>()
    }
}

📁 CodeAlpha_QuoteGenerator
│
├── 📂 composeApp (100% Shared UI & Logic)
│   ├── 📂 commonMain
│   │   ├── 📂 data        # Ktor API Engine Setup, Network Repositories, Data Transfer Models
│   │   ├── 📂 viewmodel   # Business Logic, Network Dispatchers & UI State Controllers (MVVM)
│   │   └── 📂 ui          # Jetpack Compose Screens, Custom Vectors, Components & Themes
│   │
│   ├── 📂 androidMain     # Android Lifecycle Entry Points, Activities & Manifest Configurations
│   └── 📂 iosMain         # iOS Lifecycle Bindings, UI Framework Entry & Target Linkages
│
└── 📂 iosApp               # Native Xcode project wrapper used for compiling the final iOS App
---
To get a local copy of this project up and running, clone the repository using:
git clone [https://github.com/Tehseen-code/CodeAlpha_QuoteGenerator.git](https://github.com/Tehseen-code/CodeAlpha_QuoteGenerator.git)
