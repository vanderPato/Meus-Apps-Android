package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.vanderlei.faaseusdrinks.R;

public class Caipirinha_de_pessego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caipirinha_de_pessego);
    }

    public void fonte_site_pessego(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tudogostoso.com.br/receita/182754-caipirinha-de-pessego.html"));
        startActivity(intent);
    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}