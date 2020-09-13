package com.grubbrr.demo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grubbrr.demo.model.MenuModel

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: MenuModel.Item)

    @Query("SELECT * FROM Item")
    fun getAll(): MutableList<MenuModel.Item>
}
