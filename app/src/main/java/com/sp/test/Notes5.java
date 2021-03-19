package com.sp.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Notes5 extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private NotesAdapter5 adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static NoteDB5 database; //to use the same instance of database. (STATIC MEANS CAN ACCESS THE SAME INSTANCE FROM ALL CLASSES..)



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes5);
        recyclerView = findViewById(R.id.recycler5);
        layoutManager = new LinearLayoutManager(this);
        adapter = new NotesAdapter5();
        database = Room.databaseBuilder(getApplicationContext(),NoteDB5.class, "notes").allowMainThreadQueries().build();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        FloatingActionButton button = findViewById(R.id.addNoteButton);

    }
    public void add(View v) {
        database.noteDAO5().create();
        adapter.reload();
    }

}