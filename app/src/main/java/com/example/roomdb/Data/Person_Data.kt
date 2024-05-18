package com.example.roomdb.Data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update


//Data Entity
@Entity
data class Person(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "Name") val Name: String?,
    @ColumnInfo(name = "Age") val Age: String?,
    @ColumnInfo(name = "Phone Number") val Phone_number: Int?,
    @ColumnInfo(name = "Course") val Course: String?,
    @ColumnInfo(name = "Email") val Email: String?,
    @ColumnInfo(name = "Password") val Password: String?

)


//Data access Object
@Dao
interface UserDao {
    @Query("SELECT * FROM Person ORDER BY Name")
    fun getAllUsers(): LiveData<List<Person>>

    @Query("SELECT * FROM Person where Name LIKE :name Order by Name")
    fun findByName(name: String): List<Person>

    @Query("SELECT * FROM person WHERE Course LIKE :course Order by Name")
    fun FindByCourse(course: String): List<Person>

    @Query("SELECT * FROM person WHERE Age LIKE :age Order by Name")
    fun FindByAge(age: Int): List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertUser(vararg person: Person)

    @Delete
    fun DeletePerson(person: Person)


}

//Database

@Database(version = 1, entities = [Person::class])
abstract class Person_Database : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: Person_Database? = null
        fun getDatabase(context: Context): Person_Database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Person_Database::class.java,
                    "Person_Database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}