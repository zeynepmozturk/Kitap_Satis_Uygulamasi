package com.casper.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ikinciekran extends AppCompatActivity {

    private EditText editTextLoginUsername, editTextLoginPassword;
    private Button buttonLogin,button2,button3;
    private VeritabaniHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinciekran);

        databaseHelper = new VeritabaniHelper(this);

        editTextLoginUsername = findViewById(R.id.edtAdı);
        editTextLoginPassword = findViewById(R.id.edtParolam);
        buttonLogin = findViewById(R.id.btnGiris);
        button2=findViewById(R.id.button2);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ikinciekran.this, KayitEkrani.class);
                startActivity(i);
            }
        });


    }

    private void loginUser() {
        String username = editTextLoginUsername.getText().toString();
        String password = editTextLoginPassword.getText().toString();

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            boolean success = databaseHelper.checkUser(username, password);
            if (success) {
                // Kullanıcı başarılı bir şekilde giriş yaptı, istediğiniz sayfaya yönlendirin
                // Örneğin, MainActivity'e yönlendiriyoruz
                Intent intent = new Intent(ikinciekran.this, kitapSayfasi.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Giriş Başarısız Oldu.Lütfen Kimlik Bilgilerinizi Kontrol Edin.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
        }
    }
}