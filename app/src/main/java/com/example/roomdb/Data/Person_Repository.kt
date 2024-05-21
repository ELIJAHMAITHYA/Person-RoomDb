package com.example.roomdb.Data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdb.Presentation.Insert_Screen.Insert_Users_Screen_textfield_ViewModel

class Person_Repository(private val personDao: UserDao) {
    val allUsers: LiveData<List<Person>> = personDao.getAllUsers()

   fun findByName(name: String): LiveData<List<Person>> {
        return personDao.findByName(name)
    }

   fun findByCourse(course: String): LiveData<List<Person>> {
        return personDao.FindByCourse(course)
    }

    fun findByAge(age: Int): LiveData<List<Person>> {
        return personDao.FindByAge(age)
    }

    suspend fun insertUser(person: Person) {
        Log.d("Insert", "insertUser: repository Called  ")
        personDao.InsertUser(person)
    }

    suspend fun deleteUser(person: Person) {
        personDao.DeletePerson(person)
    }
}



