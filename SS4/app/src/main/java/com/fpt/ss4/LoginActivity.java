package com.fpt.ss4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        edUser = findViewById(R.id.edUser);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMain();
            }
        });
    }

    private void goMain(){
        Log.d("TAG", "goMain");
        Intent shipper = new Intent(LoginActivity.this, MainActivity.class);
        shipper.putExtra("user","T2011E");
        shipper.putExtra("username",edUser.getText().toString());
        startActivity(shipper);
    }
}