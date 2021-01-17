package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_pessego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel_pessego);
    }


    public void coquitel_vodka_pessego(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aquinacozinha.com/coquetel-de-pessego-com-3-ingredientes/"));
        startActivity(intent);

}

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }


}