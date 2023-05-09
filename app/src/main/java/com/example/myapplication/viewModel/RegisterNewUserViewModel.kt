package com.example.myapplication.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.myapplication.entity.User
import com.example.myapplication.repository.UserRepository

class RegisterNewUserViewModel(private val userRepository: UserRepository):ViewModel() {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun registrar(){
        val newUser = User(name= name, email= email, password= password)
        userRepository.addUser(newUser)
    }
}