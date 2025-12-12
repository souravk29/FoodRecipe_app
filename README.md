# 🍲 Food Recipe App

An Android app that lets users browse and explore various food recipes. Built with **Kotlin**, **MVVM architecture**, and uses **Retrofit** to fetch data from [TheMealDB API](https://www.themealdb.com/api.php) in **JSON** format.

![Kotlin](https://img.shields.io/badge/Language-Kotlin-orange)

---

<img src="screenshots/Screenshot 2025-07-03 223836.png" width=250 />  <img src = "screenshots/Screenshot 2025-07-08 140736.png" width = 250 />


## 📱 Features

- 🍽️ Browse random and category-based meals  
- 📋 View detailed recipes with ingredients and instructions  
- 🔄 Load meals dynamically from JSON API using Retrofit  
- 🧠 MVVM pattern with ViewModel and LiveData / StateFlow  
- 🎨 Simple and responsive UI using Jetpack Compose or XML  

---

## 🛠️ Tech Stack

| Layer         | Technology                        |
|---------------|-----------------------------------|
| UI            | Jetpack Compose / XML Layout      |
| Architecture  | MVVM (Model-View-ViewModel)       |
| Networking    | Retrofit2, GSON                   |
| Language      | Kotlin                            |
| API Source    | [TheMealDB](https://www.themealdb.com/api.php) |

---

## 📦 API Details

- Base URL: `https://www.themealdb.com/api/json/v1/1/`  
- Example Endpoint: [`categories.php`](https://www.themealdb.com/api/json/v1/1/categories.php)  
- Response format: `application/json`  
- No authentication needed for basic endpoints

---

## 📁 Project Structure


├── AndroidManifest.xml           # App manifest and permissions

├── ApiService.kt                 # Retrofit API service definition

├── Category.kt                   # Data class representing a recipe category

├── CategoryDetailScreen.kt       # UI for showing category details

├── MainActivity.kt               # Entry activity hosting the navigation

├── MainViewModel.kt              # ViewModel containing app logic and API calls

├── RecipeApp.kt                  # Application root with NavHost setup

├── RecipeScreen.kt               # Home screen showing list of categories

├── Screen.kt                     # Navigation route definitions

---

## 🚀 How to Run

Clone this repository.

Open the project in Android Studio.

Make sure you have the following:

Internet access

Correct API base URL in ApiService.kt

Android SDK version configured correctly

Run the app on an emulator or physical device.

---
## 🔗 Retrofit Integration

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): Response<CategoryResponse>
}

---
## ✅ Future Improvements

🔍 Add search and filter capabilities

🌐 Add localization support

💾 Add offline caching using Room

💡 Add error and loading states


---
## 📄 License
This project is open-source and available under the MIT License

---
## 🤝 Contributing
Contributions, issues, and feature requests are welcome!
Feel free to fork the repo and submit a pull request.
Let’s build something delicious together! 😋
