package com.example.bakso_viral_jember_mobile.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bakso_viral_jember_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Data> dataModelArrayList;
    public ListAdapter(Context context, ArrayList<Data> dataModelArrayList) {
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }
    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return dataModelArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item,null, true);
            holder.iv = (ImageView) convertView.findViewById(R.id.img_produk);
            holder.tJenis = (TextView) convertView.findViewById(R.id.tv_jenis);
            holder.tProduk = (TextView) convertView.findViewById(R.id.tv_nama);
            holder.tHarga = (TextView) convertView.findViewById(R.id.tv_harga);
            convertView.setTag(holder);
        }else {
// the getTag returns the viewHolder object set as a            tag to the view
            holder = (ViewHolder)convertView.getTag();
        }
        Picasso.get().load(dataModelArrayList.get(position).getImgURL()).into(holder.iv);
        holder.tJenis.setText(dataModelArrayList.get(position).getJenis());
        holder.tProduk.setText(dataModelArrayList.get(position).getNama_produk());
        holder.tHarga.setText(dataModelArrayList.get(position).getHarga());
        return convertView;
    }
    private class ViewHolder {
        protected TextView tJenis, tProduk, tHarga;
        protected ImageView iv;
    }
}
