package com.sp.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

class NotesAdapter5 extends RecyclerView.Adapter<NotesAdapter5.NoteViewHolder> {
  private List<Note5> note = new ArrayList<>(); //Creating an empty list.

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row,parent,false);

        return new NoteViewHolder(view); //Method call expected --> New (CAUSE IT IS AN CONSTRUCTOR. )
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note5 current = note.get(position);
        holder.textView.setText(current.content);



    }
    public void reload(){
        note = Notes5.database.noteDAO5().getall(); //return all the notes.
        //Can call /reference it like this when u calll it static.
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return note.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView textView;
        NoteViewHolder(View view){
            super(view);
            linearLayout = view.findViewById(R.id.note_row);
            textView = view.findViewById(R.id.note_row_text);
        }
    }
}
