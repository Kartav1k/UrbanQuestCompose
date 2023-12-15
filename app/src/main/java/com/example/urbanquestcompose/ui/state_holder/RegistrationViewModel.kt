package com.example.urbanquestcompose.ui.state_holder


import androidx.lifecycle.ViewModel
import com.example.urbanquestcompose.data.models.UserData

class RegistrationViewModel: ViewModel() {
    lateinit var userLiveData: UserData
    fun registerUser(user: UserData){
        userLiveData = user
    }
}