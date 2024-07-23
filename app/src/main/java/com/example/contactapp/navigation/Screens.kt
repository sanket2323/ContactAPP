package com.example.contactapp.navigation

sealed class Screens(
    val route: String
) {
    object Home : Screens("home")
    object Details : Screens("details")
}