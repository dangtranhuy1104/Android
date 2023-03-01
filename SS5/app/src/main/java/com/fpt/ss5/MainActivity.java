package com.fpt.ss5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.IOnClickItem {

    List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Step1: Data Source
        initData();

        //Step2: Adapter
        ProductAdapter adapter = new ProductAdapter(this, listProduct, this);

        //Step3: LayoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        //Step4: RecyclerView
        RecyclerView rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);
    }

    private void initData() {
        listProduct.add(new Product("Iphone 13 Promax","Iphone 13 Promax 256GB", "799.00$",R.drawable.iphone_13_pro_max));
        listProduct.add(new Product("Iphone 14 Promax","Iphone 14 Promax 1TB", "999.00$", R.drawable.iphone_14_pro_max_1tb));
        listProduct.add(new Product("Oppo Find X5","Oppo Find X5 Pro 5G", "699.00$",R.drawable.oppo_find_x5_pro_5g));
        listProduct.add(new Product("Samsung Galaxy S23 Ultra","Samsung Galaxy S23 Ultra 5G", "999.00$",R.drawable.samsung_galaxy_s23_ultra_5g));
        listProduct.add(new Product("Samsung Galaxy Z Flip 4","Samsung Galaxy Z Flip 4 5G", "899.00$",R.drawable.samsung_galaxy_z_flip4_5g));
        listProduct.add(new Product("Xiaomi 12T Pro","Xiaomi 12T Pro 5G", "599.00$",R.drawable.xiaomi_12t_pro_5g));
    }

    //Handle when click item RecyclerView
    @Override
    public void onClickItem(int position) {
        Product product = listProduct.get(position);
        Toast.makeText(this, product.getTitle(),Toast.LENGTH_SHORT).show();
    }
}

