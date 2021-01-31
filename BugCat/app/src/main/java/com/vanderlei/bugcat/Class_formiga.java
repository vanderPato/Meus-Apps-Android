package com.vanderlei.bugcat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Class_formiga extends AppCompatActivity {

    private Random random_formiga = new Random();
    private Timer timer_formiga = new Timer();
    private Handler handler_formiga = new Handler();
    private RelativeLayout formiga_rainha,relative_formiga;
    private ImageView formiga;
    private boolean dados_recebidos_formiga;
    private int direcoes_formiga,contagens_formiga;
    int cima, baixo,direita,esquerda,subindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_formiga);


        relative_formiga = findViewById(R.id.relative_formiga);
        formiga = findViewById(R.id.formiga_play);
        formiga_rainha = findViewById(R.id.formiga_rainha);



        Bundle extra = getIntent().getExtras();
        setDados_recebidos_formiga(extra.getBoolean("escolha_formiga"));


        View full_scheen = getWindow().getDecorView();
        int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
        full_scheen.setSystemUiVisibility(es);



        timer_formiga.schedule(new TimerTask() {
            @Override
            public void run() {
                handler_formiga.post(new Runnable() {
                    @Override
                    public void run() {
                        direcoes_formiga();

                    }
                });
            }
        }, 0, 1);


        timer_formiga.schedule(new TimerTask() {
            @Override
            public void run() {
                handler_formiga.post(new Runnable() {
                    @Override
                    public void run() {
                        if (isDados_recebidos_formiga()) {
                            contagens_formiga += 1;
                        }

                    }
                });
            }
        }, 0, 20);






        formiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formiga.setBackgroundResource(R.mipmap.forma_morto);
                setDados_recebidos_formiga(false);

            }
        });







    }


    public boolean onTouchEvent(MotionEvent event){

        if (event.getAction() == event.ACTION_DOWN){
            setDados_recebidos_formiga(true);
            contagens_formiga = 0;
            direcoes_formiga = random_formiga.nextInt(20);
            View full_scheen = getWindow().getDecorView();
            int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
            full_scheen.setSystemUiVisibility(es);

        }


        return true;
    }





    public void direcoes_formiga(){
        if (isDados_recebidos_formiga()) {

            if (contagens_formiga == 30) {
//                animation_45_graus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotacao);
//                aranha .startAnimation(animation_45_graus);

                direcoes_formiga = random_formiga.nextInt(25);
                contagens_formiga = 0;
            }
            if (direcoes_formiga >= 0 && direcoes_formiga <= 2) {
                formiga.setBackgroundResource(R.mipmap.formiga_8);
                cima = (int) formiga_rainha.getY();
                cima -= 1;
                formiga_rainha.setY(cima);
            } else if (direcoes_formiga > 2 && direcoes_formiga <= 4) {

                formiga.setBackgroundResource(R.mipmap.formiga_4);
                baixo = (int) formiga_rainha.getY();
                baixo += 1;
                formiga_rainha.setY(baixo);
            } else if (direcoes_formiga > 4 && direcoes_formiga <= 6) {
                formiga.setBackgroundResource(R.mipmap.formiga_6);
                esquerda = (int) formiga_rainha.getX();
                esquerda -= 1;
                formiga_rainha.setX(esquerda);
            } else if (direcoes_formiga > 6 && direcoes_formiga <= 8) {
                formiga.setBackgroundResource(R.mipmap.formiga_2);
                direita = (int) formiga_rainha.getX();
                direita += 1;
                formiga_rainha.setX(direita);

            } else if (direcoes_formiga > 8 && direcoes_formiga <= 10) {
                formiga.setBackgroundResource(R.mipmap.formiga_3);
                direita = (int) formiga_rainha.getX();
                baixo = (int) formiga_rainha.getY();
                direita += 1;
                baixo += 1;
                formiga_rainha.setY(baixo);
                formiga_rainha.setX(direita);

            } else if (direcoes_formiga > 10 && direcoes_formiga <= 12) {
                formiga.setBackgroundResource(R.mipmap.formiga_5);
                esquerda = (int)formiga_rainha.getX();
                baixo = (int) formiga_rainha.getY();
                esquerda -= 1;
                baixo += 1;
                formiga_rainha.setY(baixo);
                formiga_rainha.setX(esquerda);


            } else if (direcoes_formiga > 12 && direcoes_formiga <= 14) {
                formiga.setBackgroundResource(R.mipmap.formiga_7);
                esquerda = (int) formiga_rainha.getX();
                subindo = (int) formiga_rainha.getY();
                esquerda -= 1;
                subindo -= 1;
                formiga_rainha.setY(subindo);
                formiga_rainha.setX(esquerda);

            } else if (direcoes_formiga > 14 && direcoes_formiga <= 16) {
                formiga.setBackgroundResource(R.mipmap.formiga_1);
                direita = (int) formiga_rainha.getX();
                subindo = (int) formiga_rainha.getY();
                direita += 1;
                subindo -= 1;
                formiga_rainha.setY(subindo);
                formiga_rainha.setX(direita);


            }


            if (direita >= relative_formiga.getWidth() + formiga_rainha.getWidth()/2) {
                direita = 0 - formiga_rainha.getWidth()/2;
                formiga_rainha.setX(direita);
            } else if (esquerda < -formiga_rainha.getWidth()/2) {
                esquerda = relative_formiga.getWidth() + formiga_rainha.getWidth()/2;
                formiga_rainha.setX(esquerda);
            }

            if (cima < -formiga_rainha.getHeight()/2) {
                cima = relative_formiga.getHeight() +formiga_rainha.getHeight()/2;
                formiga_rainha.setY(cima);
            } else if (baixo >= relative_formiga.getHeight() + formiga_rainha.getHeight()/2) {
                baixo = 0 - formiga_rainha.getHeight()/2;
                formiga_rainha.setY(baixo);
            }

        }

    }








    public boolean isDados_recebidos_formiga() {
        return dados_recebidos_formiga;
    }

    public void setDados_recebidos_formiga(boolean dados_recebidos_formiga) {
        this.dados_recebidos_formiga = dados_recebidos_formiga;
    }
}