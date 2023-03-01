package com.fpt.ss6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvDate, tvContent;
    ImageView ivCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        callApiGetData();
    }

    private void initView(){
        tvTitle = findViewById(R.id.tvTitle);
        tvDate= findViewById(R.id.tvDate);
        tvContent = findViewById(R.id.tvContent);
        ivCover = findViewById(R.id.ivCover);
    }

    private void callApiGetData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.212.245.101/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager service = retrofit.create(ApiManager.class);
        service.apiData().enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                //Success
                Item model = response.body();
//                Log.d("TAG", "onSuccess:" + response.body());
                Log.d("TAG", "title: " + model.getTitle());
                Log.d("TAG", "name: " + model.getName());
                Log.d("TAG", "content: " + model.getContent());
                tvTitle.setText(model.getTitle());
                tvDate.setText(model.getDate());
                tvContent.setText(model.getContent().getDescription());
                Glide.with(MainActivity.this).load(model.getImage()).into(ivCover);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                //Fail
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}