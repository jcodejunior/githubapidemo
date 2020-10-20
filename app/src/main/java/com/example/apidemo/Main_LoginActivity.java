package com.example.apidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main_LoginActivity extends Activity implements View.OnClickListener {

    private EditText etxt_username;
    private Button btn_Login;
    public static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        etxt_username = findViewById(R.id.etxt_Username);
        btn_Login = findViewById(R.id.btn_Login);
        btn_Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (etxt_username.getText().toString().trim().length() != 0) {
            username = etxt_username.getText().toString();
            Intent userActivity = new Intent(this, UserActivity.class);
            userActivity.putExtra("EXTRA_STRING", username);
            startActivity(userActivity);
        } else
            Toast.makeText(this, "You need to enter your github username!", Toast.LENGTH_SHORT).show();
    }
}