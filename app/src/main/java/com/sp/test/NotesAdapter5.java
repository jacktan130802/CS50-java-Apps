package com.sp.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

class NotesAdapter5 extends RecyclerView.Adapter<NotesAdapter5.NoteViewHolder> {

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row,parent,false);

        return NoteViewHolder(view);//sfa
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
