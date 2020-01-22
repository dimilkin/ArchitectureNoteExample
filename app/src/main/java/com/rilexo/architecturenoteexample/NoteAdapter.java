package com.rilexo.architecturenoteexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<Note>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.textTitle.setText(currentNote.getTitle());
        holder.textDescription.setText(currentNote.getDescription());
        holder.textPriority.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes (List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView textDescription;
        private TextView textPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textView_title);
            textDescription = itemView.findViewById(R.id.textView_description);
            textPriority = itemView.findViewById(R.id.textView_priority);
        }
    }
}
