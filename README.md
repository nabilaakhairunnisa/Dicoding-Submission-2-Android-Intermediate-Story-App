# 📖 Story App

Story App is an Android application that allows users to share stories with photos, explore other users’ stories on a map, and interact through an authenticated and secure platform.  
Built with **Kotlin**, this app integrates modern Android development tools such as Retrofit, Ktor, and Jetpack components.

<img src="https://github.com/nabilaakhairunnisa/Dicoding-Submission-2-Android-Intermediate-Story-App/blob/master/mock.png" />

---

## ✨ Features

- 🔐 **Authentication**: Secure login and registration system.  
- 📷 **Upload Story**: Add new stories with photos taken directly from the camera or selected from the gallery.  
- 🗺️ **Maps Integration**: View stories shared by other users on an interactive map, including the uploader’s location.  
- 🔄 **Animations**: Smooth UI transitions using Object Animator.  
- 🌐 **Networking**: Retrieve and send data using **Retrofit** and **Ktor** for API communication.  

---

## 🛠️ Tech Stack

* **Kotlin** – Main programming language
* **Retrofit** – REST API client
* **Ktor Client** – Lightweight networking library
* **Jetpack Components** – ViewModel, LiveData, DataStore, Navigation
* **Object Animator** – Smooth UI animations
* **Google Maps API** – Maps and location services
* **CameraX / Media Picker** – Capture or select photos

---

## 📲 Installation

### Prerequisites

* Android Studio (latest version recommended)
* Minimum SDK: 21 (Android 5.0 Lollipop)
* Enable Internet and Location permissions

### Steps

1. Clone this repository:

   ```bash
   git clone https://github.com/yourusername/story-app.git
   ```
2. Open the project in **Android Studio**.
3. Add your **Google Maps API Key** in `local.properties`:

   ```
   MAPS_API_KEY=your_api_key_here
   ```
4. Build and run the app on an emulator or real device.

---

## 🚀 Usage

1. Register or log in with your account.
2. Upload a story by capturing an image from the camera or choosing one from the gallery.
3. Add a description and optionally your location.
4. Explore the **Story Feed** to see posts from other users.
5. Open the **Maps View** to see where each story was uploaded.

---

## 📡 API

This app uses a provided backend API for:

* Authentication (Register, Login)
* Uploading stories with images and location data
* Fetching stories with pagination support

---

## 🤝 Contribution

1. Fork this repository.
2. Create a new feature branch:

   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:

   ```bash
   git commit -m "Add new feature"
   ```
4. Push to your branch and open a Pull Request.

---
