package com.mhx.learnix.data.model.utils

import com.mhx.learnix.data.model.RegisterRequest

class RegisterValidationInfo {
    fun registervalidationInfo(request : RegisterRequest):String?{
        return when {
            request.fullName.isBlank() && request.email.isBlank() && request.role.isBlank() && request.password.isBlank() ->{
                return "Please fill in the required fields"
            }
            request.fullName.isBlank() ->{
                return "Please enter your name"
            }
            request.role.isBlank()->{
                return " Please select your role"
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(request.email).matches() ->{
                "Please enter a valid email"
            }
            request.password.isBlank()->{
                return "Please enter your password"
            }
            request.password.length <6 ->{
                return "Your password is too short"
            }
            request.dateOfBirth.isBlank() ->{
                return "Please Enter your date of birth"
            }
            else -> null
        }
    }
}