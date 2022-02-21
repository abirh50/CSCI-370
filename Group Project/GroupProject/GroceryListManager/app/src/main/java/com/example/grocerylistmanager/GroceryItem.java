//package com.example.grocerylistmanager;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.fragment.app.FragmentManager;
//import androidx.room.Room;
//
//import android.os.Bundle;
//import android.text.Layout;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.PopupWindow;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GroceryItem extends AppCompatActivity implements View.OnClickListener {
//    public static FragmentManager fragmentManager;
//    public static GroceryListDatabase groceryListDatabase;
//    private Button sB;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        Bundle extras = getIntent().getExtras();
//        String listClicked = "";
//        if (extras != null) {
//            listClicked = extras.getString("list");
//        }
//
//        Log.d("list clicked: ", listClicked);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_grocery_item);
//        fragmentManager = getSupportFragmentManager();
//        groceryListDatabase = Room.databaseBuilder(getApplicationContext(), GroceryListDatabase.class, "grocerylistdb")
//                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
//        if (findViewById(R.id.fragment_container) != null){
//            if (savedInstanceState != null){
//                return;
//            }
//            fragmentManager.beginTransaction().add(R.id.fragment_container, new ItemsFragment()).commit();
//        }
//
//        sB = findViewById(R.id.btnSearch);
//        sB.setOnClickListener(this);
//
//        ArrayList<String> items = new ArrayList<>();
////        List<GroceryListTable> groceryLists = this.groceryListDatabase.groceryListDao().getLists();
//
//        GroceryItemTable groceryItemTable = new GroceryItemTable();
//        groceryItemTable.setList_name(listClicked);
//        groceryItemTable.setItemName("milk");
//        groceryItemTable.setItemType("dairy");
//        groceryListDatabase.groceryItemDao().addItem(groceryItemTable);
//
//        List<GroceryItemTable> groceryItemTables = groceryListDatabase.groceryItemDao().getItemsOfList(listClicked);
//
//        for (GroceryItemTable itemTable: groceryItemTables){
//            items.add(itemTable.getItemName());
////            groceryListDatabase.groceryItemDao().deleteItem(groceryItemTable);
//        }
//
//        for (int i = 0 ; i < items.size() ;  i++) {
//                TextView item = new TextView(this);
//                item.setText(items.get(i));
//                item.setTextSize(18);
//                item.setMinimumHeight(150);
//                item.setMinimumWidth(150);
//                LinearLayout linearLayout = findViewById(R.id.fragment_container);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                lp.setMargins(1, 100, 1, 1);
//
//                linearLayout.addView(item, lp);
//            }
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btnSearch:
//                Log.d("btnsearch", "onClick: clicked ");
//                GroceryItem.fragmentManager.beginTransaction().replace(R.id.fragment_container,
//                        new  SearchItemsFragment()).addToBackStack(null).commit();
//                break;
//        }
//    }
//}