package com.raviowl.mvvmkotlin.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raviowl.mvvmkotlin.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],   // Which entities are we using in this database
    version = 1                         // Version for this Database
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao() : ShoppingDao

    companion object{
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        // When ever shoppingDatabase is invoked...
        // ... return the singlelton instance, if null then create new
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
            instance
                ?: createDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db").build()


    }

}