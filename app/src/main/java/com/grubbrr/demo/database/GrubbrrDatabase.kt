package com.grubbrr.demo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.grubbrr.demo.database.dao.*
import com.grubbrr.demo.model.MenuModel
import com.grubbrr.demo.model.OrderModel
import com.grubbrr.demo.utility.Constants

@Database(
    entities = [
        MenuModel.CategoryMaster::class,
        MenuModel.CategoryImage::class,
        MenuModel.Item::class,
        MenuModel.ItemImage::class,
        MenuModel.ItemCategoryMapping::class,
        OrderModel.Order::class
    ],
    version = 1
)
abstract class GrubbrrDatabase : RoomDatabase() {

    abstract fun categoryMasterDao(): CategoryMasterDao
    abstract fun categoryImageDao(): CategoryImageDao
    abstract fun itemDao(): ItemDao
    abstract fun itemImage(): ItemImageDao
    abstract fun itemCategoryMappingDao(): ItemCategoryMappingDao
    abstract fun orderDao(): OrderDao

    companion object {

        private var ourInstance: GrubbrrDatabase? = null

        fun getInstance(context: Context): GrubbrrDatabase? {
            if (ourInstance == null) {
                synchronized(GrubbrrDatabase::class.java) {
                    if (ourInstance == null) {
                        ourInstance = Room.databaseBuilder(
                            context,
                            GrubbrrDatabase::class.java,
                            Constants.DB_NAME
                        )
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .setJournalMode(JournalMode.TRUNCATE)
                            .build()
                    }
                }
            }
            return ourInstance
        }
    }
}
