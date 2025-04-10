package com.mhx.learnix.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhx.learnix.R
import com.mhx.learnix.presentation.navigation.NavigationActions
import com.mhx.learnix.ui.theme.PrimaryColor
import kotlinx.coroutines.delay

@Composable
fun LandingPage(navController: NavController){
    LaunchedEffect(Unit){
        delay(2000)
        NavigationActions.navigateToLogin(navController)
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(PrimaryColor),
        contentAlignment = Alignment.Center){
        Image(
            painter = painterResource(R.drawable.logo_white),
            contentDescription = "App Logo"
            ,Modifier.size(100.dp)
        )
    }
}