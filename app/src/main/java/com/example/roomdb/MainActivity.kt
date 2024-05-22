package com.example.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdb.Navigation.AppRoutes
import com.example.roomdb.Presentation.Insert_Screen.Insert_User_Screen
import com.example.roomdb.Presentation.Insert_Screen.Insert_Users_Screen_textfield_ViewModel
import com.example.roomdb.Presentation.Users_Screen.Users_Screen
import com.example.roomdb.ui.theme.AppViewModelProvider
import com.example.roomdb.ui.theme.RoomDbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val viewModel: Insert_Users_Screen_textfield_ViewModel = viewModel(
                factory = AppViewModelProvider.Factory
            )
            RoomDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRoutes.InsertUser.route,
        builder = {
            composable(AppRoutes.InsertUser.route) {
                Insert_User_Screen(navController = navController)
            }
            composable(AppRoutes.UsersScreen.route) {
                Users_Screen(navController = navController)
            }
        },
    )
}
