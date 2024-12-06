package com.casper.myapplication;

import java.io.Serializable;

public class Book implements Serializable {
    private String kitapAdi;
    private int fiyat;
    private boolean favori;

    public Book(String kitapAdi, int fiyat) {
        this.kitapAdi = kitapAdi;
        this.fiyat = fiyat;
        this.favori = false;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public boolean isFavori() {
        return favori;
    }

    public void setFavori(boolean favori) {
        this.favori = favori;
    }
}
