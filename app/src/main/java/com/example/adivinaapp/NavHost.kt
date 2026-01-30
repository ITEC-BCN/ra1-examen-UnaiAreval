package com.example.adivinaapp

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.adivinaapp.view.GameScreen
import com.example.adivinaapp.view.MenuScreen

@Composable
fun NavController(
    navController: NavController
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Routes.Menu.route,
        modifier = Modifier.background(color = Color.LightGray)
    ){
        composable(Routes.Menu.route) { MenuScreen(navController) }
        composable(Routes.Game.route) { GameScreen(navController) }
    }
}