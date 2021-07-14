package com.example.katalogmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_makanan extends Fragment {

    private Button btnShowMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_makanan, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnShowMessage = view.findViewById(R.id.btn_toast);
        btnShowMessage.setOnClickListener(
                v -> Toast.makeText(getContext().getApplicationContext(), "Makanan" , Toast.LENGTH_SHORT).show());
    }

}