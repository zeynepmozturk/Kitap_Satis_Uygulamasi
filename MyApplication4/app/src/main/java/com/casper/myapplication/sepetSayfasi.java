package com.casper.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class sepetSayfasi extends AppCompatActivity {
    private ListView listView;
    private TextView toplamFiyatTextView;
    private Button satinAlButton;
    private ArrayList<Book> sepetListesi;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepet_sayfasi);

        listView = findViewById(R.id.listView);
        toplamFiyatTextView = findViewById(R.id.toplamFiyat);


        // Sepet verilerini al
        ArrayList<String> kitapAdlari = getIntent().getStringArrayListExtra("sepetListesi");
        HashMap<String, Integer> kitapFiyatlari = (HashMap<String, Integer>) getIntent().getSerializableExtra("kitapFiyatlari");

        sepetListesi = new ArrayList<>();
        for (String kitapAdi : kitapAdlari) {
            sepetListesi.add(new Book(kitapAdi, kitapFiyatlari.get(kitapAdi)));
        }

        guncelleToplamFiyat();

        // ListView için özel adapter oluştur
        adapter = new BookAdapter(this, sepetListesi);
        listView.setAdapter(adapter);


    }

    public void guncelleToplamFiyat() {
        int toplamFiyat = 0;
        for (Book book : sepetListesi) {
            toplamFiyat += book.getFiyat();
        }
        toplamFiyatTextView.setText("Toplam Fiyat: " + toplamFiyat + " TL");
    }
}
