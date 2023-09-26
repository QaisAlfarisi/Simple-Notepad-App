package com.example.app_notepad2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class NotepadActivity extends AppCompatActivity{
    private EditText editText;
    RadioGroup rb_priority;
    private RadioButton rb_penting, rb_tidak;
    private Button saveButton, viewButton, aboutButton;
    private ListView listView;
    private ArrayList<String> notesList;
    private ArrayAdapter<String> notesAdapter;

    FragmentAbout about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        editText = findViewById(R.id.editText);
        rb_priority = findViewById(R.id.rb_priority);
        rb_penting = findViewById(R.id.rb_penting);
        rb_tidak = findViewById(R.id.rb_tidak);
        saveButton = findViewById(R.id.saveButton);
        viewButton = findViewById(R.id.viewButton);
        aboutButton = findViewById(R.id.aboutButton);
        listView = findViewById(R.id.listView);

        about = new FragmentAbout();

        notesList = new ArrayList<>();
        notesAdapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.item_text_view, notesList);
        listView.setAdapter(notesAdapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editText.getText().toString();
                if (note.isEmpty()) {
                    Toast.makeText(NotepadActivity.this, "Note cannot be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    String priority = rb_penting.isChecked() ? "Penting" : "Tidak Penting";

                    notesList.add(note + " (" + priority + ")");
                    notesAdapter.notifyDataSetChanged();

                    Toast.makeText(NotepadActivity.this, "Note saved!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotepadActivity.this, ViewActivity.class);
                intent.putStringArrayListExtra("notesList", notesList);
                startActivity(intent);
            }
        });
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_layout, about);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

}
