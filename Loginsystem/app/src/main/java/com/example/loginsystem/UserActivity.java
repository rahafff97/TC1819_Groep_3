package com.example.loginsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class UserActivity extends AppCompatActivity {
    GoogleSignInClient mGoogleSignClient;
    Button sign_out;
    TextView emailTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        emailTV = findViewById(R.id.email);
        sign_out = findViewById(R.id.log_out);
        /* Configure sign-in to request the user's ID, email address, and basic*/
        /* profile. ID and basic profile are included in DEFAULT_SIGN_IN.*/
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(UserActivity.this);
        //check Hr account or not
        String personEmail = acct.getEmail();
        if (acct != null && personEmail.endsWith("@hr.nl")) {
            String personName = acct.getDisplayName();
            personEmail = acct.getEmail();

            emailTV.setText("Email: "+personEmail);
        }


        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }

        });
    }

    private void signOut() {
        mGoogleSignClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(UserActivity.this, "Succesfully signed out", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UserActivity.this, LoginActivity.class));
                    }
                });
        Toast.makeText(UserActivity.this, "Succesfully signed out", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(UserActivity.this, LoginActivity.class));
    }
}
