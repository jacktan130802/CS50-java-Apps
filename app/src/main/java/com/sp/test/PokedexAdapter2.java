package com.sp.test;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokedexAdapter2 extends RecyclerView.Adapter<PokedexAdapter2.ViewHolder> {

public static class ViewHolder extends RecyclerView.ViewHolder{ //view holder is to hold the views.
    private LinearLayout containerView;
    private TextView textView;

    public LinearLayout getContainerView() {
        return containerView;
    }

    public TextView getTextView() {
        return textView;
    }


    public ViewHolder(View view){//view is builtin class. Viewholder needs to talk to xml, using view so can easily talk.
        super(view);
        containerView = view.findViewById(R.id.linearlayout);
        textView = view.findViewById(R.id.textView2);
        containerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pokemon2 current = (Pokemon2) containerView.getTag(); //casting. (Get tag is to get all the indormation in the linear layout)
                Intent intent = new Intent(v.getContext(),PokemonActivity2.class);
                intent.putExtra("name", current.getName());
                intent.putExtra("url", current.getNumber());
                v.getContext().startActivity(intent);
            }
        });
    }//converting the xml to something we can use.
}


//Using and creating a static array.
/*    private List<Pokemon2> myPokemon = Arrays.asList(
            new Pokemon2("Jack",1),
            new Pokemon2("Vincent",2),
            new Pokemon2("Evon",3)
    );*/


    //Creating a dynamic list
    private List<Pokemon2>  myPokemon = new ArrayList<>();
    private RequestQueue requestQueue;

    PokedexAdapter2(Context context){
        requestQueue = Volley.newRequestQueue(context);
        loadPokemon();
    }

    //Creating a method to lead and add dynamically.
    public void loadPokemon(){
        String url = "https://pokeapi.co/api/v2/pokemon?limit=151;";
        PokemonActivity2 test = new PokemonActivity2();
        //Only works with the correct dependencies.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");

                    //I will jget all the results in the form of an array.
                    for(int i =0; i< results.length();i++){
                        //getting the objects.
                        JSONObject result = results.getJSONObject(i); //declaring that the result is an object.
                        String name = result.getString("name");
                        myPokemon.add(new Pokemon2(
                                //Using the json object function to get from the api with the correct corresponding name there : name and url.
                                name.substring(0,1).toUpperCase() + name.substring(1),
                                //J + ack = Jack;
                                result.getString("url")

                        ));
                    }
                    notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("cs50", "Pokemon List Error");
            }
        });
        requestQueue.add(request);
    }



 // creating the viewHOlder class inside  (CLASS IN A CLASS.)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);//view is used again.
        return new ViewHolder(view); //每个view holder都要用这个view
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//from model to view

        /* Get element from your arraylist at this position and replace the
         contents of the view with that element */
        Pokemon2 current = myPokemon.get(position); //current pokemon using the list.
        holder.textView.setText(current.getName());
        //View holder built in method.
        holder.containerView.setTag(current); //view holder have access to current pokemon.
    }
    @Override
    public int getItemCount() {
        return myPokemon.size();
    }

}
