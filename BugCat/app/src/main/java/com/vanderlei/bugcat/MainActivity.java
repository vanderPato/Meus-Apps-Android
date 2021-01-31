package com.vanderlei.bugcat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rato_relative,relative;
    ImageView rato;
    Timer timer;
    Handler handler;
    Random random ;
    MotionEvent motion;
    TextView tx;
    boolean ligar_direcao =true, dados_recebidos_rato,dados_recebidos_formiga;
    int cima, baixo,direita,esquerda,subindo;
    int direcoes,contagens;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        tx = findViewById(R.id.tx);
        rato = findViewById(R.id.rato);
        relative = findViewById(R.id.relative);
        rato_relative = findViewById(R.id.rato_relative);


        View full_scheen = getWindow().getDecorView();
        int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
        full_scheen.setSystemUiVisibility(es);


        Bundle extra = getIntent().getExtras();
        setDados_recebidos_rato(extra.getBoolean("escolha_rato"));


        timer = new Timer();
        handler = new Handler();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        direcoes_rato();


                    }
                });
            }
        }, 0, 1);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (ligar_direcao) {
                            contagens += 1;
                        }
               }
                });
            }
        }, 0, 20);



        rato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rato.setBackgroundResource(R.mipmap.forma_morto);
                setDados_recebidos_rato(false);
            }
        });


    }


      public boolean onTouchEvent(MotionEvent motion){
        this.motion = motion;

        if(motion.getAction()== MotionEvent.ACTION_DOWN){
            setDados_recebidos_rato(true);
            contagens = 0;
            View full_scheen = getWindow().getDecorView();
            int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
            full_scheen.setSystemUiVisibility(es);


        }

        return true;

    }

    public void direcoes_rato(){
        if (isDados_recebidos_rato()) {
            if (contagens == 30) {
                direcoes = random.nextInt(20);
                contagens = 0;
            }
            if (direcoes >= 0 && direcoes <= 2) {
                rato.setBackgroundResource(R.mipmap.rato_8);
                cima = (int) rato_relative.getY();
                cima -= 1;
                rato_relative.setY(cima);
            } else if (direcoes > 2 && direcoes <= 4) {
                rato.setBackgroundResource(R.mipmap.rato_7);
                baixo = (int) rato_relative.getY();
                baixo += 1;
                rato_relative.setY(baixo);
            } else if (direcoes > 4 && direcoes <= 6) {
                rato.setBackgroundResource(R.mipmap.rato_1);
                esquerda = (int) rato_relative.getX();
                esquerda -= 1;
                rato_relative.setX(esquerda);
            } else if (direcoes > 6 && direcoes <= 8) {
                rato.setBackgroundResource(R.mipmap.rato_3);
                direita = (int) rato_relative.getX();
                direita += 1;
                rato_relative.setX(direita);

            } else if (direcoes > 8 && direcoes <= 10) {
                rato.setBackgroundResource(R.mipmap.rato_5);
                direita = (int) rato_relative.getX();
                baixo = (int) rato_relative.getY();
                direita += 1;
                baixo += 1;
                rato_relative.setY(baixo);
                rato_relative.setX(direita);

            } else if (direcoes > 10 && direcoes <= 12) {
                rato.setBackgroundResource(R.mipmap.rato);
                esquerda = (int) rato_relative.getX();
                baixo = (int) rato_relative.getY();
                esquerda -= 1;
                baixo += 1;
                rato_relative.setY(baixo);
                rato_relative.setX(esquerda);


            } else if (direcoes > 12 && direcoes <= 14) {
                rato.setBackgroundResource(R.mipmap.rato_2);
                esquerda = (int) rato_relative.getX();
                subindo = (int) rato_relative.getY();
                esquerda -= 1;
                subindo -= 1;
                rato_relative.setY(subindo);
                rato_relative.setX(esquerda);

            } else if (direcoes > 14 && direcoes <= 16) {
                rato.setBackgroundResource(R.mipmap.rato_4);
                direita = (int) rato_relative.getX();
                subindo = (int) rato_relative.getY();
                direita += 1;
                subindo -= 1;
                rato_relative.setY(subindo);
                rato_relative.setX(direita);

            }


            if (direita >= relative.getWidth() + rato_relative.getWidth()/2) {
                direita = 0 - rato_relative.getWidth()/2;
                rato_relative.setX(direita);

            } else if (esquerda < -rato_relative.getWidth()/2) {
                esquerda = relative.getWidth() + rato_relative.getWidth()/2;
                rato_relative.setX(esquerda);
            }

            if (cima < -rato_relative.getHeight()/2) {
                cima = relative.getHeight() + rato_relative.getHeight()/2;
                rato_relative.setY(cima);
            } else if (baixo >= relative.getHeight() + rato_relative.getHeight()/2) {
                baixo = 0 - rato_relative.getHeight()/2;
                rato_relative.setY(baixo);
            }
        }

    }

    public boolean isDados_recebidos_rato() {
        return dados_recebidos_rato;
    }

    public void setDados_recebidos_rato(boolean dados_recebidos_rato) {
        this.dados_recebidos_rato = dados_recebidos_rato;
    }







}