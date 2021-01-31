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

public class Class_barata extends AppCompatActivity {

    private Random random_barata = new Random();
    private Timer timer_barata = new Timer();
    private Handler handler_barata = new Handler();
    private RelativeLayout barata_noj,relative_barata;
    private ImageView barata;
    private boolean dados_recebidos_barata;
    private int direcoes_barata,contagens_barata;
    int cima, baixo,direita,esquerda,subindo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_barata);




        barata = findViewById(R.id.barata_play);
        barata_noj = findViewById(R.id.barata_noj);
        relative_barata = findViewById(R.id.relative_barata);


        Bundle extra = getIntent().getExtras();
        setDados_recebidos_barata(extra.getBoolean("escolha_barata"));

        View full_scheen = getWindow().getDecorView();
        int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
        full_scheen.setSystemUiVisibility(es);


        timer_barata.schedule(new TimerTask(){
            public void run(){
                handler_barata.post(new Runnable(){
                    public void run( ){
                        direcoes_barata();

                    }
                });
            }
        }, 0,1);



        timer_barata.schedule(new TimerTask(){
            public void run(){
                handler_barata.post(new Runnable(){
                    public void run( ){
                        if (isDados_recebidos_barata()) {
                            contagens_barata += 1;
                        }
                    }
                });
            }
        }, 0,20);


        barata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barata.setBackgroundResource(R.mipmap.forma_morto);
                setDados_recebidos_barata(false);
            }
        });

}


    public boolean onTouchEvent(MotionEvent event){

        if (event.getAction() == event.ACTION_DOWN){
            setDados_recebidos_barata(true);
            contagens_barata = 0;
            direcoes_barata = random_barata.nextInt(20);
            View full_scheen = getWindow().getDecorView();
            int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
            full_scheen.setSystemUiVisibility(es);

        }


        return true;
    }



    public void direcoes_barata(){
        if (isDados_recebidos_barata()) {


            if (contagens_barata == 30) {
//                animation_45_graus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotacao);
//                aranha .startAnimation(animation_45_graus);

                direcoes_barata = random_barata.nextInt(20);
                contagens_barata = 0;
            }
            if (direcoes_barata >= 0 && direcoes_barata <= 2) {
                barata.setBackgroundResource(R.mipmap.barata1);
                cima = (int) barata_noj.getY();
                cima -= 1;
                barata_noj.setY(cima);
            } else if (direcoes_barata > 2 && direcoes_barata <= 4) {

                barata.setBackgroundResource(R.mipmap.barata5);
                baixo = (int) barata_noj.getY();
                baixo += 1;
                barata_noj.setY(baixo);
            } else if (direcoes_barata > 4 && direcoes_barata <= 6) {
                barata.setBackgroundResource(R.mipmap.barata3);
                esquerda = (int) barata_noj.getX();
                esquerda -= 1;
                barata_noj.setX(esquerda);
            } else if (direcoes_barata > 6 && direcoes_barata <= 8) {
                barata.setBackgroundResource(R.mipmap.barata7);
                direita = (int) barata_noj.getX();
                direita += 1;
                barata_noj.setX(direita);

            } else if (direcoes_barata > 8 && direcoes_barata <= 10) {
                barata.setBackgroundResource(R.mipmap.barata6);
                direita = (int) barata_noj.getX();
                baixo = (int) barata_noj.getY();
                direita += 1;
                baixo += 1;
                barata_noj.setY(baixo);
                barata_noj.setX(direita);

            } else if (direcoes_barata > 10 && direcoes_barata <= 12) {
                barata.setBackgroundResource(R.mipmap.barata4);
                esquerda = (int)barata_noj.getX();
                baixo = (int) barata_noj.getY();
                esquerda -= 1;
                baixo += 1;
                barata_noj.setY(baixo);
                barata_noj.setX(esquerda);


            } else if (direcoes_barata > 12 && direcoes_barata  <= 14) {
                barata.setBackgroundResource(R.mipmap.barata2);
                esquerda = (int) barata_noj.getX();
                subindo = (int) barata_noj.getY();
                esquerda -= 1;
                subindo -= 1;
                barata_noj.setY(subindo);
                barata_noj.setX(esquerda);

            } else if (direcoes_barata > 14 && direcoes_barata <= 16) {
                barata.setBackgroundResource(R.mipmap.barata8);
                direita = (int) barata_noj.getX();
                subindo = (int) barata_noj.getY();
                direita += 1;
                subindo -= 1;
                barata_noj.setY(subindo);
                barata_noj.setX(direita);


            }


            if (direita >= relative_barata.getWidth() + barata_noj.getWidth()/2) {
                direita = 0 - barata_noj.getWidth()/2;
                barata_noj.setX(direita);
            } else if (esquerda < -barata_noj.getWidth()/2) {
                esquerda = relative_barata.getWidth() + barata_noj.getWidth()/2;
                barata_noj.setX(esquerda);
            }

            if (cima < -relative_barata.getHeight()/2) {
                cima = relative_barata.getHeight() + barata_noj.getHeight()/2;
                barata_noj.setY(cima);
            } else if (baixo >= relative_barata.getHeight() + barata_noj.getHeight()/2) {
                baixo = 0 - barata_noj.getHeight()/2;
                barata_noj.setY(baixo);
            }

        }

    }








    public boolean isDados_recebidos_barata() {
        return dados_recebidos_barata;
    }

    public void setDados_recebidos_barata(boolean dados_recebidos_barata) {
        this.dados_recebidos_barata = dados_recebidos_barata;
    }



}