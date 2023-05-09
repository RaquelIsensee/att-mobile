package com.example.myapplication.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.repository.UserRepository

class RegisterNewUserViewModelFactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = AppDatabase.getDatabase(application).userDao()
        val userRepository = UserRepository(dao)
        return RegisterNewUserViewModel(userRepository) as T
    }
}
