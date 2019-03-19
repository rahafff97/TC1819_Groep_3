package com.example.loginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    Button sign_out;
    TextView emailTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        emailTV = findViewById(R.id.email);
        emailTV.setText("Email: " + LoginActivity.Email);

        sign_out = findViewById(R.id.log_out);
        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    private void signOut() {
        Toast.makeText(AdminActivity.this, "Succesfully signed out", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(AdminActivity.this, LoginActivity.class));
    }
}
