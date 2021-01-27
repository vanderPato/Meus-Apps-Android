package com.vanderlei.animal;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class TelaInicio extends AppCompatActivity {

    Animatable anime;
    Timer timer;
    Handler handler;
    TextView tx;
    boolean escolha_rato=false,escolha_barata=false,escolha_formiga=false,escolha_aranha=false,mouse_boolean = false,aranha_boolean = false;
    ToggleButton barata,formiga;
    ImageButton mouser,aranha;

    Button play;
    boolean ligar_movi_aranha= true;
    int numImagens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicio);

        play = findViewById(R.id.play);
        mouser = findViewById(R.id.mouser);
        barata = findViewById(R.id.barata);
        formiga= findViewById(R.id.formiga);
        aranha = findViewById(R.id.aranha);


        timer = new Timer();
        handler = new Handler();

        mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);
        aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);

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

        mouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mouse_boolean){
                    mouse_boolean = true;
                }else mouse_boolean = false;

                if (!mouse_boolean){
                    mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);
                }else mouser.setBackgroundResource(R.mipmap.rato_selecionado);

                aranha_boolean = false;
                if (!aranha_boolean)
                    aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);


            }
        });



        aranha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mouse_boolean = false;

                if (!aranha_boolean){
                    aranha_boolean = true;
                }else aranha_boolean = false;

                if (!aranha_boolean){
                    aranha.setBackgroundResource(R.mipmap.aranha_nao_seleccionada);
                }else aranha.setBackgroundResource(R.mipmap.aranha_selecionada);

                if (!mouse_boolean)
                    mouser.setBackgroundResource(R.mipmap.rato_nao_selecionado);


            }
        });





    }




    public void apertaplay(){
        if (mouse_boolean || barata.isChecked()  || formiga.isChecked()  || aranha_boolean){
            play.setEnabled(true);
        }else play.setEnabled(false);

    }

    public void play(View v){
        if (mouse_boolean){
            escolha_rato = true;
        }else escolha_rato = false;

        if (barata.isChecked()){
            escolha_barata = true;
        }else escolha_barata = false;

        if (formiga.isChecked()){
            escolha_formiga = true;
        }else escolha_formiga = false;


        if (aranha_boolean){
            escolha_aranha = true;
        }else escolha_aranha = false;

        Intent intent = new Intent( this, MainActivity.class);
        intent.putExtra("escolha_rato", escolha_rato);
        intent.putExtra("escolha_barata", escolha_barata);
        intent.putExtra("escolha_formiga", escolha_formiga);
        intent.putExtra("escolha_aranha", escolha_aranha);
        startActivity(intent);

    }

}
