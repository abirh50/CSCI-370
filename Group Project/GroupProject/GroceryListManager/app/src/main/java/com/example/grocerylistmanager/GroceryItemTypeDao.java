package com.example.grocerylistmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GroceryItemTypeDao {
    @Query("SELECT * FROM item_type")
    List<GroceryItemTypeTable> getItemTypes();

    @Insert
    void addItemType(GroceryItemTypeTable groceryItemTypeTable);

    @Delete
    void deleteItemType(GroceryItemTypeTable groceryItemTypeTable);

}
