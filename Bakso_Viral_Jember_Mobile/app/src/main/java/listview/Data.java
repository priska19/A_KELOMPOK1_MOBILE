package listview;

public class Data {
    private String jenis;
    private String nama_produk;
    private String harga;

    //onstructor

    public Data(String jenis, String nama_produk, String harga){
        this.jenis = jenis;
        this.nama_produk = nama_produk;
        this.harga = harga;
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
