package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_Frozen_original extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel__frozen_original);
    }

    public void coquitel_frozen_original(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://receitatodahora.com.br/drink-frozen-original/"));
        startActivity(intent);

    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }

}