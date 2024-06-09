package com.example.prm392slot8;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private ToggleButton toggleButtonPassword;
    private TextView textViewTitle, textViewEmailLabel, textViewPasswordLabel;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewEmailLabel = findViewById(R.id.textViewEmailLabel);
        textViewPasswordLabel = findViewById(R.id.textViewPasswordLabel);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        toggleButtonPassword = findViewById(R.id.toggleButtonPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        //Set custom typeface
        Typeface customTypeface = Typeface.createFromAsset(getAssets(), "Honk.ttf");
        textViewTitle.setTypeface(customTypeface);

        // Toggle password visibility
        toggleButtonPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Show Password
                editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                // Hide Password
                editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        // Handle login button click
        buttonLogin.setOnClickListener(v -> {
            // Retrieve email and password
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            // Perform login logic here
            // For demonstration, let's assume the login is successful
            boolean loginSuccessful = true;

            if (loginSuccessful) {
                // Display a success message
                String message = "Email: " + email + "\nPassword: " + password + "\nLogin successful";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            } else {
                // Display an error message if login fails
                Toast.makeText(getApplicationContext(), "Login failed. Please try again.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}