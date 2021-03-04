package com.example.firebase_update_lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etEmail;
    private Button bCreateUser;
    private Button bUpdateUser;
    private TextView tvResult;
    DbFirebaseHelper mDbFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.et_activity_main_name);
        etEmail = (EditText) findViewById(R.id.et_activity_main_email);
        tvResult = (TextView) findViewById(R.id.tv_activity_main_result);
        bCreateUser = (Button) findViewById(R.id.b_activity_main_create_user);
        bUpdateUser = (Button) findViewById(R.id.b_activity_main_update_user);
    }

    public void CreateUser(View view) {
        mDbFirebase = new DbFirebaseHelper();
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        mDbFirebase.createUser(name,email);
    }

    public void UpdateUser(View view) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        mDbFirebase.updateUser(name,email);
    }
}