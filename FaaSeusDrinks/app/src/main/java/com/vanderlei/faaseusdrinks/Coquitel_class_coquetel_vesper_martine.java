package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_vesper_martine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel_vesper_martine);
    }

    public void coquitel_vesper_martini(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.comidaereceitas.com.br/bebidas-e-sucos/vesper-martini-drink-do-007-james-bond.html#:~:text=%20Receita%20de%20Vesper%20Martini%20%E2%80%93%20Drink%20do,4%201%20casca%20de%20lim%C3%A3o%20siciliano%20More%20"));
        startActivity(intent);

    }

    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }
}