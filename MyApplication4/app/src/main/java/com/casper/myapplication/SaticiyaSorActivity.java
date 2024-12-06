package com.casper.myapplication;

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

public class SaticiyaSorActivity extends AppCompatActivity {
    private ArrayList<String> sorular = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saticiya_sor);

        ListView listView = findViewById(R.id.soruListView);
        EditText soruEditText = findViewById(R.id.soruEditText);
        Button submitSoruButton = findViewById(R.id.submitSoruButton);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sorular);
        listView.setAdapter(adapter);

        submitSoruButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String soru = soruEditText.getText().toString();
                if (!soru.isEmpty()) {
                    sorular.add(soru);
                    adapter.notifyDataSetChanged();
                    soruEditText.setText("");
                    showAlertDialog();
                }
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sorunuz eklendi")
                .setCancelable(false)
                .setPositiveButton("Kitap Sayfasına Dön", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(SaticiyaSorActivity.this, kitapSayfasi.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Satıcıya Soru Sormaya Devam Et", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
