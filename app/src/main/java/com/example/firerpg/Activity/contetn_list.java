package com.example.firerpg.Activity;

import android.os.Bundle;

import com.example.firerpg.Data.DatabaseHandler;
import com.example.firerpg.Model.Grocery;
import com.example.firerpg.UI.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;

import com.example.firerpg.R;

import java.util.ArrayList;
import java.util.List;

public class contetn_list extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Grocery> groceriesList;
    private List<Grocery> ListItems;
    private DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contetn_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        db = new DatabaseHandler(this);

        recyclerView = (RecyclerView) findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        groceriesList = new ArrayList<>();
        ListItems = new ArrayList<>();

        groceriesList = db.getAllGroceries();

        for(Grocery c : groceriesList){

            Grocery grocery = new Grocery();
            grocery.setName(c.getName());
            grocery.setQuantity("Qty: " + c.getQuantity());
            grocery.setDateItemAdded("Added on: "+ c.getDateItemAdded());

            ListItems.add(grocery);

        }

        adapter = new RecyclerViewAdapter(this, ListItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();










    }

}
