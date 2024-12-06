package com.casper.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class kayitSorgulama extends AppCompatActivity {
    private VeritabaniHelper databaseHelper;
    private EditText editTextSorguIsim;
    private Button buttonSorgula;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_sorgulama);

        databaseHelper = new VeritabaniHelper(this);
        editTextSorguIsim = findViewById(R.id.editTextSorgu);
        buttonSorgula = findViewById(R.id.buttonAra);
        listView=findViewById(R.id.listViewSonuclar);


        buttonSorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sorgulaVeListele();
            }
        });
    }

    private void sorgulaVeListele() {
        String sorgu = editTextSorguIsim.getText().toString();

        if (!TextUtils.isEmpty(sorgu)) {
            ArrayList<String> sonuclarListesi = databaseHelper.sorgulaKayitlarAdaGore(sorgu);
            if (sonuclarListesi.size() > 0) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sonuclarListesi);
                listView.setAdapter(adapter);

                // AlertDialog oluştur
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Puan Ver");
                builder.setMessage("Sonuçları değerlendirin");
                final RatingBar ratingBar = new RatingBar(this);
                builder.setView(ratingBar);
                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        float rating = ratingBar.getRating();
                        Toast.makeText(getApplicationContext(), "Puanınız: " + rating, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            } else {
                Toast.makeText(this, "Sonuç bulunamadı", Toast.LENGTH_SHORT).show();
                listView.setAdapter(null);
            }
        } else {
            Toast.makeText(this, "Lütfen bir ad girin", Toast.LENGTH_SHORT).show();
            listView.setAdapter(null);
        }
    }

}