package com.grubbrr.demo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grubbrr.demo.model.MenuModel

@Dao
interface ItemImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(itemImage: MenuModel.ItemImage)

    @Query("SELECT * FROM ItemImage")
    fun getAll(): MutableList<MenuModel.ItemImage>
}
