package com.vanderlei.bugcat;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

public class TelaInicio extends AppCompatActivity {
    private InterstitialAd intertical;

    Animatable anime;
    Timer timer;
    Handler handler;
    TextView tx;
    boolean escolha_rato=false,escolha_barata=false,escolha_formiga=false,
            escolha_aranha=false,all_bugs_boolen=false;//,mouse_boolean = false; aranha_boolean = false;
    ImageButton barata,formiga;
    ImageButton mouser,aranha;
    ImageButton all_bugs;

    Button play;
    boolean ligar_movi_aranha= true;
    int numImagens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicio);

        all_bugs = findViewById(R.id.all_bugs_selec);
        play = findViewById(R.id.play);
        mouser = findViewById(R.id.mouser);
        barata = findViewById(R.id.barata);
        formiga= findViewById(R.id.formiga);
        aranha = findViewById(R.id.aranha_sele);

        AdView adView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);



        timer = new Timer();
        handler = new Handler();

        mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);
        aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);
        formiga.setBackgroundResource(R.mipmap.formiga_des);
        barata.setBackgroundResource(R.mipmap.barata_des);
        all_bugs.setBackgroundResource(R.mipmap.forma_morto);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        apertaplay();
                    }
                });
            }
        },0,80);

        all_bugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intertical = new InterstitialAd(TelaInicio.this);
                intertical.setAdUnitId("ca-app-pub-9660995303494537/4011397004");
                AdRequest request = new AdRequest.Builder().build();
                intertical.loadAd(request);

//

                if (!all_bugs_boolen){
                    all_bugs_boolen = true;
                }else all_bugs_boolen = false;

                if (!all_bugs_boolen){
                    all_bugs_boolen = false;

                    escolha_rato = false;
                    escolha_aranha = false;
                    escolha_barata = false;
                    escolha_formiga = false;
                    all_bugs.setBackgroundResource(R.mipmap.forma_morto);
                    mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);
                    aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);
                    barata.setBackgroundResource(R.mipmap.barata_des);
                    formiga.setBackgroundResource(R.mipmap.formiga_des);



                }else {

                    escolha_rato = false;
                    escolha_aranha = false;
                    escolha_barata = false;
                    escolha_formiga = false;
                    all_bugs.setBackgroundResource(R.mipmap.ic_launcher);
                    mouser.setBackgroundResource(R.mipmap.rato_selecionado);
                    aranha.setBackgroundResource(R.mipmap.aranha_selecionada);
                    barata.setBackgroundResource(R.mipmap.liga_barata);
                    formiga.setBackgroundResource(R.mipmap.liga_formiga);


                }



            }
        });

        mouser.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intertical = new InterstitialAd(TelaInicio.this);
                intertical.setAdUnitId("ca-app-pub-9660995303494537/4011397004");
                AdRequest request = new AdRequest.Builder().build();
                intertical.loadAd(request);


                escolha_aranha = false;
                escolha_formiga = false;
                escolha_barata = false;
                all_bugs_boolen = false;

                if (!escolha_rato){
                    escolha_rato= true;
                }else escolha_rato = false;

                if (!escolha_rato){
                    mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);
                }else mouser.setBackgroundResource(R.mipmap.rato_selecionado);


                if (!escolha_aranha)
                    aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);
                    formiga.setBackgroundResource(R.mipmap.formiga_des);
                    barata.setBackgroundResource(R.mipmap.barata_des);
                    all_bugs.setBackgroundResource(R.mipmap.forma_morto);




            }
        });



        aranha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intertical = new InterstitialAd(TelaInicio.this);
                intertical.setAdUnitId("ca-app-pub-9660995303494537/4011397004");
                AdRequest request = new AdRequest.Builder().build();
                intertical.loadAd(request);
//                if (escolha_aranha){
//                    escolha_aranha = true;
//                }else escolha_aranha = false;

                escolha_rato = false;
                escolha_formiga = false;
                escolha_barata = false;
                all_bugs_boolen = false;

                if (!escolha_aranha ){
                    escolha_aranha = true;
                }else escolha_aranha = false;

                if (!escolha_aranha){
                    aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);
                }else aranha.setBackgroundResource(R.mipmap.aranha_selecionada);

                if (!escolha_rato)
                    formiga.setBackgroundResource(R.mipmap.formiga_des);
                    barata.setBackgroundResource(R.mipmap.barata_des);
                    mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);
                    all_bugs.setBackgroundResource(R.mipmap.forma_morto);



            }
        });




        formiga.setOnClickListener(new View.OnClickListener() {
//            @Override
            public void onClick(View v) {
                intertical = new InterstitialAd(TelaInicio.this);
                intertical.setAdUnitId("ca-app-pub-9660995303494537/4011397004");
                AdRequest request = new AdRequest.Builder().build();
                intertical.loadAd(request);

                escolha_rato = false;
                escolha_barata = false;
                escolha_aranha = false;
                all_bugs_boolen = false;

                if (!escolha_formiga ){
                    escolha_formiga = true;
                }else escolha_formiga = false;

                if (!escolha_formiga){
                    formiga.setBackgroundResource(R.mipmap.formiga_des);
                }else formiga.setBackgroundResource(R.mipmap.liga_formiga);

                if (!escolha_barata)
                    barata.setBackgroundResource(R.mipmap.barata_des);
                    aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);
                    mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);
                    all_bugs.setBackgroundResource(R.mipmap.forma_morto);



            }
        });




        barata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intertical = new InterstitialAd(TelaInicio.this);
            intertical.setAdUnitId("ca-app-pub-9660995303494537/4011397004");
            AdRequest request = new AdRequest.Builder().build();
            intertical.loadAd(request);

            escolha_rato = false;
            escolha_formiga = false;
            escolha_aranha = false;
            all_bugs_boolen = false;

            if (!escolha_barata){
                escolha_barata = true;
            }else escolha_barata = false;

            if (!escolha_barata){
                barata.setBackgroundResource(R.mipmap.barata_des);
            }else barata.setBackgroundResource(R.mipmap.liga_barata);

            if (!escolha_formiga)
                formiga.setBackgroundResource(R.mipmap.formiga_des);
                mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);
                aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);
                all_bugs.setBackgroundResource(R.mipmap.forma_morto);


        }
    });




}

    public void apertaplay(){
        if (escolha_aranha|| escolha_barata || escolha_formiga  || escolha_rato||all_bugs_boolen){
            play.setEnabled(true);
        }else play.setEnabled(false);

    }

    public void play(View v){
        intertical = new InterstitialAd(TelaInicio.this);
        intertical.setAdUnitId("ca-app-pub-9660995303494537/4011397004");
        AdRequest request = new AdRequest.Builder().build();
        intertical.loadAd(request);

        if (escolha_aranha){
            Intent intent = new Intent( this, Class_aranha.class);
            intent.putExtra("escolha_aranha", escolha_aranha);
            startActivity(intent);

        }else if(escolha_barata){
            Intent intent = new Intent(this, Class_barata.class);
            intent.putExtra("escolha_barata", escolha_barata);
            startActivity(intent);

        }else if(escolha_formiga){
            Intent intent = new Intent(this, Class_formiga.class);
            intent.putExtra("escolha_formiga", escolha_formiga);
            startActivity(intent);

        }else if(escolha_rato){
            Intent intent = new Intent( this, MainActivity.class);
            intent.putExtra("escolha_rato", escolha_rato);
            startActivity(intent);


        }else if(all_bugs_boolen){
            Toast.makeText(this, "all", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Class_all_bugs.class);
            intent.putExtra("escolha_barata_all", all_bugs_boolen);
            startActivity(intent);

        }

    }

}
