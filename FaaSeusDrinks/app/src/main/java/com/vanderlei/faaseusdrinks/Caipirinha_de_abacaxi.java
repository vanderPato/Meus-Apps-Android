package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.vanderlei.faaseusdrinks.R;

public class Caipirinha_de_abacaxi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caipirinha_de_abacaxi);
    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}