package com.mhx.learnix.presentation.navigation

import androidx.navigation.NavController

object NavigationActions {
    fun navigateToLogin(navController: NavController){
        navController.navigate(NavigationRoutes.Login){
            popUpTo(NavigationRoutes.Landing) { inclusive = true }
        }
    }
    fun navigateToSignUp(navController: NavController){
        navController.navigate(NavigationRoutes.SignUp)
    }
}