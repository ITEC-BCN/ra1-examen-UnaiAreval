package com.example.adivinaapp

sealed class Routes(val route: String) {
    object Menu: Routes("Menu")
    object Game: Routes("Game")
}