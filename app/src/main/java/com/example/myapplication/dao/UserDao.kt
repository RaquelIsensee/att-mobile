package com.example.myapplication.dao

import androidx.room.*
import com.example.myapplication.entity.User


@Dao
interface UserDao {
     @Insert
      fun insert(user: User)

     @Update
      fun update(user: User)

     @Delete
      fun delete(user: User)

     @Query("select * from user u order by u.name")
      fun findAll(): List<User>

     @Query("select * from user u where u.name = :name")
      fun findByName(name: String): User
}