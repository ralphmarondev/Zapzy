# Zapzy

Zapzy is a mobile app built with **Jetpack Compose (Material 3)** that allows users to control various Raspberry Pi components (LEDs, sensors, and more) using their phone via a **Django REST Framework (DRF) API**.

## 🚀 Features
- 📡 **Wireless Control** – Control Raspberry Pi components remotely.
- 🔌 **Multiple Components Support** – LEDs, sensors, motors, and more.
- 📱 **Multi-Device Access** – Multiple devices can control the same components.
- 🌙 **Intuitive UI** – Built with **Jetpack Compose Material 3**.
- 🔗 **REST API Integration** – Powered by **Django REST Framework**.

## 🛠️ Tech Stack
- **Frontend:** Jetpack Compose (Material 3), Kotlin
- **Backend:** Django REST Framework (DRF), Python
- **Hardware:** Raspberry Pi, various components (LEDs, sensors, etc.)

## 📦 Installation
### 🔹 Backend (Django REST Framework)
1. Clone the repository:
   ```bash
   git clone https://github.com/ralphmarondev/Zapzy.git
   cd Zapzy/api
   ```
2. Install dependencies:
   ```bash
   pip install -r requirements.txt
   ```
3. Run the server:
   ```bash
   python manage.py runserver
   ```

### 🔹 Mobile App (Jetpack Compose)
1. Navigate to the Android project folder:
   ```bash
   cd Zapzy/android
   ```
2. Open the project in **Android Studio** (latest stable version recommended).
3. Build and run the app on an emulator or physical device.

## 🖥️ Usage
1. Ensure your **Raspberry Pi** is connected to the backend API.
2. Open the **Zapzy** app and connect it to your backend.
3. Start controlling components directly from your phone!

## 🤝 Contributing
Want to improve Zapzy? Feel free to fork the repository and submit pull requests!

## 📜 License
MIT License © 2025 Zapzy Developers

---
💡 *Zapzy – Tinker, Control, Innovate!*

