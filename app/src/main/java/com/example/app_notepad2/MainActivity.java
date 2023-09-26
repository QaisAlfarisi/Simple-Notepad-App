package com.example.app_notepad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText inp_username, inp_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp_username = findViewById(R.id.inp_username);
        inp_password = findViewById(R.id.inp_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inp_username.getText().toString();
                String password = inp_password.getText().toString();

                if (username.equals("admin") && password.equals("admin123")) {
                    Intent intent = new Intent(MainActivity.this, NotepadActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Login successful as admin", Toast.LENGTH_SHORT).show();
                } else if (username.equals("user") && password.equals("user123")) {
                    Intent intent = new Intent(MainActivity.this, NotepadActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Login successful as user", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}