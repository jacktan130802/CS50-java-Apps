package com.sp.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PokemonActivity2 extends AppCompatActivity {

    private TextView nameTextView;
    private TextView numberTextView;
    private TextView type1TextView;
    private TextView type2TextView;
    private RequestQueue requestQueue;
    private String url; //Must declare here. Declaring in onCreate cannot access on LOAD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon2);
        url = getIntent().getStringExtra("url");
        requestQueue= Volley.newRequestQueue(getApplicationContext()); //JSON API WORK WITH VOLLEY TO PASS AROUND MAHH

        nameTextView = findViewById(R.id.pokemon_name);
        numberTextView = findViewById(R.id.pokemon_number);
        type1TextView = findViewById(R.id.pokemon_type1);
        type2TextView = findViewById(R.id.pokemon_type2);
        load(); //call the below method.

    }
        //Another continuation of the same API that highlights the type and power.
        //Ysing the url fromm the returned url.

        //The other one nvr set so bring here and set
        public void load() {
            type2TextView.setText(""); //Just a placeholder
            type1TextView.setText("");
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        nameTextView.setText(response.getString("name"));
                        numberTextView.setText(String.format("#%3d",response.getInt("id")));//remember u want to format the numbers
                        JSONArray array =  response.getJSONArray("types");
                        for(int i =0;i<array.length();i++){ //Only got 0 and 1 (seen from API)
                            JSONObject typeEntry = array.getJSONObject(i);
                            int slot =  typeEntry.getInt("slot");
                            String type = typeEntry.getJSONObject("type").getString("name");
                            if(slot==1){
                                type1TextView.setText(type);
                            }
                            else if(slot==2){
                                type2TextView.setText(type);
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("cs50", "Pokemon details Error");
                }
            });
            requestQueue.add(request);
        }

        //Initially when number is used only. Now we using url.
       /* nameTextView.setText(name);
       numberTextView.setText(String.format("#%03d",number))*/; //format to 3dp
        // /*Used when no formatis being usd*/
        // numberTextView.setText(Integer.toString(number)); //Intent is passed as int. You want it to be string

        //Shift+ shift to jump around easily.




}