package com.sp.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CS50 lesson 2
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PokedexAdapter2(getApplicationContext());//default cause dont have constructor //new for class mah.
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager); //check where this come from.








        //CS50 lesson 1.
        /*List<Track1> myTrack1 = new ArrayList<>();
        myTrack1.add(new Track1("Mobile","Tommy")); //creating a new track. To call the methods inside. //also initialising ,ah
        //to tell them you want a new one also.
        myTrack1.add(new Track1("Web","Brian"));
        myTrack1.add(new Track1("Games", "Colten"));

        for(Track1 track: myTrack1){
            Log.d("track","Name is : " + track.getName()+ " & instructor name is : " + track.getInstructor() );
        }
        List<String> students = Arrays.asList("Harry","Ron","Hermoine"); //static array List dont need new .
        Map<String,Track1> assignments = new HashMap<>();
        for(String student : students){
            Log.d("students", "Student is : " + students); //build cannot must run then compiler will respond.
        }

        Random random = new Random();
        for(String student:students){ //Looping all the internal attributes
            int index = random.nextInt(myTrack1.size()); //ANY NUMMBER FROM THE THE LIST.
            assignments.put(student,myTrack1.get(index));
        }
        for(Map.Entry<String, Track1> entry : assignments.entrySet()){
            Log.d("cs50", entry.getKey()+ "got "+ entry.getValue().getName()+ "with" + entry.getValue().getInstructor())   ;
        }*/
    }
}