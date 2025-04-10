package com.mhx.learnix.data.model.utils

import com.mhx.learnix.data.model.LoginRequest

class LoginValidateInfo {
    fun validateLoginInfos(request : LoginRequest) : String?{
        return when {
            request.email.isBlank() && request.password.isBlank() ->{
                "Please enter your information"
            }
            request.email.isBlank() ->{
                "Please enter your email"
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(request.email).matches() ->{
                "Please enter a valid email"
            }
            request.password.isBlank() ->{
                "Please enter your password"
            }
            request.password.length < 6 ->{
                "Your password length is too short"
            }
            else -> null
        }
    }
}