package com.example.grocerylistmanager;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    Intent intent;
    Button returnBut;
    String searchField;

    RecyclerView recycleSearch;
    RecycleAdapterSearch searchAdapter;

    ArrayList<String> brand, type;
    ArrayList<Boolean> selectItem;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        context = this;
        brand = new ArrayList<>();
        type = new ArrayList<>();

        brand.add("Generic");
        type.add("Banana");

        intent = getIntent();
        searchField = intent.getStringExtra("SearchName");

        setTitle("Search: " + searchField);

        returnBut = findViewById(R.id.returnBut);

        returnBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recycleSearch = findViewById(R.id.recycleViewSearchResults);
        recycleSearch.setLayoutManager(new LinearLayoutManager(this));

        searchAdapter = new RecycleAdapterSearch(this, brand, type, selectItem);

        recycleSearch.setAdapter(searchAdapter);

    }
}
