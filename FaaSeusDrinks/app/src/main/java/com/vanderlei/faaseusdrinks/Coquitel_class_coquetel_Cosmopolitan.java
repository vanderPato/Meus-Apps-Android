package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_Cosmopolitan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel__cosmopolitan);
    }


    public void coquitel_cosmopolitan(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.printfriendly.com/p/g/TPtesA"));
        startActivity(intent);



    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}