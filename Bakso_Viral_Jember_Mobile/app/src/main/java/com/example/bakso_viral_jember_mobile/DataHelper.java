package com.example.bakso_viral_jember_mobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "baksoViral.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE pesanan(nama text null, tgl_pesan text null, telpon text null, kecamatan text null, alamat text null);";
        Log.d("Data", "onCreate:" + sql);
        db.execSQL(sql);
        sql = "INSERT INTO pesanan (nama, tgl_pesan, telpon, kecamatan, alamat) VALUES ('Liga Bayu', '18-7-2021','081234567890', 'Sumbersari', 'Jl. Mastrip');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
    }
}
