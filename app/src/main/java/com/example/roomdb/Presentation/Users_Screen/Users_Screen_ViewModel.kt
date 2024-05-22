package com.example.roomdb.Presentation.Users_Screen

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.Data.Person_Repository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class Users_Screen_ViewModel (personRepository: Person_Repository): ViewModel(){
    val users = personRepository.getAllUsers() .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}