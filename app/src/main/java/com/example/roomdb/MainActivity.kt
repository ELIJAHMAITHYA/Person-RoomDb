package com.example.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.roomdb.Presentation.Insert_Screen.Insert_User_Screen
import com.example.roomdb.Presentation.Insert_Screen.Insert_Users_Screen_textfield_ViewModel
import com.example.roomdb.ui.theme.RoomDbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: Insert_Users_Screen_textfield_ViewModel by viewModels()
        setContent {

            RoomDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Insert_User_Screen(viewModel= viewModel)
            }
        }
    }}}

