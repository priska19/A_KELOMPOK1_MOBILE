package com.example.bakso_viral_jember_mobile.listview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakso_viral_jember_mobile.Dashboard;
import com.example.bakso_viral_jember_mobile.EditProfile;
import com.example.bakso_viral_jember_mobile.Keranjang;
import com.example.bakso_viral_jember_mobile.MainActivity;
import com.example.bakso_viral_jember_mobile.R;
import com.example.bakso_viral_jember_mobile.RiwayatPembelian;

import java.util.ArrayList;


public class RecycleView extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private RecyclerView viewData;
    private DataAdapter adapterData;
    private ArrayList<Data> dataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        drawerLayout = findViewById(R.id.drawer_layout);

        addData();
        adapterData = new DataAdapter(dataArrayList);

        viewData = findViewById(R.id.view_data);
        viewData.setLayoutManager(new LinearLayoutManager(this));
        viewData.setAdapter(adapterData);
    }

    private void addData(){
        dataArrayList = new ArrayList<>();
        dataArrayList.add(new Data( "Mixtape", "Bicycle", "RM"));
        dataArrayList.add(new Data( "Mixtape", "Blue side", "j-hope"));
        dataArrayList.add(new Data( "Mixtape", "Snow Flower", "V"));
        dataArrayList.add(new Data( "Mixtape", "Chrismas Love", "Jimin"));
        dataArrayList.add(new Data( "Mixtape", "Abyss", "Jin"));
        dataArrayList.add(new Data( "Mixtape", "Still With You", "Jungkook"));
        dataArrayList.add(new Data( "Mixtape", "Daechwita", "Suga"));
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
        recreate();
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