package com.grubbrr.demo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grubbrr.demo.model.MenuModel

@Dao
interface CategoryMasterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categoryMaster: MenuModel.CategoryMaster)

    @Query("SELECT * FROM CategoryMaster")
    fun getAll(): MutableList<MenuModel.CategoryMaster>
}
