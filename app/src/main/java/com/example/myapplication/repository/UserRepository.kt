package com.example.myapplication.repository

import com.example.myapplication.dao.UserDao
import com.example.myapplication.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {

    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun addUser(user: User){
        coroutine.launch(Dispatchers.IO) {
            userDao.insert(user)
        }

    }
}