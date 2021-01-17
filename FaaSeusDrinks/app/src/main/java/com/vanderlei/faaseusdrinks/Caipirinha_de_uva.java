package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.vanderlei.faaseusdrinks.R;

public class Caipirinha_de_uva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caipirinha_de_uva);
    }

    public void fonte_site_uva(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tudogostoso.com.br/receita/63159-caipirinha-de-uva-niagara.html"));
        startActivity(intent);
    }


    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}