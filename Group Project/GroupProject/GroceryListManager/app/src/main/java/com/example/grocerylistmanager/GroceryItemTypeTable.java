package com.example.grocerylistmanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_type")
@Dao
public class GroceryItemTypeTable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "type_id")
    public int typeId;

    @ColumnInfo(name = "type_name")
    public String typeName;

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


}
