package com.example.bakso_viral_jember_mobile;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;

import com.example.bakso_viral_jember_mobile.listview.RecycleView;

public class Detail_Pengiriman extends Activity {
    DrawerLayout drawerLayout;
    protected Cursor cursor;
    DataHelper dbHelper;
    Button acDone, acCancel;
    EditText tNama, tTgl, tTelp, tKecamatan, tAlamat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pengiriman);
        drawerLayout = findViewById(R.id.drawer_layout);
        dbHelper = new DataHelper(this);
        tNama = findViewById(R.id.etNama);
        tTgl = findViewById(R.id.etTgl);
        tTelp = findViewById(R.id.etTelp);
        tKecamatan = findViewById(R.id.etKecamatan);
        tAlamat = findViewById(R.id.etAlamat);
        acDone = findViewById(R.id.btnDone);
        acCancel = findViewById(R.id.btCancel);
        acDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO pesanan (nama, tgl_pesan, telpon, kecamatan, alamat) VALUES('"
                        + tNama.getText().toString() + "','"
                        + tTgl.getText().toString() + "','"
                        + tTelp.getText().toString() + "','"
                        + tKecamatan.getText().toString() + "','"
                        + tAlamat.getText().toString() + "')");
                Toast.makeText(Detail_Pengiriman.this, "Checkout Berhasil", Toast.LENGTH_LONG).show();
                RiwayatPembelian.ma.RefreshList();
                finish();
            }
        });

        acCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Detail_Pengiriman.this, Keranjang.class);
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
