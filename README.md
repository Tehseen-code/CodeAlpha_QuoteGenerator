# 📄 Quote Generator App — Task 2

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-Multiplatform-purple?style=for-the-badge&logo=kotlin" alt="KMP" />
  <img src="https://img.shields.io/badge/Compose-Multiplatform-blue?style=for-the-badge&logo=android" alt="CMP" />
  <img src="https://img.shields.io/badge/Architecture-MVVM-green?style=for-the-badge" alt="MVVM" />
</p>

An elegant, cross-platform **Quote Generator Application** developed as part of the **CodeAlpha Internship (Task 2)**. Built entirely with **Kotlin Multiplatform (KMP)** and **Compose Multiplatform**, this app combines a beautiful, reactive user interface with a robust, offline-first data layer targeting both Android and iOS from a single shared codebase.

---

## ✨ Key Features

* **🎨 Custom Splash Experience:** A sleek, premium splash entry using optimized vector graphics and smooth transition states.
* **💡 Dynamic Quote Discovery:** Seamlessly browse through a rich collection of inspiring quotes with a modern Material 3 UI.
* **⚡ Reactive State Management:** Zero UI lag or stutter, utilizing modern asynchronous streams for real-time data sync.

---

## 🛠️ Architecture & Tech Stack

The application is engineered using production-grade standards and enterprise design patterns:

| Component | Technology Stack | Purpose |
| :--- | :--- | :--- |
| **Language** | Kotlin 🚀 | Core language for cross-platform logic and safety. |
| **UI Framework** | Compose Multiplatform (CMP) | Single declarative UI codebase shared across Android & iOS. |
| **Architecture** | MVVM / Clean Architecture | Strict separation of concerns ensuring testability and scalability. |
| **Concurrency** | Kotlin Coroutines & Flows | Reactive, non-blocking asynchronous state handling (`StateFlow`). |

---

## 🚀 Installation & Setup

To get a local copy of this project up and running, clone the repository directly using the following link:

```bash
git clone [https://github.com/Tehseen-code/CodeAlpha_QuoteGenerator.git](https://github.com/Tehseen-code/CodeAlpha_QuoteGenerator.git)
---

<img width="533" height="192" alt="image" src="https://github.com/user-attachments/assets/0391b89c-7d0a-4e21-aab7-bd9353ce4c94" />

## 🏗️ Project Architecture Overview

```text
📁 CodeAlpha_QuoteGenerator
│
├── 📂 composeApp (100% Shared UI & Logic)
│    ├── 📂 commonMain
│    │    ├── 📂 data        # Room DB Setup, Repositories, Entity Models
│    │    ├── 📂 viewmodel   # Business Logic & UI State Controllers (MVVM)
│    │    └── 📂 ui          # Jetpack Compose Screens, Custom Vectors & Themes
│    │
│    ├── 📂 androidMain     # Android Lifecycle Entry Points & Configs
│    └── 📂 iosMain         # iOS Lifecycle Bindings & Configuration
│
└── 📂 iosApp               # Native Xcode wrapper for compiling the iOS Target
