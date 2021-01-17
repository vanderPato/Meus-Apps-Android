package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_Veracruz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel__veracruz);
    }


    public void coquitel_vera_cuz(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tudoreceitas.com/artigo-17-coqueteis-com-vodka-faceis-8804.html"));
        startActivity(intent);
    }


    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}