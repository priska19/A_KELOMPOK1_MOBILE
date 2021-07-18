package com.example.bakso_viral_jember_mobile;

public class CartModel  {

    private String nama;
    private String jumlah;
    private String harga;
    private String total;

    public CartModel(String nama, String jumlah, String harga, String total) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total = total;
    }
    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
