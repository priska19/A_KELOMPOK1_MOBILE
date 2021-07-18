package com.example.bakso_viral_jember_mobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivityCart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private com.example.cart.CartAdapter cartAdapter;
    private ArrayList<com.example.cart.CartModel> cartArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_cart);
        cartAdapter = new com.example.cart.CartAdapter(cartArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivityCart.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cartAdapter);
    }
    void addData(){
        cartArrayList = new ArrayList<>();
        cartArrayList.add (new com.example.cart.CartModel("Es cincau", "2", "10.000", "30.000"));
        cartArrayList.add (new com.example.cart.CartModel("Bakso Pedas", "5", "12.000", "100.000"));
    }
}