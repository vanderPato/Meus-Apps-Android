package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.vanderlei.faaseusdrinks.R;

public class Caipirinha_seriguela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caipirinha_seriguela);
    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}