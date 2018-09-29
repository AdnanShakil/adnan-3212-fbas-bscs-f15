package com.example.adnanshakeel.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +

                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");



    private TextView txtFirstNamereg;
    private TextView txtLastNamereg;
    private TextView txtEmailreg;
    private EditText txtPasswardreg;
    private TextView txtConfirmPasswardreg;
    private Button btnCancel;
    private Button btnConfirm;
    String str1,str2,str3,str4,str5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnCancel=findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
        btnConfirm=findViewById(R.id.btnConfirm);

        txtFirstNamereg=findViewById(R.id.txtFirstName);
        txtLastNamereg=findViewById(R.id.txtLastName);
        txtEmailreg=findViewById(R.id.txtEmailreg);
        txtPasswardreg=findViewById(R.id.txtPasswardreg);
        txtConfirmPasswardreg=findViewById(R.id.txtConfirmPasswardreg);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFirstUsername()&& validateLastUsername()&& validateEmail() && validatePassword()&& validateConfimPassward())

                {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                Toast toast=Toast.makeText(getApplicationContext(),"Registration Confirmed",Toast.LENGTH_SHORT);
                toast.show();
                finish();
                }
            }
        });



    }
    // Function Definations

    private boolean validateFirstUsername() {
        str1 = txtFirstNamereg.getText().toString().trim();

        if (str1.isEmpty()) {
            txtFirstNamereg.setError("Field can't be empty");
            return false;
        } else if (txtFirstNamereg.length() > 15) {
            txtFirstNamereg.setError("Username too long");
            return false;
        } else {
            txtFirstNamereg.setError(null);
            return true;
        }
    }

    private boolean validateLastUsername() {
        str2 = txtConfirmPasswardreg.getText().toString().trim();

        if (str2.isEmpty()) {
            txtConfirmPasswardreg.setError("Field can't be empty");
            return false;
        } else if (txtConfirmPasswardreg.length() > 15) {
            txtConfirmPasswardreg.setError("Username too long");
            return false;
        } else {
            txtConfirmPasswardreg.setError(null);
            return true;
        }
    }



    private boolean validateEmail() {
        str3=txtEmailreg.getText().toString();

        if (str3.isEmpty()) {
            txtEmailreg.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str1).matches()) {
            txtEmailreg.setError("Please enter a valid email address");
            return false;
        } else {
            txtEmailreg.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        str4=txtPasswardreg.getText().toString();
        if (str4.isEmpty()) {
            txtPasswardreg.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(str2).matches()) {
            txtPasswardreg.setError("Password too weak");
            return false;
        } else {
            txtPasswardreg.setError(null);
            return true;
        }
    }

private boolean validateConfimPassward(){
    str5=txtConfirmPasswardreg.getText().toString();
    if (str5.isEmpty()) {
        txtConfirmPasswardreg.setError("Field can't be empty");
        return false;
    } else if (!PASSWORD_PATTERN.matcher(str2).matches()) {
        txtConfirmPasswardreg.setError("Password too weak");
        return false;
    } else {
        txtConfirmPasswardreg.setError(null);
        return true;
    }

}



}
