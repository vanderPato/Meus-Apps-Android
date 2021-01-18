package com.vanderlei.apertaaperta1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class TelaInicio extends AppCompatActivity {

    private InterstitialAd intertical;
    Button te_inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicio);


//        if (intertical.isLoaded()){
//            intertical.show();
//        }
        intertical = new InterstitialAd(this);
        intertical.setAdUnitId("ca-app-pub-96609953034537/6948925267");
        AdRequest request = new AdRequest.Builder().build();
        intertical.loadAd(request);


        te_inicio = findViewById(R.id.te_inicio);

    }

    public void te_in(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void lista_pontos(View v){
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
        if (intertical.isLoaded()){
            intertical.show();
        }



    }

}
