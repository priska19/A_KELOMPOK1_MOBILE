package com.example.bakso_viral_jember_mobile.listview;

public class Data {
    private String jenis, nama_produk, harga, imgURL;
    public String getImgURL(){
        return imgURL;
    }
    public void setImgURL(String imgURL){
        this.imgURL = imgURL;
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public String getNama_produk() {
        return nama_produk;
    }
    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }
    public String getHarga() {
        return harga;
    }
    public void setHarga(String harga) {
        this.harga = harga;
    }
}
