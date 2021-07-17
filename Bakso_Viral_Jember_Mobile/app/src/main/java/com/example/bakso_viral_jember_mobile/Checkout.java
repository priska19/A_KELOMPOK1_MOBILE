package com.example.bakso_viral_jember_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.bakso_viral_jember_mobile.listview.RecycleView;

public class Checkout extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        drawerLayout = findViewById(R.id.drawer_layout);
        btn2 = findViewById(R.id.tombol2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Checkout.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    //jangan diotak atik sampe bawah
    public void Clickmenu(View view){

        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickCart(View view) {
        MainActivity.redirecActivity(this, Keranjang.class);
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
}