package com.example.bakso_viral_jember_mobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.bakso_viral_jember_mobile.listview.RecycleView;

public class RiwayatPembelian extends AppCompatActivity {

    DrawerLayout drawerLayout;
    String[] order;
    ListView listView01;
    Menu menu;
    String plhn_menu[] = {"Lihat Biodata", "Edit Biodata", "Hapus Biodata"};
    protected Cursor cursor;
    DataHelper dbCenter;
    public static RiwayatPembelian ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayatpembelian);

        drawerLayout = findViewById(R.id.drawer_layout);

        Button acBack = findViewById(R.id.btBack);
        acBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(RiwayatPembelian.this, Detail_Pengiriman.class);
                startActivity(intent);
            }
        });
        ma = this;
        dbCenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pesanan", null);
        order = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            order[cc] = cursor.getString(1).toString();
        }
        listView01 = findViewById(R.id.listView1);
        listView01.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, order));
        listView01.setSelected(true);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String selection = order[position];
                final CharSequence[] dialogItem = {"Lihat Order"};
                AlertDialog.Builder builder = new AlertDialog.Builder(RiwayatPembelian.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(RiwayatPembelian.this, Checkout.class);
                                i.putExtra("tgl_pesan", selection);
                                startActivity(i);
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)listView01.getAdapter()).notifyDataSetInvalidated();
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
        recreate();
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