package com.example.grocerylistmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static GroceryListDatabase groceryListDatabase;

    RecyclerView listView;
    RecycleAdapter recAdapter;

    ArrayList<String> titles = new ArrayList<>();
    Button but;
    EditText newListName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groceryListDatabase = Room.databaseBuilder(getApplicationContext(), GroceryListDatabase.class, "grocerylistdb")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
//        titles.add("Stop n Shop");
        DisplayMetrics dm =  this.getResources().getDisplayMetrics();
        EditText nameField = findViewById(R.id.listNameField);
        listView = findViewById(R.id.recyclerViewList);

        nameField.setWidth(dm.widthPixels-nameField.getWidth()-500);

        listView.setMinimumHeight(dm.heightPixels-nameField.getHeight());
        listView.setLayoutManager(new LinearLayoutManager(this));

        recAdapter = new RecycleAdapter(this, titles);
        listView.setAdapter(recAdapter);

        List<GroceryListTable> groceryLists = groceryListDatabase.groceryListDao().getLists();

        for (GroceryListTable list: groceryLists){
            titles.add(list.getName());

            Log.d("TAG", list.getName());
        }



        Log.d("list size", String.valueOf(titles.size()));




        titles.add("Western Beef");


        final EditText newListName = findViewById(R.id.listNameField);



        but = findViewById(R.id.addButton);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!newListName.getText().equals("")){
                    String listName = newListName.getText().toString();

                    titles.add(listName);
                    newListName.setText("");
                    recAdapter.notifyDataSetChanged();

                    GroceryListTable groceryListTable = new GroceryListTable();
                    groceryListTable.setName(listName);
                    groceryListDatabase.groceryListDao().addList(groceryListTable);

                    Toast.makeText(getApplicationContext(), listName + " Successfully Created", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter a valid name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final int NAVIGATE_LIST = 0;
        final int RENAME_LIST = 1;
        final int DELETE_LIST = 2;

        switch (item.getItemId()){
            case NAVIGATE_LIST:
                Intent intent = new Intent(this, listItem.class);
                intent.putExtra("Title",titles.get(item.getGroupId()));
                startActivity(intent);
                return true;
            case RENAME_LIST:
                renameItem(item, item.getGroupId());
                return true;
            case DELETE_LIST:
                groceryListDatabase.groceryListDao().deleteList(titles.get(item.getGroupId()));
                recAdapter.remove(item.getGroupId());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void renameItem(MenuItem item, int pos){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Enter New Name");
        final int tempPos = pos;
        final EditText newName = new EditText(this);
        alert.setView(newName);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recAdapter.renameItem(newName.getText().toString(), tempPos);
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }

}