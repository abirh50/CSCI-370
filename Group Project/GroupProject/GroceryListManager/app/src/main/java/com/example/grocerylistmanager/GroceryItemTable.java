package com.example.grocerylistmanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "item")
@Dao
public class GroceryItemTable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "item_id")
    public int itemId;

    @ColumnInfo(name = "item_type")
    public String itemType;

    @ColumnInfo(name = "name")
    public String itemName;

    @ColumnInfo(name = "list_name")
    public String list_name;

    @ColumnInfo(name = "quantity")
    public float quantity;

    @ColumnInfo(name = "volume")
    public float volume;

    @ColumnInfo(name = "units")
    public String units;

    @ColumnInfo(name = "is_checked")
    public boolean checked;
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name( String list_name) {
        this.list_name = list_name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


}
