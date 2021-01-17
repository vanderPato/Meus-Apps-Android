package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.vanderlei.faaseusdrinks.R;

public class Faca_capipirinha_de_limao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faca_capipirinha_de_limao);
    }
    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }

}