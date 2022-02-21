//package com.example.grocerylistmanager;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//
//import androidx.room.Room;
//
//
//import android.content.Context;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.room.Room;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//import android.os.Bundle;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GroceryLists extends AppCompatActivity {
//    public static GroceryListDatabase groceryListDatabase;
//
//
//    private ArrayList<String> lists;
//    private RecyclerView recyclerView;
//    private Button addBtn;
//    private Button goBtn;
//    private Intent intent;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_grocery_lists);
//        groceryListDatabase = Room.databaseBuilder(getApplicationContext(), GroceryListDatabase.class, "grocerylistdb")
//                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
//
//        intent = new Intent(GroceryLists.this, GroceryItem.class);
//        recyclerView = findViewById(R.id.recyclerView);
//        addBtn = findViewById(R.id.addBtn);
//
//
//        /*
//        goBtn = findViewById(R.id.nextButton);
//        goBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GroceryLists.this.startActivity(intent);
//            }
//        });
//        */
//        final EditText input = findViewById(R.id.nameList);
////        addBtn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                addList(view);
////            }
////        });
//        addBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if (!input.equals("")) {
//
//
//                    String listName = input.getText().toString();
//                    lists.add(listName);
//                    input.setText("");
//
//                    GroceryListTable groceryListTable = new GroceryListTable();
//                    groceryListTable.setName(listName);
//                    groceryListDatabase.groceryListDao().addList(groceryListTable);
//
//                    Toast.makeText(getApplicationContext(), listName + " Successfully Created", Toast.LENGTH_SHORT).show();
//
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "Enter a valid name", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        }
//
//        );
//
//        lists = new ArrayList<>();
//        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        final recyclerAdapter recyclerAdapter = new recyclerAdapter((ArrayList<String>) lists);
//
////        ArrayList<String> listNames = new ArrayList<>();
//
//        List<GroceryListTable> groceryLists = this.groceryListDatabase.groceryListDao().getLists();
//
//        for (GroceryListTable list: groceryLists){
//            lists.add(list.getName());
//        }
//        Log.d("list size", String.valueOf(lists.size()));
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(recyclerAdapter);
//        recyclerAdapter.setOnListClickListener(new recyclerAdapter.OnListClickListener() {
//            @Override
//            public void onListClick(int position) {
//                GroceryLists.this.startActivity(intent);
//                String listName = lists.get(position);
//                intent.putExtra("list", listName);
//
//                //Toast.makeText(getApplicationContext(), lists.get(position) + position, Toast.LENGTH_SHORT).show();
//                //lists.add(position, "clicked");
//                //lists.remove(position + 1);
//                //recyclerAdapter.notifyItemChanged(position);
//            }
//
//            @Override
//            public void onDeleteClick(int position) {
//                //lists.add(position, "clicked");
//                String listName = lists.get(position);
//                intent.removeExtra("list");
//                lists.remove(position);
//                groceryListDatabase.groceryListDao().deleteList(listName);
//                recyclerAdapter.notifyDataSetChanged();
//
//                Toast.makeText(getApplicationContext(), listName+ " deleted", Toast.LENGTH_SHORT).show();
//
//                // recyclerAdapter.notifyItemChanged(position);
//            }
//        });
//
//    }
////    private void addList(View view) {
//////        int i = 1222123;
////        EditText input = findViewById(R.id.nameList);
////        String name = input.getText().toString();
////        if(!(name.equals(""))){
////            //Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
////            lists.add(name);
////            input.setText("");
//////
//////            GroceryListTable groceryListTable = new GroceryListTable();
////////            groceryListTable.setId(i++);
//////            groceryListTable.setName(input.getText().toString());
//////
//////            this.groceryListDatabase.groceryListDao().addList(groceryListTable);
//////
//////            Log.d("list names", groceryListTable.getName());
////        }
////        else{
////            Toast.makeText(getApplicationContext(), "Enter a valid name", Toast.LENGTH_SHORT).show();
////        }
////
////    }
//
//
////    private void viewLists(){
////
////        TextView textView = findViewById(R.id.listsName);
////
////        GroceryListTable groceryListTable = new GroceryListTable();
////        List<GroceryListTable> groceryLists = this.groceryListDatabase.groceryListDao().getLists();
////
////        for (GroceryListTable list: groceryLists){
////            textView.setText(list.getName());
////        }
////    }
//
//
//
//
//
//
//
//
//
//
//}
//
