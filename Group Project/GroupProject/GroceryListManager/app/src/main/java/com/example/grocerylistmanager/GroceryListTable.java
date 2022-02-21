package com.example.grocerylistmanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = "grocery_list")
@Dao
public class GroceryListTable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "list_id")
    public int lId;

    @ColumnInfo(name = "list_name")
    public String name;



    public int getlId() {
        return lId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
