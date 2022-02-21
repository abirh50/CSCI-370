package com.example.grocerylistmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GroceryItemDao {
    @Query("SELECT * FROM item")
    List<GroceryItemTable> getItems();

    @Query("SELECT * FROM item where item_type like :itemType")
    List<GroceryItemTable> getItemsInItemType(String itemType);

    @Query("select * from item where list_name like :list")
    List<GroceryItemTable> getItemsOfList(String list);

    @Insert
    void addItem(GroceryItemTable groceryItemTable);

    @Delete
    void deleteItem(GroceryItemTable groceryItemTable);
}
