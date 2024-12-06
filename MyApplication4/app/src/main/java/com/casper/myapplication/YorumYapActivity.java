package com.casper.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class YorumYapActivity extends AppCompatActivity {
    private ArrayList<String> yorumlar = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorum_yap);

        ListView listView = findViewById(R.id.soruListView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText yorumEditText = findViewById(R.id.yorumEditText);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button submitYorumButton = findViewById(R.id.submitYorumButton);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, yorumlar);
        listView.setAdapter(adapter);

        submitYorumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yorum = yorumEditText.getText().toString();
                if (!yorum.isEmpty()) {
                    yorumlar.add(yorum);
                    adapter.notifyDataSetChanged();
                    yorumEditText.setText("");
                    showAlertDialog();
                }
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Yorumunuz eklendi")
                .setCancelable(false)
                .setPositiveButton("Kitap Sayfasına Dön", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(YorumYapActivity.this, kitapSayfasi.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Yorum Yapmaya Devam Et", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
