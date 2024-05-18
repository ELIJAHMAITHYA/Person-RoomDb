package com.example.roomdb.Data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val personRepository: Person_Repository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val personRepository: Person_Repository by lazy {
        Person_Repository(Person_Database.getDatabase(context).userDao())
    }
}