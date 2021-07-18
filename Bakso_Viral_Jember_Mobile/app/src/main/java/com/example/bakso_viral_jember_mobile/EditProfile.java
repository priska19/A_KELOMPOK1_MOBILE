package com.example.bakso_viral_jember_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bakso_viral_jember_mobile.listview.RecycleView;

public class EditProfile extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        drawerLayout = findViewById(R.id.drawer_layout);

//        dbHelper = new DataHelper(this);
//        text1 = findViewById(R.id.editText1);
//        text2 = findViewById(R.id.editText2);
//        text3 = findViewById(R.id.editText3);
//        text4 = findViewById(R.id.editText4);
//        text5 = findViewById(R.id.editText5);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
//                getIntent().getStringExtra("nama") + "'", null);
//        cursor.moveToFirst();
//        if (cursor.getCount() > 0) {
//            cursor.moveToPosition(0);
//            text1.setText(cursor.getString(0).toString());
//            text2.setText(cursor.getString(1).toString());
//            text3.setText(cursor.getString(2).toString());
//            text4.setText(cursor.getString(3).toString());
//            text5.setText(cursor.getString(4).toString());
//        }
//        ton1 = findViewById(R.id.button1);
        ton2 = findViewById(R.id.button2);
//
//        ton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.execSQL("UPDATE biodata SET nama='" +
//                        text2.getText().toString() +"', tgl='" +
//                        text3.getText().toString() + "', jk='" +
//                        text4.getText().toString() + "', alamat='" +
//                        text5.getText().toString() + "'WHERE no='" +
//                        text1.getText().toString() + "'");
//                Toast.makeText(EditProfile.this, "Berhasil", Toast.LENGTH_SHORT).show();
//                MainActivity.ma.RefreshList();
//                finish();
//            }
//        });
//
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditProfile.this, MainActivity.class);
                startActivity(i);
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