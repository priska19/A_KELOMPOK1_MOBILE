package com.example.katalogmenu;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Button btnFragmentmakanan;
    private Button btnFragmentminuman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pemanggilan object button
        btnFragmentmakanan = findViewById(R.id.btn_makanan);
        btnFragmentminuman = findViewById(R.id.btn_minuman);

        //fungsi onClick pada button
        btnFragmentmakanan.setOnClickListener(v -> loadFragment(new fragment_makanan()));
        btnFragmentminuman.setOnClickListener(v -> loadFragment(new fragment_minuman()));

    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            transaction.replace(R.id.frame_layout, fragment);
            transaction.commit();
        }
    }
}