package com.example.roomdb.Data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val personRepository: Person_Repository
}


class AppDataContainer(private val context: Context) : AppContainer {

    override val personRepository: Person_Repository by lazy {
        Person_Repository(Person_Database.getDatabase(context).userDao())
    }
}