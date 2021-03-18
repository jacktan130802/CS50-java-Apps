package com.sp.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Notes5 extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private NotesAdapter5 adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes5);
        recyclerView = findViewById(R.id.recycler5);
        layoutManager = new LinearLayoutManager(this);
        adapter = new NotesAdapter5();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}