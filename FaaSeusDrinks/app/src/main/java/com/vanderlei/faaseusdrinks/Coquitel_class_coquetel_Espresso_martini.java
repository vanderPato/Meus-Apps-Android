package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Coquitel_class_coquetel_Espresso_martini extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquitel_class_coquetel__espresso_martini);
    }

    public void coquitel_espresso_martini(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mexidodeideias.com.br/receitas/expresso-martini/#:~:text=%20Ingredientes%20%201%201%20expresso%20em%20temperatura,para%20enfeitar%205%20Cubos%20de%20gelo%20More%20"));
        startActivity(intent);
}


    public void sair(View v){
        finish();
//        Intent intent = new Intent();
//        startActivity(intent);
    }

}