package com.mhx.learnix.presentation.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhx.learnix.data.model.LoginRequest
import com.mhx.learnix.data.model.utils.LoginValidateInfo
import com.mhx.learnix.presentation.component.StaticColumn
import com.mhx.learnix.R
import com.mhx.learnix.presentation.component.*
import com.mhx.learnix.presentation.component.model.OutlinedTextFieldClass
import com.mhx.learnix.presentation.navigation.NavigationActions
import com.mhx.learnix.ui.theme.PrimaryColor

@Composable
fun LoginPage(navController: NavController){
    var isPasswordVisible by remember { mutableStateOf(false) }
    var loginRequest by remember { mutableStateOf(LoginRequest("",""))}
    val validator = LoginValidateInfo()
    val context = LocalContext.current

    StaticColumn {
        Image(
            painter = painterResource(id = R.drawable.main_logo),
            contentDescription = "App Logo"
            , Modifier.size(200.dp)
        )
        CustomText("Welcome to Learnix" , PrimaryColor , 22)
        PrimaryText("An E-learning platform" , PrimaryColor)
        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Email",
                value = loginRequest.email,
                onValueChange = {newEmail -> loginRequest = loginRequest.copy(email = newEmail)},
                keyboardType = KeyboardType.Email)
        )
        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Password",
                value = loginRequest.password,
                onValueChange = { newPassword -> loginRequest = loginRequest.copy(password = newPassword) },
                keyboardType = KeyboardType.Password,
                isPasswordField = true,
                isPasswordVisible = isPasswordVisible,
                onVisibilityToggle = { isPasswordVisible = !isPasswordVisible }
            )
        )
        AppButton("Login",onClick = {
            val errorMessage =  validator.validateLoginInfos(loginRequest)
            if ( errorMessage != null){
                Toast.makeText(context,errorMessage,Toast.LENGTH_LONG).show()
            }else{
                //viewmodel
            }
        })
        StaticRow {
            PrimaryText("Haven't you an account ?" , Color.Black)
            PrimaryText(" Create a one" , PrimaryColor , Modifier.clickable { NavigationActions.navigateToSignUp(navController)})
        }
    }
}