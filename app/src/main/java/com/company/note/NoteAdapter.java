package com.company.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>  {

    Context context;
    ArrayList<Note> notes;
    OnNoteListner onNoteListner;

    public  NoteAdapter(Context context,ArrayList<Note> notes,OnNoteListner onNoteListner){
        this.context=context;
        this.notes=notes;
        this.onNoteListner = onNoteListner;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v,onNoteListner);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note = notes.get(position);

        holder.note.setText(note.getNoteText());
        holder.date.setText(note.getNoteDate());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView note,date;
        OnNoteListner onNoteListner;

        public MyViewHolder(@NonNull View itemView,OnNoteListner onNoteListner) {
            super(itemView);

            note=itemView.findViewById(R.id.txt);
            date=itemView.findViewById(R.id.txt1);

            this.onNoteListner = onNoteListner;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            onNoteListner.onNoteClick(getAdapterPosition());


        }
    }
    public interface  OnNoteListner{
        void onNoteClick(int position);
    }
}


