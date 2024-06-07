package com.android.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    Button logoutButton;
    TextView usernameTextView, welcomeTextView;

    SharedPreferencesHelper sharedPreferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        logoutButton = findViewById(R.id.logoutButton);
        usernameTextView = findViewById(R.id.User);  // Make sure the ID matches your layout
        welcomeTextView = findViewById(R.id.welcomeTextView);

        sharedPreferencesHelper = new SharedPreferencesHelper(this);
        String username = sharedPreferencesHelper.getUsername();

        // Set the username in the TextView
        usernameTextView.setText(username);
        welcomeTextView.setText("Welcome, " + username + "!");

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferencesHelper.setLoggedIn(false);
                sharedPreferencesHelper.setUsername("");

                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}