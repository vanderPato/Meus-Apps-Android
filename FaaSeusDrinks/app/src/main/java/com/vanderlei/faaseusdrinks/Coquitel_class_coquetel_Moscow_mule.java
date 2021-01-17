package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_Moscow_mule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel__moscow_mule);
    }

    public void coquitel_moscow_mule(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coisasdediva.com.br/2016/02/drinks-com-vodka/"));
        startActivity(intent);
    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }

}