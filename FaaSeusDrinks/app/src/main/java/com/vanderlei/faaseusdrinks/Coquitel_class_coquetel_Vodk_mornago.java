package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_Vodk_mornago extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel__vodk_mornago);
    }



    public void coquitel_vodk_morango(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tudoreceitas.com/artigo-17-coqueteis-com-vodka-faceis-8804.html"));
        startActivity(intent);
    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}



