package com.example.grocerylistmanager;

import android.content.Context;

import androidx.room.*;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {GroceryListTable.class, GroceryItemTable.class, GroceryItemTypeTable.class}, version = 4)
public abstract class GroceryListDatabase extends RoomDatabase {
    private static GroceryListDatabase INSTANCE;
    public static GroceryListDatabase groceryListDatabase;
    public abstract GroceryListDao groceryListDao();
    public abstract GroceryItemDao groceryItemDao();



}
