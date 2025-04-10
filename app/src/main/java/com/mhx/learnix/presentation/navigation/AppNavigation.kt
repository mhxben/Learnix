package com.mhx.learnix.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhx.learnix.presentation.view.LandingPage
import com.mhx.learnix.presentation.view.LoginPage
import com.mhx.learnix.presentation.view.SignUpPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController ,NavigationRoutes.Landing){
        composable(NavigationRoutes.Landing) { LandingPage(navController) }
        composable(NavigationRoutes.Login) { LoginPage(navController) }
        composable(NavigationRoutes.SignUp) { SignUpPage(navController) }
    }
}