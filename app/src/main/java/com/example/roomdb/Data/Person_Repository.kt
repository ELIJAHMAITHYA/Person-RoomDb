package com.example.roomdb.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdb.Presentation.Insert_Screen.Insert_Users_Screen_textfield_ViewModel

class Person_Repository(private val personDao: UserDao) {
    val allUsers: LiveData<List<Person>> = personDao.getAllUsers()

    suspend fun findByName(name: String): List<Person> {
        return personDao.findByName(name)
    }

    suspend fun findByCourse(course: String): List<Person> {
        return personDao.FindByCourse(course)
    }

    suspend fun findByAge(age: Int): List<Person> {
        return personDao.FindByAge(age)
    }

    suspend fun insertUser(vararg person: Person) {
        personDao.InsertUser(*person)
    }

    suspend fun deleteUser(person: Person) {
        personDao.DeletePerson(person)
    }
}



