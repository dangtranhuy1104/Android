package com.fpt.edu.ss10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fpt.edu.ss10.adapter.UserAdapter;
import com.fpt.edu.ss10.database.Appdatabase;
import com.fpt.edu.ss10.database.User;

import java.util.List;

public class ListUserActivity extends AppCompatActivity {
    RecyclerView rvUser;
    Appdatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        db = Appdatabase.getAppdatabase(this);
        List<User> list = db.userDao().getAllUser();
        UserAdapter adapter = new UserAdapter(this,list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvUser = findViewById(R.id.rvUser);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);
    }
}