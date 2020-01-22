package com.rilexo.architecturenoteexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllnotes();
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }

    public void updat(Note note){
        noteRepository.update(note);
    }

    public void delete(Note note){
        noteRepository.delete(note);
    }

    public void deleteAll(){
        noteRepository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
