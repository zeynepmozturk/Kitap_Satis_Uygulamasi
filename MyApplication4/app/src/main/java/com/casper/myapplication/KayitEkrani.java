package com.casper.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KayitEkrani extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonRegister, buttonKayitSorgula;
    private VeritabaniHelper databaseHelper;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ekrani);

        databaseHelper = new VeritabaniHelper(this);

        editTextUsername = findViewById(R.id.edtAd);
        editTextPassword = findViewById(R.id.edtParola);



        buttonRegister = findViewById(R.id.btnKaydet);
        buttonKayitSorgula = findViewById(R.id.btnKayitSorgula);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        buttonKayitSorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KayitEkrani.this, kayitSorgulama.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();




        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            boolean success = databaseHelper.addUser(username, password);
            if (success) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Kayıt Başarılı");
                builder.setMessage("Başarıyla kayıt oldunuz!");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent loginIntent = new Intent(KayitEkrani.this, ikinciekran.class);
                        startActivity(loginIntent);
                        finish();
                    }
                });
                builder.show();
            } else {
                Toast.makeText(this, "Kayıt başarısız oldu, lütfen tekrar deneyin.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
        }
    }
}
