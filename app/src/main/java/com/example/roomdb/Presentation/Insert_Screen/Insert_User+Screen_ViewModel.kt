package com.example.roomdb.Presentation.Insert_Screen


import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.roomdb.Data.Person
import com.example.roomdb.Data.Person_Repository
import kotlinx.coroutines.launch


class Insert_Users_Screen_textfield_ViewModel(private val repository: Person_Repository) : ViewModel() {

    var name by mutableStateOf("")
    fun updateName(value: String) {
        name = value
    }

    var Age by mutableStateOf("")
    fun updateAge(value: String) {
        Age = value
    }

    var Phone_number by mutableStateOf("")
    fun updatePhone(value: String) {
        Phone_number = value
    }

    var course by mutableStateOf("")
    fun updateCourse(value: String) {
        course = value
    }

    var email by mutableStateOf("")
    var email_error by mutableStateOf(" ")
    fun updateEmail(value: String) {
        email = value
    }

    var password by mutableStateOf("")
    var password_error by mutableStateOf(" ")
    fun updatePassword(value: String) {
        password = value
    }



    private fun validate_Email(): Boolean {
        val emailValue = email.trim()
        var isValid = true
        var errorMessage = ""
        if (emailValue.isEmpty() || emailValue.isBlank()) {
            errorMessage = "Please fill the email field "
            isValid = false
        } else if (
            !Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()
        ) {
            errorMessage = "Wrong Email format "
            isValid = false
        }
        email_error = errorMessage
        return isValid
    }

    private fun validate_Password(): Boolean {
        val password = password.trim()
        var isValid = true
        var passwordError = ""
        if (password.isBlank() || password.isEmpty()) {
            passwordError = "Please enter your password"
            isValid = false
        } else if (
            password.length < 6
        ) {
            passwordError = "Password cannot have less than 6 characters"
            isValid = false
        }
        password_error = passwordError
        return isValid
    }

    fun submitInfo(): Boolean {
        if ( validate_Email() && validate_Password()) {
            val person = Person(
                Name = name,
                Age = Age,
                Phone_number = Phone_number.toIntOrNull(),
                Course = course,
                Email = email,
                Password = password,
            )
            insertUser(person)
            return true
        }
        return true
    }
    private fun insertUser(person: Person) {
        Log.d("Insert", "insertUser: ViewModel Called  ")
        viewModelScope.launch {
            repository.insertUser(person)
        }
    }
}

