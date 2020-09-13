package com.grubbrr.demo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grubbrr.demo.model.MenuModel

@Dao
interface CategoryImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categoryImage: MenuModel.CategoryImage)

    @Query("SELECT * FROM CategoryImage")
    fun getAll(): MutableList<MenuModel.CategoryImage>
}
