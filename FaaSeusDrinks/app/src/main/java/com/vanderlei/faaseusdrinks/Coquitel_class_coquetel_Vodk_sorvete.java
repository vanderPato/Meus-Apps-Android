package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_Vodk_sorvete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel__vodk_sorvete);
    }

    public void coquitel_vodka_sorvete(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.receitas-sem-fronteiras.com/receita-67327-coquetel-de-sorvete-com-vodka.htm"));
        startActivity(intent);
    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }


    }