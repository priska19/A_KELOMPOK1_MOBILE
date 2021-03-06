package com.example.bakso_viral_jember_mobile;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bakso_viral_jember_mobile.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<CartModel> datalist;

    public CartAdapter(ArrayList<CartModel> datalist) {
        this.datalist = datalist;

    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        holder.txtNama.setText(datalist.get(position).getNama());
        holder.txtJumlah.setText(datalist.get(position).getJumlah());
        holder.txtHarga.setText(datalist.get(position).getHarga());
        holder.txtTotal.setText(datalist.get(position).getTotal());
        holder.selectitem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TotalHarga.tambahTotal(Integer.parseInt(datalist.get(position).getTotal().replace(".", "")));
                } else {
                    TotalHarga.kurangiTotal(Integer.parseInt(datalist.get(position).getTotal().replace(".", "")));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (datalist != null) ? datalist.size() : 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtJumlah, txtHarga, txtTotal;
        private CheckBox selectitem;


        public CartViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.nama);
            txtHarga = (TextView) itemView.findViewById(R.id.harga);
            txtJumlah = (TextView) itemView.findViewById(R.id.jumlah);
            txtTotal = (TextView) itemView.findViewById(R.id.total);
            selectitem = (CheckBox) itemView.findViewById(R.id.chk_selectitem);
        }
    }
}
