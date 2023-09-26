package com.example.app_notepad2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity{

    private GridView gridView;
    private ArrayList<String> notesList;
    private NoteAdapter noteAdapter;

    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        gridView = findViewById(R.id.gridView);
        notesList = getIntent().getStringArrayListExtra("notesList");
        noteAdapter = new NoteAdapter(this, notesList);
        gridView.setAdapter(noteAdapter);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this, NotepadActivity.class);
                startActivity(intent);
            }
        });
    }


}
