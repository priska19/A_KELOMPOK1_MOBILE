package com.example.bakso_viral_jember_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakso_viral_jember_mobile.listview.RecycleView;

import java.util.ArrayList;

public class MainActivityCart extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button btOrder;
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private ArrayList<CartModel> cartArrayList;
    public static TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        drawerLayout = findViewById(R.id.drawer_layout);
        total = findViewById(R.id.tv_total);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_cart);
        cartAdapter = new CartAdapter(cartArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivityCart.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cartAdapter);
        btOrder = findViewById(R.id.btnOrder);
        btOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivityCart.this, Detail_Pengiriman.class);
                startActivity(i);
            }
        });

    }
    void addData(){
        cartArrayList = new ArrayList<>();
        cartArrayList.add (new CartModel("Bakso Alus", "1", "12.000", "12.000"));
    }


    //jangan diotak atik sampe bawah!!
    public void Clickmenu(View view){

        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickCart(View view) {
        recreate();
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickDashboard(View view){
        MainActivity.redirecActivity(this, Dashboard.class);
    }
    public void ClickKatalog(View view){
        MainActivity.redirecActivity(this, RecycleView.class);
    }
    public void ClickHistory(View view){
        MainActivity.redirecActivity(this, RiwayatPembelian.class);
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}