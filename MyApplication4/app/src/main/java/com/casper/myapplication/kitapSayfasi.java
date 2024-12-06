package com.casper.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class kitapSayfasi extends AppCompatActivity {
    ArrayList<String> sepetListesi = new ArrayList<>();
    HashMap<String, Integer> kitapFiyatlari = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_sayfasi);

        kitapFiyatlari.put("Kürk Mantolu Madonna", 15);
        kitapFiyatlari.put("Gurur ve Önyargı", 20);
        kitapFiyatlari.put("İnsan Neyle Yaşar", 28);
        kitapFiyatlari.put("Şeker Portakalı", 100);
        kitapFiyatlari.put("Bilinmeyen Bir Kadının Mektubu", 32);
        kitapFiyatlari.put("Simyacı", 101);

        Button book_sepet = findViewById(R.id.book_sepet);
        Button book_sepet2 = findViewById(R.id.book_sepet2);
        Button book_sepet3 = findViewById(R.id.book_sepet3);
        Button book_sepet4 = findViewById(R.id.book_sepet4);
        Button book_sepet5 = findViewById(R.id.book_sepet5);
        Button book_sepet6 = findViewById(R.id.book_sepet6);

        registerForContextMenu(book_sepet);
        registerForContextMenu(book_sepet2);
        registerForContextMenu(book_sepet3);
        registerForContextMenu(book_sepet4);
        registerForContextMenu(book_sepet5);
        registerForContextMenu(book_sepet6);


        book_sepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("Kürk Mantolu Madonna");
            }
        });

        book_sepet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("Gurur ve Önyargı");
            }
        });

        book_sepet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("İnsan Neyle Yaşar");
            }
        });

        book_sepet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("Şeker Portakalı");
            }
        });

        book_sepet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("Bilinmeyen Bir Kadının Mektubu");
            }
        });

        book_sepet6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("Simyacı");
            }
        });
    }

    private void showAlertDialog(String kitapAdi) {
        sepetListesi.add(kitapAdi);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sepete eklendi")
                .setCancelable(false)
                .setPositiveButton("Sepete Git", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(kitapSayfasi.this, sepetSayfasi.class);
                        intent.putStringArrayListExtra("sepetListesi", sepetListesi);
                        intent.putExtra("kitapFiyatlari", (Serializable) kitapFiyatlari);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Alışverişe Devam Et", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itemYorum) {
            Intent intent = new Intent(kitapSayfasi.this, YorumYapActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.itemBegen) {
            Toast.makeText(this, "Ürün favorilere eklendi!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.itemSoru) {
            Intent intent = new Intent(kitapSayfasi.this, SaticiyaSorActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}
