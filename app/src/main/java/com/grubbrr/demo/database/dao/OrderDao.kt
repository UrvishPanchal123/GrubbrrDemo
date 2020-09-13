package com.grubbrr.demo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grubbrr.demo.model.OrderModel

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(order: OrderModel.Order)

    @Query("SELECT * FROM `Order`")
    fun getAll(): MutableList<OrderModel.Order>
}
