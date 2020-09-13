package com.grubbrr.demo.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

class OrderModel {

    @Entity(indices = [Index(value = arrayOf("categoryId"), unique = true)])
    class Order {
        @NonNull
        @PrimaryKey
        var categoryId = ""
        var itemId = ""
        var categoryName = ""
        var itemName = ""
        var itemImageUrl = ""
        var itemPrice = ""
        var quantity = ""
        var orderTotal = ""
    }
}