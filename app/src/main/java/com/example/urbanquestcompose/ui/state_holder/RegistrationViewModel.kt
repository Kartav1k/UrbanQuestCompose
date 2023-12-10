package com.example.urbanquestcompose.ui.state_holder


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.urbanquestcompose.data.models.UserData

class RegistrationViewModel: ViewModel() {
    val userLiveData: MutableLiveData<UserData> = MutableLiveData()
    fun registerUser(user: UserData){
        userLiveData.postValue(user)
    }
}