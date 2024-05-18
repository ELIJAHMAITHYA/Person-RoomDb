package com.example.roomdb.ui.theme

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdb.Person_Application
import com.example.roomdb.Presentation.Insert_Screen.Insert_Users_Screen_textfield_ViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            Insert_Users_Screen_textfield_ViewModel(
                person_Application().container.personRepository
            )
        }
    }
}

fun CreationExtras.person_Application(): Person_Application =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as Person_Application)