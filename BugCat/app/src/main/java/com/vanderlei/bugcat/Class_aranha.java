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

public class Class_aranha extends AppCompatActivity {
    private Timer  timer_ara;
    private Handler handler_ara;
    private RelativeLayout relative_ara,aranha_rainha;
    private boolean dados_recebidos_aranha,ligar_direcao_ara = true;
    private ImageView aranha;
    private Random random = new Random();


    private int cima, baixo,direita,esquerda,subindo;

    private int direcoes_aranha,contagens_aranha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_aranha);


        aranha = findViewById(R.id.aranha_play);
        aranha_rainha = findViewById(R.id.aranha_rainha);
        relative_ara = findViewById(R.id.relative_ara);




        Bundle extra = getIntent().getExtras();
        setDados_recebidos_aranha(extra.getBoolean("escolha_aranha"));

        timer_ara = new Timer();
        handler_ara = new Handler();


        timer_ara.schedule(new TimerTask() {
            @Override
            public void run() {
                handler_ara.post(new Runnable() {
                    @Override
                    public void run() {


                        direcoes_aranha();

                    }
                });
            }
        },0,1);

        View full_scheen = getWindow().getDecorView();
        int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
        full_scheen.setSystemUiVisibility(es);

        timer_ara.schedule(new TimerTask() {
            @Override
            public void run() {
                handler_ara.post(new Runnable() {
                    @Override
                    public void run() {
                        if (isDados_recebidos_aranha()) {
                            contagens_aranha += 1;
                        }

//                        if (es != View.SYSTEM_UI_FLAG_FULLSCREEN) {
//                            full_scheen.setSystemUiVisibility(es);
//                        }
//                        movimento_aranha();

//                        funcoes_pivots();

                    }
                });
            }
        }, 0, 20);








        aranha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aranha.setBackgroundResource(R.mipmap.forma_morto);
                setDados_recebidos_aranha(false);

            }
        });







    }


    public boolean onTouchEvent(MotionEvent event){

        if (event.getAction() == event.ACTION_DOWN){
            setDados_recebidos_aranha(true);
            contagens_aranha = 0;
            direcoes_aranha = random.nextInt(20);
            View full_scheen = getWindow().getDecorView();
            int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
            full_scheen.setSystemUiVisibility(es);

        }


        return true;
    }


    public void direcoes_aranha(){
        if (isDados_recebidos_aranha()) {

            if (contagens_aranha == 30) {
//                animation_45_graus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotacao);
//                aranha .startAnimation(animation_45_graus);

                direcoes_aranha = random.nextInt(25);
                contagens_aranha = 0;
            }
            if (direcoes_aranha >= 0 && direcoes_aranha <= 2) {
                aranha.setBackgroundResource(R.mipmap.aranha_3);
                cima = (int) aranha_rainha.getY();
                cima -= 1;
                aranha_rainha.setY(cima);
            } else if (direcoes_aranha > 2 && direcoes_aranha <= 4) {

                aranha.setBackgroundResource(R.mipmap.aranha_5);
                baixo = (int) aranha_rainha.getY();
                baixo += 1;
                aranha_rainha.setY(baixo);
            } else if (direcoes_aranha > 4 && direcoes_aranha <= 6) {

//                movimento_aranha();
                aranha.setBackgroundResource(R.mipmap.aranha_7);
                esquerda = (int) aranha_rainha.getX();
                esquerda -= 1;
                aranha_rainha.setX(esquerda);
            } else if (direcoes_aranha > 6 && direcoes_aranha <= 8) {
                aranha.setBackgroundResource(R.mipmap.aranha_8);
                direita = (int) aranha_rainha.getX();
                direita += 1;
                aranha_rainha.setX(direita);

            } else if (direcoes_aranha > 8 && direcoes_aranha <= 10) {
                aranha.setBackgroundResource(R.mipmap.aranha_6);
                direita = (int) aranha_rainha.getX();
                baixo = (int) aranha_rainha.getY();
                direita += 1;
                baixo += 1;
                aranha_rainha.setY(baixo);
                aranha_rainha.setX(direita);

            } else if (direcoes_aranha > 10 && direcoes_aranha <= 12) {
                aranha.setBackgroundResource(R.mipmap.aranha_4);
                esquerda = (int)aranha_rainha.getX();
                baixo = (int) aranha_rainha.getY();
                esquerda -= 1;
                baixo += 1;
                aranha_rainha.setY(baixo);
                aranha_rainha.setX(esquerda);


            } else if (direcoes_aranha > 12 && direcoes_aranha <= 14) {
                aranha.setBackgroundResource(R.mipmap.aranha_2);
                esquerda = (int) aranha_rainha.getX();
                subindo = (int) aranha_rainha.getY();
                esquerda -= 1;
                subindo -= 1;
                aranha_rainha.setY(subindo);
                aranha_rainha.setX(esquerda);

            } else if (direcoes_aranha > 14 && direcoes_aranha <= 16) {
                aranha.setBackgroundResource(R.mipmap.aranha_1);
                direita = (int) aranha_rainha.getX();
                subindo = (int) aranha_rainha.getY();
                direita += 1;
                subindo -= 1;
                aranha_rainha.setY(subindo);
                aranha_rainha.setX(direita);


            }


            if (direita >= relative_ara.getWidth() + aranha_rainha.getWidth()/2) {
                direita = 0 - aranha_rainha.getWidth()/2;
                aranha_rainha.setX(direita);
            } else if (esquerda < -aranha_rainha.getWidth()/2) {
                esquerda = relative_ara.getWidth() + aranha_rainha.getWidth()/2;
                aranha_rainha.setX(esquerda);
            }

            if (cima < -aranha_rainha.getHeight()/2) {
                cima = relative_ara.getHeight() + aranha_rainha.getHeight()/2;
                aranha_rainha.setY(cima);
            } else if (baixo >= relative_ara.getHeight() + aranha_rainha.getHeight()/2) {
                baixo = 0 - aranha_rainha.getHeight()/2;
                aranha_rainha.setY(baixo);
            }

        }

    }















    public boolean isDados_recebidos_aranha() {
        return dados_recebidos_aranha;
    }

    public void setDados_recebidos_aranha(boolean dados_recebidos_aranha) {
        this.dados_recebidos_aranha = dados_recebidos_aranha;
    }






}