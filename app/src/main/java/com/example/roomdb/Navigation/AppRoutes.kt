package com.example.roomdb.Navigation

sealed class AppRoutes(val route: String) {
    data object InsertUser : AppRoutes("Insert_User_Screen")
    data object UsersScreen : AppRoutes("Users_Screen")
    data object SearchS : AppRoutes("search_screen")
}