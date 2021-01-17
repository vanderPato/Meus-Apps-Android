
package com.vanderlei.faaseusdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdView adView = findViewById(R.id.adView);
//        adView.setAdSize(AdSize.BANNER);
//        adView.setAdUnitId("ca-app-pub-9660995303494537/6473692245");

        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);
    }
        public void caipirinha(View v){
        Intent intent = new Intent(this, Caipirinha_Class.class);
        startActivity(intent);

    }

    public void coquiteis_vodk(View view){
        Intent intent = new Intent(this, Coquiteis_Class.class);
        startActivity(intent);

    }

    public void coquiteis_sem_vodk(View view){
        Intent intent = new Intent(this, Coquiteis_sem_alcool_Class.class);
        startActivity(intent);

    }
}