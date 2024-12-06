package com.casper.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class veri_kayit_gosterme extends AppCompatActivity {
     private RecyclerView rcVeriler;
     VeritabaniHelper veritabaniHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veri_kayit_gosterme);
        rcVeriler=findViewById(R.id.rvKayitlar);
        veritabaniHelper = new VeritabaniHelper(this);



    }
}