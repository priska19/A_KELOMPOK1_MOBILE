package com.example.bakso_viral_jember_mobile.listview;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bakso_viral_jember_mobile.Dashboard;
import com.example.bakso_viral_jember_mobile.EditProfile;
import com.example.bakso_viral_jember_mobile.Keranjang;
import com.example.bakso_viral_jember_mobile.MainActivity;
import com.example.bakso_viral_jember_mobile.MainActivityCart;
import com.example.bakso_viral_jember_mobile.R;
import com.example.bakso_viral_jember_mobile.RiwayatPembelian;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class RecycleView extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private String URLstring = "http://192.168.43.227:80/api/api_product"; //pake alamat ip
    private static ProgressDialog mProgressDialog;
    private ListView listView;
    ArrayList<Data> dataModelArrayList;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        listView = findViewById(R.id.view_data);
        retrieveJSON();
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    private void retrieveJSON() {
        showSimpleProgressDialog(this, "Loading...","Fetching Json",false);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("strrrrr", ">>" + response);
                try {
                    JSONObject obj = new JSONObject(response);
                    if(obj.optString("success").equals("true")){
                        dataModelArrayList = new ArrayList<>();
                        JSONArray dataArray = obj.getJSONArray("produk");
                        for (int i = 0; i < dataArray.length(); i++) {
                            Data playerModel = new Data();
                            JSONObject dataobj = dataArray.getJSONObject(i);
                            playerModel.setJenis(dataobj.getString("category"));
                            playerModel.setNama_produk(dataobj.getString("name"));
                            playerModel.setHarga(dataobj.getString("price"));
                            playerModel.setImgURL(dataobj.getString("image"));
                            dataModelArrayList.add(playerModel);
                        }
                        setupListview();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
//displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
// request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void setupListview(){
        removeSimpleProgressDialog(); //will remove progress dialog
        listAdapter = new ListAdapter(this, dataModelArrayList);
        listView.setAdapter(listAdapter);
    }
    public static void removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void showSimpleProgressDialog(Context context, String title, String msg, boolean isCancelable) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context,title, msg);
                mProgressDialog.setCancelable(isCancelable);
            }
            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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