package com.vanderlei.faaseusdrinks;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.vanderlei.faaseusdrinks.R;

public class Faca_capipirinha_de_maracuja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faca_capipirinha_de_maracuja);
    }


    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}