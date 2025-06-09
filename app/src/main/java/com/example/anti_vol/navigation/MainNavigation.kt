package com.example.anti_vol.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anti_vol.screens.HomeScreen
import com.example.anti_vol.screens.onboarding.IntroductionScreen1
import com.example.anti_vol.screens.onboarding.IntroductionScreen2
import com.example.anti_vol.screens.onboarding.IntroductionScreen3
import com.example.anti_vol.screens.PinSetupScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("intro1") {
            IntroductionScreen1(navController)
        }
        composable("intro2") {
            IntroductionScreen2(navController)
        }
        composable("intro3") {
            IntroductionScreen3(navController)
        }
        composable("pin_setup") {
            PinSetupScreen(navController)
        }
    }
}