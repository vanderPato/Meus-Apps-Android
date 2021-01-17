package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.vanderlei.faaseusdrinks.R;

public class Caipirinha_de_goiaba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caipirinha_de_goiaba);
    }


    public void fonte_site_goiaba(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.caipirinhaprendada.com.br/recipe/caipirinha-com-goiaba/"));
        startActivity(intent);
    }


    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }


}