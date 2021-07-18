package com.example.bakso_viral_jember_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bakso_viral_jember_mobile.listview.RecycleView;

public class Checkout extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button acBack;
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView tNama, tTgl, tTelp, tKecamatan, tAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        drawerLayout = findViewById(R.id.drawer_layout);
        dbHelper = new DataHelper(this);
        tNama = findViewById(R.id.listNama);
        tTgl = findViewById(R.id.listTgl);
        tTelp = findViewById(R.id.listTelp);
        tKecamatan = findViewById(R.id.listKecamatan);
        tAlamat = findViewById(R.id.listAlamat);
        acBack = findViewById(R.id.btBack);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pesanan WHERE tgl_pesan ='" + getIntent().getStringExtra("tgl_pesan") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            tNama.setText(cursor.getString(0).toString());
            tTgl.setText(cursor.getString(1).toString());
            tTelp.setText(cursor.getString(2).toString());
            tKecamatan.setText(cursor.getString(3).toString());
            tAlamat.setText(cursor.getString(4).toString());
        }
        acBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

    //jangan diotak atik sampe bawah
    public void Clickmenu(View view){

        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickCart(View view) {
        MainActivity.redirecActivity(this, MainActivityCart.class);
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