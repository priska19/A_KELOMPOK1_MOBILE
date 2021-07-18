package com.example.bakso_viral_jember_mobile;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakso_viral_jember_mobile.listview.RecycleView;

import java.util.ArrayList;

public class MainActivityCart extends AppCompatActivity {

    DrawerLayout drawerLayout;

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private ArrayList<CartModel> cartArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_cart);
        cartAdapter = new CartAdapter(cartArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivityCart.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cartAdapter);
    }
    void addData(){
        cartArrayList = new ArrayList<>();
        cartArrayList.add (new CartModel("Es cincau", "2", "10.000", "30.000"));
        cartArrayList.add (new CartModel("Bakso Pedas", "5", "12.000", "100.000"));
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
    public void ClickEditprofil(View view){
        MainActivity.redirecActivity(this, EditProfile.class);
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickOther(View view) {
    }
}