package com.grubbrr.demo.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MenuModel {

    @SerializedName("CategoryMasters")
    @Expose
    var categoryMasterList: List<CategoryMaster> = arrayListOf()

    @SerializedName("CategoryImages")
    @Expose
    var categoryImageList: List<CategoryMaster> = arrayListOf()

    @SerializedName("Items")
    @Expose
    var itemList: List<CategoryMaster> = arrayListOf()

    @SerializedName("ItemImages")
    @Expose
    var itemImageList: List<CategoryMaster> = arrayListOf()

    @SerializedName("Item_Category_Mappings")
    @Expose
    var itemCategoryMappingList: List<CategoryMaster> = arrayListOf()

    @Entity(indices = [Index(value = arrayOf("categoryId"), unique = true)])
    class CategoryMaster {

        @NonNull
        @PrimaryKey
        @SerializedName("CategoryID")
        @Expose
        var categoryId = ""

        @SerializedName("Name")
        @Expose
        var name = ""

        @SerializedName("Description")
        @Expose
        var description = ""

        @SerializedName("DisplayOrder")
        @Expose
        var displayOrder = ""

        @SerializedName("IsActive")
        @Expose
        var active = ""
    }

    @Entity(indices = [Index(value = arrayOf("categoryImageId"), unique = true)])
    class CategoryImage {

        @NonNull
        @PrimaryKey
        @SerializedName("CImgID")
        @Expose
        var categoryImageId = ""

        @SerializedName("ImageUrl")
        @Expose
        var imageUrl = ""

        @SerializedName("CategoryID")
        @Expose
        var categoryId = ""
    }

    @Entity(indices = [Index(value = arrayOf("itemId"), unique = true)])
    class Item {

        @NonNull
        @PrimaryKey
        @SerializedName("ItemID")
        @Expose
        var itemId = ""

        @SerializedName("Name")
        @Expose
        var name = ""

        @SerializedName("Price")
        @Expose
        var price = ""

        @SerializedName("IsActive")
        @Expose
        var active = ""
    }

    @Entity(indices = [Index(value = arrayOf("itemImageId"), unique = true)])
    class ItemImage {

        @NonNull
        @PrimaryKey
        @SerializedName("IImgID")
        @Expose
        var itemImageId = ""

        @SerializedName("ImageUrl")
        @Expose
        var imageUrl = ""

        @SerializedName("ItemID")
        @Expose
        var itemId = ""
    }

    @Entity(indices = [Index(value = arrayOf("pcMappingId"), unique = true)])
    class ItemCategoryMapping {

        @NonNull
        @PrimaryKey
        @SerializedName("PCMappingID")
        @Expose
        var pcMappingId = ""

        @SerializedName("ItemID")
        @Expose
        var itemID = ""

        @SerializedName("CategoryID")
        @Expose
        var categoryID = ""

        @SerializedName("DisplayOrder")
        @Expose
        var displayOrder = ""
    }
}