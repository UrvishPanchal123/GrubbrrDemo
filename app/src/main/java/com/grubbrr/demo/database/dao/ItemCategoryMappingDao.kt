package com.grubbrr.demo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grubbrr.demo.model.MenuModel

@Dao
interface ItemCategoryMappingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(itemCategoryMapping: MenuModel.ItemCategoryMapping)

    @Query("SELECT * FROM ItemCategoryMapping")
    fun getAll(): MutableList<MenuModel.ItemCategoryMapping>
}
