package com.vanderlei.animal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    boolean ligar_movi_aranha= true;
    int numImagens;

    int pivotX, pivotY ,y,x;
    boolean ligarPivots = true;
    RelativeLayout relative,aranha_rainha;
    ImageView rato,aranha;
    Timer timer;
    Handler handler;
    Random random ;
    TextView tx;

    boolean dados_recebidos_rato,dados_recebidos_barata,dados_recebidos_formiga,dados_recebidos_aranha;


    boolean ligado = true,ligar_direcao =true;
    int decendo =0,subindo;



    int cima, baixo,direita,esquerda;

    int direcoes,contagens;

//    AnimationDrawable anii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        tx = findViewById(R.id.tx);
        rato = findViewById(R.id.rato);
        aranha = findViewById(R.id.aranha);
        relative = findViewById(R.id.relative);
        aranha_rainha = findViewById(R.id.aranha_rainha);


        Bundle extra = getIntent().getExtras();
        setDados_recebidos_rato(extra.getBoolean("escolha_rato"));
        setDados_recebidos_barata(extra.getBoolean("escolha_barata"));
        setDados_recebidos_formiga(extra.getBoolean("escolha_formiga"));
        setDados_recebidos_aranha(extra.getBoolean("escolha_aranha"));








        timer = new Timer();
        handler = new Handler();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
//                        rato();
                        direcoes_rato();
                        direcoes_aranha();

                        tx.setText(String.valueOf("cima : " + cima + "\n" + "baixo : " + baixo + "\n"
                                + "esquerda : " + esquerda + "\n" + "direia : " + direita + "\n" + "direcoes : "
                                + direcoes + "\n" + "contagens : " + contagens + "\n"+ "\n"+ "\n" + "Dados recebidos:  " + isDados_recebidos_rato())+ "\n"
                                + "aranhaY : " + aranha_rainha.getY() + "\n" + "aranhaX : " + aranha_rainha.getX() );
                    }
                });
            }
        },0,2);




        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (ligar_direcao){
                            contagens +=1;
                        }
                        movimento_aranha();

//                        funcoes_pivots();

                    }
                });
            }
        },0,20);

    }




    public void funcoes_pivots(){

        if (ligarPivots){
            y +=1;
            x +=1;
            aranha_rainha.setY(y);
            aranha_rainha.setX(x);

//            rato1.setPivotX(pivotX + rato1.getWidth());

//            rato1.setX(pivotX);
//            rato1.setPivotX(pivotX);
        }




    }

    public void movimento_aranha(){
        if (ligar_movi_aranha){
            numImagens+=1;
        }if (numImagens > 18 ){
            numImagens =0;
        }

        if (numImagens == 1){
            aranha.setBackgroundResource(R.mipmap.a_1);
        }


        if (numImagens == 2){
            aranha.setBackgroundResource(R.mipmap.a_2);
        }



        if (numImagens == 2){
            aranha.setBackgroundResource(R.mipmap.a_2);
        }




        if (numImagens == 3){
            aranha.setBackgroundResource(R.mipmap.a_3);
        }



        if (numImagens == 4){
            aranha.setBackgroundResource(R.mipmap.a_4);
        }



        if (numImagens == 5){
            aranha.setBackgroundResource(R.mipmap.a_5);
        }




        if (numImagens == 6){
            aranha.setBackgroundResource(R.mipmap.a_6);
        }




        if (numImagens == 7){
            aranha.setBackgroundResource(R.mipmap.a_7);
        }



        if (numImagens == 8){
            aranha.setBackgroundResource(R.mipmap.a_8);
        }




        if (numImagens == 9){
            aranha.setBackgroundResource(R.mipmap.a_9);
        }




        if (numImagens == 10){
            aranha.setBackgroundResource(R.mipmap.a_10);
        }





        if (numImagens == 11){
            aranha.setBackgroundResource(R.mipmap.a_11);
        }




        if (numImagens == 12){
            aranha.setBackgroundResource(R.mipmap.a_12);
        }




        if (numImagens == 13){
            aranha.setBackgroundResource(R.mipmap.a_13);
        }





        if (numImagens == 14){
            aranha.setBackgroundResource(R.mipmap.a_14);
        }




        if (numImagens == 15){
            aranha.setBackgroundResource(R.mipmap.a_15);
        }






        if (numImagens == 16){
            aranha.setBackgroundResource(R.mipmap.a_16);
        }




        if (numImagens == 17){
            aranha.setBackgroundResource(R.mipmap.a_17);
        }




        if (numImagens == 18){
            aranha.setBackgroundResource(R.mipmap.a_18);
        }





    }


    public void direcoes_aranha(){
        if (isDados_recebidos_aranha()) {

            setDados_recebidos_rato(false);
            setDados_recebidos_formiga(false);
            setDados_recebidos_barata(false);

            if (contagens == 80) {
//                animation_45_graus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotacao);
//                aranha .startAnimation(animation_45_graus);

                direcoes = random.nextInt(20);
                contagens = 0;
            }
            if (direcoes >= 0 && direcoes <= 2) {
                aranha.setBackgroundResource(R.mipmap.aranha_3);
                cima = (int) aranha_rainha.getY();
                cima -= 1;
                aranha_rainha.setY(cima);
            } else if (direcoes > 2 && direcoes <= 4) {

                aranha.setBackgroundResource(R.mipmap.aranha_5);
                baixo = (int) aranha_rainha.getY();
                baixo += 1;
                aranha_rainha.setY(baixo);
            } else if (direcoes > 4 && direcoes <= 6) {

                movimento_aranha();
//                aranha.setBackgroundResource(R.mipmap.aranha_7);
                esquerda = (int) aranha_rainha.getX();
                esquerda -= 1;
                aranha_rainha.setX(esquerda);
            } else if (direcoes > 6 && direcoes <= 8) {
                aranha.setBackgroundResource(R.mipmap.aranha_8);
                direita = (int) aranha_rainha.getX();
                direita += 1;
                aranha_rainha.setX(direita);

            } else if (direcoes > 8 && direcoes <= 10) {
                aranha.setBackgroundResource(R.mipmap.aranha_6);
                direita = (int) aranha_rainha.getX();
                baixo = (int) aranha_rainha.getY();
                direita += 1;
                baixo += 1;
                aranha_rainha.setY(baixo);
                aranha_rainha.setX(direita);

            } else if (direcoes > 10 && direcoes <= 12) {
                aranha.setBackgroundResource(R.mipmap.aranha_4);
                esquerda = (int)aranha_rainha.getX();
                baixo = (int) aranha_rainha.getY();
                esquerda -= 1;
                baixo += 1;
                aranha_rainha.setY(baixo);
                aranha_rainha.setX(esquerda);


            } else if (direcoes > 12 && direcoes <= 14) {
                aranha.setBackgroundResource(R.mipmap.aranha_2);
                esquerda = (int) aranha_rainha.getX();
                subindo = (int) aranha_rainha.getY();
                esquerda -= 1;
                subindo -= 1;
                aranha_rainha.setY(subindo);
                aranha_rainha.setX(esquerda);

            } else if (direcoes > 14 && direcoes <= 16) {
                aranha.setBackgroundResource(R.mipmap.aranha_1);
                direita = (int) aranha_rainha.getX();
                subindo = (int) aranha_rainha.getY();
                direita += 1;
                subindo -= 1;
                aranha_rainha.setY(subindo);
                aranha_rainha.setX(direita);


            }


            if (direita >= relative.getWidth() + aranha_rainha.getWidth()) {
                direita = 0 - aranha_rainha.getWidth();
                aranha_rainha.setX(direita);
            } else if (esquerda < 0 - rato.getWidth()) {
                esquerda = relative.getWidth() + aranha_rainha.getWidth();
                aranha_rainha.setX(esquerda);
            }

            if (cima < 0 - aranha_rainha.getHeight()) {
                cima = relative.getHeight() + aranha_rainha.getHeight();
                aranha_rainha.setY(cima);
            } else if (baixo >= relative.getHeight() + aranha_rainha.getHeight()) {
                baixo = 0 - aranha_rainha.getHeight();
                aranha_rainha.setY(baixo);
            }

        }

    }


    public void direcoes_rato(){
        if (isDados_recebidos_rato()) {
            setDados_recebidos_aranha(false);
            setDados_recebidos_formiga(false);
            setDados_recebidos_barata(false);
            if (contagens == 30) {
                direcoes = random.nextInt(20);
                contagens = 0;
            }
            if (direcoes >= 0 && direcoes <= 2) {
                rato.setBackgroundResource(R.mipmap.rato_8);
                cima = (int) rato.getY();
                cima -= 1;
                rato.setY(cima);
            } else if (direcoes > 2 && direcoes <= 4) {
                rato.setBackgroundResource(R.mipmap.rato_7);
                baixo = (int) rato.getY();
                baixo += 1;
                rato.setY(baixo);
            } else if (direcoes > 4 && direcoes <= 6) {
                rato.setBackgroundResource(R.mipmap.rato_1);
                esquerda = (int) rato.getX();
                esquerda -= 1;
                rato.setX(esquerda);
            } else if (direcoes > 6 && direcoes <= 8) {
                rato.setBackgroundResource(R.mipmap.rato_3);
                direita = (int) rato.getX();
                direita += 1;
                rato.setX(direita);

            } else if (direcoes > 8 && direcoes <= 10) {
                rato.setBackgroundResource(R.mipmap.rato_5);
                direita = (int) rato.getX();
                baixo = (int) rato.getY();
                direita += 1;
                baixo += 1;
                rato.setY(baixo);
                rato.setX(direita);

            } else if (direcoes > 10 && direcoes <= 12) {
                rato.setBackgroundResource(R.mipmap.rato);
                esquerda = (int) rato.getX();
                baixo = (int) rato.getY();
                esquerda -= 1;
                baixo += 1;
                rato.setY(baixo);
                rato.setX(esquerda);


            } else if (direcoes > 12 && direcoes <= 14) {
                rato.setBackgroundResource(R.mipmap.rato_2);
                esquerda = (int) rato.getX();
                subindo = (int) rato.getY();
                esquerda -= 1;
                subindo -= 1;
                rato.setY(subindo);
                rato.setX(esquerda);

            } else if (direcoes > 14 && direcoes <= 16) {
                rato.setBackgroundResource(R.mipmap.rato_4);
                direita = (int) rato.getX();
                subindo = (int) rato.getY();
                direita += 1;
                subindo -= 1;
                rato.setY(subindo);
                rato.setX(direita);

            }


            if (direita >= relative.getWidth() + rato.getWidth()) {
                direita = 0 - rato.getWidth();
                rato.setX(direita);
            } else if (esquerda < 0 - rato.getWidth()) {
                esquerda = relative.getWidth() + rato.getWidth();
                rato.setX(esquerda);
            }

            if (cima < 0 + rato.getHeight()) {
                cima = relative.getHeight() + rato.getHeight();
                rato.setY(cima);
            } else if (baixo >= relative.getHeight() + rato.getHeight()) {
                baixo = 0 - rato.getHeight();
                rato.setY(baixo);
            }
        }

    }



    public boolean isDados_recebidos_rato() {
        return dados_recebidos_rato;
    }

    public void setDados_recebidos_rato(boolean dados_recebidos_rato) {
        this.dados_recebidos_rato = dados_recebidos_rato;
    }

    public boolean isDados_recebidos_barata() {
        return dados_recebidos_barata;
    }

    public void setDados_recebidos_barata(boolean dados_recebidos_barata) {
        this.dados_recebidos_barata = dados_recebidos_barata;
    }

    public boolean isDados_recebidos_formiga() {
        return dados_recebidos_formiga;
    }

    public void setDados_recebidos_formiga(boolean dados_recebidos_formiga) {
        this.dados_recebidos_formiga = dados_recebidos_formiga;
    }

    public boolean isDados_recebidos_aranha() {
        return dados_recebidos_aranha;
    }

    public void setDados_recebidos_aranha(boolean dados_recebidos_aranha) {
        this.dados_recebidos_aranha = dados_recebidos_aranha;
    }
}