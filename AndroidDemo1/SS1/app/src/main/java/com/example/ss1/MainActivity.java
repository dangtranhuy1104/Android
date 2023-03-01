package com.example.ss1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btLogin;
    TextView tvTitle;
    ImageView ivCover;
    EditText edUsername;
    CheckBox ckPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btLogin = findViewById(R.id.btLogin);
        tvTitle = findViewById(R.id.tvTitle);
        ivCover = findViewById(R.id.ivCover);
        edUsername = findViewById(R.id.edUsername);
        ckPrivacy = findViewById(R.id.ckPrivacy);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "Click button Login");
                tvTitle.setText("ABCDE");
                ivCover.setImageResource(R.drawable.funny4);
                String username = edUsername.getText().toString();
                tvTitle.setText(username);
                boolean isChecked = ckPrivacy.isChecked();
            }
        });

    }
}