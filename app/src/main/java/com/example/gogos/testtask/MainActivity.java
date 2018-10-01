package com.example.gogos.testtask;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doLogin();
    }

    private boolean validateEditText() {
        userName = findViewById(R.id.user_name_Edit_text);
        password = findViewById(R.id.password_edit_text);
        if (userName.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.uName_empty, Toast.LENGTH_LONG).show();
            return false;
        } else if (password.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.p_empty, Toast.LENGTH_LONG).show();
            return false;
        } else if (!checkIfConnectedToInternet()) {
            Toast.makeText(getApplicationContext(), R.string.no_internet, Toast.LENGTH_SHORT).show();
        } else {
            return true;
        }
        return false;
    }

    private boolean checkIfConnectedToInternet() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =
                connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo
                != null && networkInfo.isConnectedOrConnecting();
        return isConnected;
    }

    private void doLogin() {
        AppCompatButton loginBtn = findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateEditText()) {
                    intent = new Intent(MainActivity.this, AfterLogin.class);
                    startActivity(intent);
                }
            }
        });
    }
}

