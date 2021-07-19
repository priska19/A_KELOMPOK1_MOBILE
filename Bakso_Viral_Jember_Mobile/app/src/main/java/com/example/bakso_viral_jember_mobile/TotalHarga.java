package com.example.bakso_viral_jember_mobile;

public class TotalHarga {
    public static Integer total = 0;

    public static int getTotal() {
        return total;
    }

    public static void tambahTotal(Integer harga) {
        total = total + harga;
        MainActivityCart.total.setText(total.toString()+" Rupiah");
    }

    public static void kurangiTotal(Integer harga) {
        total = total - harga;
        MainActivityCart.total.setText(total.toString()+" Rupiah");
    }
}
