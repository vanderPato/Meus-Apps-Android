package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_dirty_martini extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_dirty_martini);
    }

    public void coquitel_dirty_martini(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://content.paodeacucar.com/prazer-de-comer-e-beber/dirty-martini"));
        startActivity(intent);



    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}