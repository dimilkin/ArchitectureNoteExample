package com.rilexo.architecturenoteexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "com.rilexo.architecturenoteexample.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.rilexo.architecturenoteexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.rilexo.architecturenoteexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.rilexo.architecturenoteexample.EXTRA_PRIORITY";
    private static final int MIN_NOTE_PRIORITY_INDEX = 1;
    private static final int MAX_NOTE_PRIORITY_INDEX = 10;
    private static final int DEFAULT_VALUE = -1;

    private EditText textTitle, textDescription;
    private NumberPicker numPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        textTitle = findViewById(R.id.edit_text_title);
        textDescription = findViewById(R.id.edit_text_content);
        numPicker = findViewById(R.id.number_picker_priority);

        numPicker.setMinValue(MIN_NOTE_PRIORITY_INDEX);
        numPicker.setMaxValue(MAX_NOTE_PRIORITY_INDEX);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            textTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            textDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numPicker.setValue(intent.getIntExtra(EXTRA_PRIORITY, DEFAULT_VALUE));
        } else {
            setTitle("Add Note");
        }
    }



    private void saveNote() {
        String title = textTitle.getText().toString();
        String description = textDescription.getText().toString();
        int priority = numPicker.getValue();

        if (title.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        int id = getIntent().getIntExtra(EXTRA_ID, DEFAULT_VALUE);
        if ( id != DEFAULT_VALUE){
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
