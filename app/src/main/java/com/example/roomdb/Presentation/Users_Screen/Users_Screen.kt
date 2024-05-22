package com.example.roomdb.Presentation.Users_Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.roomdb.Navigation.AppRoutes
import com.example.roomdb.R
import com.example.roomdb.constants.User_card
import com.example.roomdb.ui.theme.AppViewModelProvider
import com.example.roomdb.ui.theme.RoomDbTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Users_Screen(
    modifier: Modifier = Modifier,
    viewModel: Users_Screen_ViewModel = viewModel(factory = AppViewModelProvider.Users_Factory),
    navController: NavHostController,
) {
    val state = viewModel.users.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Users Screen", fontSize = 30.sp)

                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    navController.navigate(AppRoutes.InsertUser.route)
                },
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add user")
                Text(text = " Add User")

            }
        },

        ) { paddingValues ->
        if (state.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state) { Person ->
                    User_card(Person)
                }
            }
        } else {
            Column(
                modifier =
                Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.man),
                    contentDescription = "no Users ",
                    modifier = Modifier.size(100.dp),
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Click the Floating Button to add User",
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun user_Screen_Preview() {
    RoomDbTheme {
        Users_Screen(navController = rememberNavController())
    }
}