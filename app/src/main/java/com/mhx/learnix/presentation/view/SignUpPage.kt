package com.mhx.learnix.presentation.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhx.learnix.R
import com.mhx.learnix.data.model.RegisterRequest
import com.mhx.learnix.data.model.utils.RegisterValidationInfo
import com.mhx.learnix.presentation.component.*
import com.mhx.learnix.presentation.component.model.OutlinedTextFieldClass
import com.mhx.learnix.presentation.navigation.NavigationActions
import com.mhx.learnix.ui.theme.*

@Composable
fun SignUpPage(navController: NavController){
    var registerRequest by remember { mutableStateOf(RegisterRequest("" , "" ,"","","")) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val roleType = listOf("Student","Teacher")
    val validator = RegisterValidationInfo()
    val context = LocalContext.current

    StaticColumn {
        Image(
            painter = painterResource(id = R.drawable.main_logo),
            contentDescription = "App Logo"
            , Modifier.size(200.dp)
        )
        CustomText("Welcome to Learnix" , PrimaryColor , 22)
        PrimaryText("An E-learning platform" , PrimaryColor)
        StaticColumn(Modifier.verticalScroll(rememberScrollState())) {
            MainOutlinedTextField(
                params = OutlinedTextFieldClass(
                    label = "Full Name",
                    value = registerRequest.fullName,
                    onValueChange = {newFullName -> registerRequest = registerRequest.copy(fullName = newFullName)},
                    keyboardType = KeyboardType.Text
                )
            )
            MainOutlinedTextField(
                params = OutlinedTextFieldClass(
                    label = "Email",
                    value = registerRequest.email,
                    onValueChange = {newEmail -> registerRequest = registerRequest.copy(email = newEmail)},
                    keyboardType = KeyboardType.Text
                )
            )
            MainOutlinedTextField(
                params = OutlinedTextFieldClass(
                    value = registerRequest.role,
                    onValueChange = { registerRequest = registerRequest.copy(role = it) },
                    label = "Role",
                    isDropdown = true,
                    dropdownItems = roleType
                )
            )
            MainOutlinedTextField(
                params = OutlinedTextFieldClass(
                    value = registerRequest.dateOfBirth,
                    onValueChange = { registerRequest = registerRequest.copy(dateOfBirth = it) },
                    label = "Date of birth",
                    isDatePicker = true
                )
            )
            MainOutlinedTextField(
                params = OutlinedTextFieldClass(
                    label = "Password",
                    value = registerRequest.password,
                    onValueChange = { newPassword -> registerRequest = registerRequest.copy(password = newPassword) },
                    keyboardType = KeyboardType.Password,
                    isPasswordField = true,
                    isPasswordVisible = isPasswordVisible,
                    onVisibilityToggle = { isPasswordVisible = !isPasswordVisible }
                )
            )
            MainOutlinedTextField(
                params = OutlinedTextFieldClass(
                    label = "Confirm password",
                    value = registerRequest.password,
                    onValueChange = { newPassword -> registerRequest = registerRequest.copy(password = newPassword) },
                    keyboardType = KeyboardType.Password,
                    isPasswordField = true,
                    isPasswordVisible = isPasswordVisible,
                    onVisibilityToggle = { isPasswordVisible = !isPasswordVisible }
                )
            )
            AppButton("Create account ",onClick={
                val errorMessage = validator.registervalidationInfo(registerRequest)
                if (errorMessage != null){
                    Toast.makeText(context , errorMessage, Toast.LENGTH_LONG ).show()
                }else{
                    //view model
                }
            })
            StaticRow {
                PrimaryText("Have you an account ?" , Color.Black)
                PrimaryText(" Login" , PrimaryColor , Modifier.clickable { NavigationActions.navigateToLogin(navController)})
            }
        }
    }
}