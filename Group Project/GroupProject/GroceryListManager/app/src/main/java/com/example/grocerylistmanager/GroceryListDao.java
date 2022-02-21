package com.example.grocerylistmanager;

import androidx.room.*;

import java.util.List;

@Dao
public interface GroceryListDao {
    @Query("SELECT * FROM grocery_list")
    List<GroceryListTable> getLists();

    @Insert
    void addList(GroceryListTable groceryList);

    @Update
    void updateList(GroceryListTable groceryList);

    @Query("Delete from grocery_list where list_name like :name")
    void deleteList(String name);
}
