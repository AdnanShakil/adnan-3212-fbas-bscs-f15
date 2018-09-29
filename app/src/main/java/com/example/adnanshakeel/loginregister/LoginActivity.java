package com.example.adnanshakeel.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +

                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");
private Button btnRegister;
private Button btnLogin;
private EditText txtPassword;
private TextView txtEmail;
String str1,str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegister=findViewById(R.id.btnRegister);
        btnLogin=findViewById(R.id.btnLogin);
        txtPassword=findViewById(R.id.txtPassward);
        txtEmail=findViewById(R.id.txtEmail);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                if (validateEmail() && validatePassword())

                {
                    Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);



                }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    // Function Definations
    private boolean validateEmail() {
        str1=txtEmail.getText().toString();

        if (str1.isEmpty()) {
            txtEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str1).matches()) { // Predefine Pattern for Email
            txtEmail.setError("Please enter a valid email address");
            return false;
        } else {
            txtEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        str2=txtPassword.getText().toString();
        if (str2.isEmpty()) {
            txtPassword.setError("Field can't be empty");
            return false;

        } else if (!PASSWORD_PATTERN.matcher(str2).matches()) {
            txtPassword.setError("Password too weak");
            return false;
        }else {
            txtPassword.setError(null);
            return true;
        }
    }





}



