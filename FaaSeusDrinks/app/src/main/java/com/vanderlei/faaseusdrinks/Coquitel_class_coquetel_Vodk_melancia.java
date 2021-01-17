package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_Vodk_melancia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel__vodk_melancia);
    }

    public void coquitel_vodk_melancia(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tudoreceitas.com/artigo-17-coqueteis-com-vodka-faceis-8804.html#:~:text=%20Ingredientes%3A%20%201%201%20lim%C3%A3o%202%201,tequila%204%20%C2%BD%20copo%20de%20vodka%20More%20"));
        startActivity(intent);
    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
    }