package com.vanderlei.bugcat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Class_all_bugs extends AppCompatActivity {


    Timer timer_all = new Timer();
    Handler handler_all = new Handler();

    private boolean dados_recebidos_all = true;




    //VARIAVEIS PARA BARATA
    Random random_barata_all = new Random();
    private boolean dados_recebidos_barata_all;
    private RelativeLayout barata_noj_all,relative_barata_all;
    private ImageView barata_all;
    private int direcoes_barata_all,contagens_barata_all;
    float cima_barata_all, baixo_barata_all,direita_barata_all,esquerda_barata_all,subindo_all_barata_all;


    //VARIAVEIS PARA FORMIGAS

    Random random_formigas_all = new Random();
    private boolean dados_recebidos_formigas_all;
    private RelativeLayout formiga_rainha_all;
    private ImageView formigas_all;
    private int direcoes_formigas_all,contagens_formigas_all;
    float cima_formigas_all, baixo_formigas_all,direita_formigas_all,esquerda_formigas_all,subindo_all_formigas_all;


    //VARIAVEIS PARA ARANHA

    Random random_aranha_all = new Random();
    private boolean dados_recebidos_aranha_all;
    private RelativeLayout aranha_rainha_all;
    private ImageView aranha_all;
    private int direcoes_aranha_all,contagens_aranha_all;
    float cima_aranha_all, baixo_aranha_all,direita_aranha_all,esquerda_aranha_all,subindo_all_aranha_all;


    //VARIAVEIS RATO

    Random random_rato_all = new Random();
    private boolean dados_recebidos_rato_all;
    private RelativeLayout relative_rato_all;
    private ImageView rato_all;
    private int direcoes_rato_all,contagens_rato_all;
    float cima_rato_all, baixo_rato_all,direita_rato_all,esquerda_rato_all,subindo_all_rato_all;

    TextView text_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_all_bugs);


        text_all = findViewById(R.id.txte_all);
        barata_all = findViewById(R.id.barata_play_all);
        barata_noj_all = findViewById(R.id.barata_noj_all);

        relative_barata_all = findViewById(R.id.relative_all_bugs);

        formigas_all = findViewById(R.id.formiga_play_all);
        formiga_rainha_all = findViewById(R.id.formiga_rainha_all);


        aranha_rainha_all = findViewById(R.id.aranha_rainha_all);
        aranha_all = findViewById(R.id.aranha_play_all);


        relative_rato_all = findViewById(R.id.rato_relative_all);
        rato_all = findViewById(R.id.rato_all);




        Bundle extra = getIntent().getExtras();
        setDados_recebidos_barata_all(extra.getBoolean("escolha_barata_all"));





        timer_all.schedule(new TimerTask() {
            @Override
            public void run() {
                handler_all.post(new TimerTask(){
                   public void run(){

                       text_all.setText(String.valueOf(contagens_rato_all + "\n" + contagens_formigas_all));
                       ligados();
                       direcoes_barata();
                       direcoes_formiga();
                       direcoes_aranha_completo();
                       direcoes_rato();


                   }

                });
            }
        },0,1);



        timer_all.schedule(new TimerTask() {
            @Override
            public void run() {
                handler_all.post(new TimerTask(){
                    public void run(){

                        if (isDados_recebidos_all()) {
                            contagens_barata_all += 1;
                            contagens_formigas_all +=1;
                            contagens_aranha_all +=1;
                            contagens_rato_all +=1;

                        }

                    }

                });
            }
        },0,20);






    }




    /*public boolean onTouchEvent(MotionEvent event){

        if (event.getAction() == event.ACTION_DOWN){
            setDados_recebidos_formiga(true);
            contagens_formiga = 0;
            direcoes_formiga = random_formiga.nextInt(20);
            View full_scheen = getWindow().getDecorView();
            int es = View.SYSTEM_UI_FLAG_FULLSCREEN;
            full_scheen.setSystemUiVisibility(es);

        }


        return true;
    }*/




    public void ligados(){
        if(isDados_recebidos_all()){
            setDados_recebidos_formigas_all(isDados_recebidos_all());
            setDados_recebidos_barata_all(isDados_recebidos_all());
            setDados_recebidos_aranha_all(isDados_recebidos_all());
            setDados_recebidos_rato_all(isDados_recebidos_all());

        }
    }


    public void direcoes_rato(){
        if (isDados_recebidos_rato_all()) {
            if (contagens_rato_all == 30) {
                direcoes_rato_all = random_rato_all.nextInt(20);
                contagens_rato_all = 0;
            }
            if (direcoes_rato_all >= 0 && direcoes_rato_all <= 2) {
                rato_all.setBackgroundResource(R.mipmap.rato_8);
                cima_rato_all = (int) relative_rato_all.getY();
                cima_rato_all -= 1;
                relative_rato_all.setY(cima_rato_all);
            } else if (direcoes_rato_all > 2 && direcoes_rato_all <= 4) {
                rato_all.setBackgroundResource(R.mipmap.rato_7);
                baixo_rato_all = (int) relative_rato_all.getY();
                baixo_rato_all += 1;
                relative_rato_all.setY(baixo_rato_all);
            } else if (direcoes_rato_all > 4 && direcoes_rato_all <= 6) {
                rato_all.setBackgroundResource(R.mipmap.rato_1);
                esquerda_rato_all = (int) relative_rato_all.getX();
                esquerda_rato_all -= 1;
                relative_rato_all.setX(esquerda_rato_all);
            } else if (direcoes_rato_all > 6 && direcoes_rato_all <= 8) {
                rato_all.setBackgroundResource(R.mipmap.rato_3);
                direita_rato_all = (int) relative_rato_all.getX();
                direita_rato_all += 1;
                relative_rato_all.setX(direita_rato_all);

            } else if (direcoes_rato_all > 8 && direcoes_rato_all <= 10) {
                rato_all.setBackgroundResource(R.mipmap.rato_5);
                direita_rato_all = (int) relative_rato_all.getX();
                baixo_rato_all = (int) relative_rato_all.getY();
                direita_rato_all += 1;
                baixo_rato_all += 1;
                relative_rato_all.setY(baixo_rato_all);
                relative_rato_all.setX(direita_rato_all);

            } else if (direcoes_rato_all > 10 && direcoes_rato_all <= 12) {
                rato_all.setBackgroundResource(R.mipmap.rato);
                esquerda_rato_all = (int) relative_rato_all.getX();
                baixo_rato_all = (int) relative_rato_all.getY();
                esquerda_rato_all -= 1;
                baixo_rato_all += 1;
                relative_rato_all.setY(baixo_rato_all);
                relative_rato_all.setX(esquerda_rato_all);


            } else if (direcoes_rato_all > 12 && direcoes_rato_all <= 14) {
                rato_all.setBackgroundResource(R.mipmap.rato_2);
                esquerda_rato_all = (int) relative_rato_all.getX();
                subindo_all_rato_all = (int) relative_rato_all.getY();
                esquerda_rato_all -= 1;
                subindo_all_rato_all -= 1;
                relative_rato_all.setY(subindo_all_rato_all);
                relative_rato_all.setX(esquerda_rato_all);

            } else if (direcoes_rato_all > 14 && direcoes_rato_all <= 16) {
                rato_all.setBackgroundResource(R.mipmap.rato_4);
                direita_rato_all = (int) relative_rato_all.getX();
                subindo_all_rato_all = (int) relative_rato_all.getY();
                direita_rato_all += 1;
                subindo_all_rato_all -= 1;
                relative_rato_all.setY(subindo_all_rato_all);
                relative_rato_all.setX(direita_rato_all);

            }


            if (direita_rato_all >= relative_barata_all.getWidth() + relative_rato_all.getWidth()/2) {
                direita_rato_all = 0 - relative_rato_all.getWidth()/2;
                relative_rato_all.setX(direita_rato_all);

            } else if (esquerda_rato_all < -relative_barata_all.getWidth()/2) {
                esquerda_rato_all = relative_barata_all.getWidth() + relative_rato_all.getWidth()/2;
                relative_rato_all.setX(esquerda_rato_all);
            }

            if (cima_rato_all < -relative_barata_all.getHeight()) {
                cima_rato_all = relative_barata_all.getHeight() + relative_rato_all.getHeight()/2;
                relative_rato_all.setY(cima_rato_all);
            } else if (baixo_rato_all >= relative_barata_all.getHeight() + relative_rato_all.getHeight()/2) {
                baixo_rato_all = 0 - relative_barata_all.getHeight() + relative_rato_all.getHeight()/2;
                relative_rato_all.setY(baixo_rato_all);
            }
        }

    }





    public void direcoes_aranha_completo(){
        if (isDados_recebidos_aranha_all()) {

            if (contagens_aranha_all == 30) {
//                animation_45_graus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotacao);
//                aranha .startAnimation(animation_45_graus);

                direcoes_aranha_all = random_aranha_all.nextInt(25);
                contagens_aranha_all = 0;
            }
            if (direcoes_aranha_all >= 0 && direcoes_aranha_all <= 2) {
                aranha_all.setBackgroundResource(R.mipmap.aranha_3);
                cima_aranha_all = (int) aranha_rainha_all.getY();
                cima_aranha_all -= 1;
                aranha_rainha_all.setY(cima_aranha_all);
            } else if (direcoes_aranha_all > 2 && direcoes_aranha_all <= 4) {

                aranha_all.setBackgroundResource(R.mipmap.aranha_5);
                baixo_aranha_all = (int) aranha_rainha_all.getY();
                baixo_aranha_all += 1;
                aranha_rainha_all.setY(baixo_aranha_all);
            } else if (direcoes_aranha_all > 4 && direcoes_aranha_all <= 6) {

//                movimento_aranha();
                aranha_all.setBackgroundResource(R.mipmap.aranha_7);
                esquerda_aranha_all = (int) aranha_rainha_all.getX();
                esquerda_aranha_all -= 1;
                aranha_rainha_all.setX(esquerda_aranha_all);
            } else if (direcoes_aranha_all > 6 && direcoes_aranha_all <= 8) {
                aranha_all.setBackgroundResource(R.mipmap.aranha_8);
                direita_aranha_all = (int) aranha_rainha_all.getX();
                direita_aranha_all += 1;
                aranha_rainha_all.setX(direita_aranha_all);

            } else if (direcoes_aranha_all > 8 && direcoes_aranha_all <= 10) {
                aranha_all.setBackgroundResource(R.mipmap.aranha_6);
                direita_aranha_all = (int) aranha_rainha_all.getX();
                baixo_aranha_all = (int) aranha_rainha_all.getY();
                direita_aranha_all += 1;
                baixo_aranha_all += 1;
                aranha_rainha_all.setY(baixo_aranha_all);
                aranha_rainha_all.setX(direita_aranha_all);

            } else if (direcoes_aranha_all > 10 && direcoes_aranha_all <= 12) {
                aranha_all.setBackgroundResource(R.mipmap.aranha_4);
                esquerda_aranha_all = (int)aranha_rainha_all.getX();
                baixo_aranha_all = (int) aranha_rainha_all.getY();
                esquerda_aranha_all -= 1;
                baixo_aranha_all += 1;
                aranha_rainha_all.setY(baixo_aranha_all);
                aranha_rainha_all.setX(esquerda_aranha_all);


            } else if (direcoes_aranha_all > 12 && direcoes_aranha_all <= 14) {
                aranha_all.setBackgroundResource(R.mipmap.aranha_2);
                esquerda_aranha_all = (int) aranha_rainha_all.getX();
                subindo_all_aranha_all = (int) aranha_rainha_all.getY();
                esquerda_aranha_all -= 1;
                subindo_all_aranha_all -= 1;
                aranha_rainha_all.setY(subindo_all_aranha_all);
                aranha_rainha_all.setX(esquerda_aranha_all);

            } else if (direcoes_aranha_all > 14 && direcoes_aranha_all <= 16) {
                aranha_all.setBackgroundResource(R.mipmap.aranha_1);
                direita_aranha_all = (int) aranha_rainha_all.getX();
                subindo_all_aranha_all = (int) aranha_rainha_all.getY();
                direita_aranha_all += 1;
                subindo_all_aranha_all -= 1;
                aranha_rainha_all.setY(subindo_all_aranha_all);
                aranha_rainha_all.setX(direita_aranha_all);


            }


            if (direita_aranha_all >= relative_barata_all.getWidth() + aranha_rainha_all.getWidth()/2) {
                direita_aranha_all = 0 - aranha_rainha_all.getWidth()/2;
                aranha_rainha_all.setX(direita_aranha_all);
            } else if (esquerda_aranha_all < -aranha_rainha_all.getWidth()/2) {
                esquerda_aranha_all = relative_barata_all.getWidth() + aranha_rainha_all.getWidth()/2;
                aranha_rainha_all.setX(esquerda_aranha_all);
            }

            if (cima_aranha_all < -aranha_rainha_all.getHeight()/2) {
                cima_aranha_all = relative_barata_all.getHeight() + aranha_rainha_all.getHeight()/2;
                aranha_rainha_all.setY(cima_aranha_all);
            } else if (baixo_aranha_all >= relative_barata_all.getHeight() + aranha_rainha_all.getHeight()/2) {
                baixo_aranha_all = 0 - aranha_rainha_all.getHeight()/2;
                aranha_rainha_all.setY(baixo_aranha_all);
            }

        }

    }



    public void direcoes_formiga(){
        if (isDados_recebidos_formigas_all()) {

            if (contagens_formigas_all == 80) {
//                animation_45_graus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotacao);
//                aranha .startAnimation(animation_45_graus);

                direcoes_formigas_all = random_formigas_all.nextInt(18);
                contagens_formigas_all = 0;
            }
            if (direcoes_formigas_all >= 0 && direcoes_formigas_all <= 2) {
                formigas_all.setBackgroundResource(R.mipmap.formiga_8);
                cima_formigas_all = (int) formiga_rainha_all.getY();
                cima_formigas_all -= 1;
                formiga_rainha_all.setY(cima_formigas_all);
            } else if (direcoes_formigas_all > 2 && direcoes_formigas_all <= 4) {

                formigas_all.setBackgroundResource(R.mipmap.formiga_4);
                baixo_formigas_all = (int) formiga_rainha_all.getY();
                baixo_formigas_all += 1;
                formiga_rainha_all.setY(baixo_formigas_all);
            } else if (direcoes_formigas_all > 4 && direcoes_formigas_all <= 6) {
                formigas_all.setBackgroundResource(R.mipmap.formiga_6);
                esquerda_formigas_all = (int) formiga_rainha_all.getX();
                esquerda_formigas_all -= 1;
                formiga_rainha_all.setX(esquerda_formigas_all);
            } else if (direcoes_formigas_all > 6 && direcoes_formigas_all <= 8) {
                formigas_all.setBackgroundResource(R.mipmap.formiga_2);
                direita_formigas_all = (int) formiga_rainha_all.getX();
                direita_formigas_all += 1;
                formiga_rainha_all.setX(direita_formigas_all);

            } else if (direcoes_formigas_all > 8 && direcoes_formigas_all <= 10) {
                formigas_all.setBackgroundResource(R.mipmap.formiga_3);
                direita_formigas_all = (int) formiga_rainha_all.getX();
                baixo_formigas_all = (int) formiga_rainha_all.getY();
                direita_formigas_all+= 1;
                baixo_formigas_all += 1;
                formiga_rainha_all.setY(baixo_formigas_all);
                formiga_rainha_all.setX(direita_formigas_all);

            } else if (direcoes_formigas_all > 10 && direcoes_formigas_all <= 12) {
                formigas_all.setBackgroundResource(R.mipmap.formiga_5);
                esquerda_formigas_all = (int)formiga_rainha_all.getX();
                baixo_formigas_all = (int) formiga_rainha_all.getY();
                esquerda_formigas_all -= 1;
                baixo_formigas_all += 1;
                formiga_rainha_all.setY(baixo_formigas_all);
                formiga_rainha_all.setX(esquerda_formigas_all);


            } else if (direcoes_formigas_all > 12 && direcoes_formigas_all <= 14) {
                formigas_all.setBackgroundResource(R.mipmap.formiga_7);
                esquerda_formigas_all = (int) formiga_rainha_all.getX();
                subindo_all_formigas_all = (int) formiga_rainha_all.getY();
                esquerda_formigas_all -= 1;
                subindo_all_formigas_all -= 1;
                formiga_rainha_all.setY(subindo_all_formigas_all);
                formiga_rainha_all.setX(esquerda_formigas_all);

            } else if (direcoes_formigas_all > 14 && direcoes_formigas_all <= 16) {
                formigas_all.setBackgroundResource(R.mipmap.formiga_1);
                direita_formigas_all = (int) formiga_rainha_all.getX();
                subindo_all_formigas_all = (int) formiga_rainha_all.getY();
                direita_formigas_all += 1;
                subindo_all_formigas_all -= 1;
                formiga_rainha_all.setY(subindo_all_formigas_all);
                formiga_rainha_all.setX(direita_formigas_all);


            }


            if (direita_formigas_all >= relative_barata_all.getWidth() + formiga_rainha_all.getWidth()/2) {
                direita_formigas_all = 0 - formiga_rainha_all.getWidth()/2;
                formiga_rainha_all.setX(direita_formigas_all);
            } else if (esquerda_formigas_all < -formiga_rainha_all.getWidth()/2) {
                esquerda_formigas_all = relative_barata_all.getWidth() + formiga_rainha_all.getWidth()/2;
                formiga_rainha_all.setX(esquerda_formigas_all);
            }

            if (cima_formigas_all < -formiga_rainha_all.getHeight()/2) {
                cima_formigas_all = relative_barata_all.getHeight() +formiga_rainha_all.getHeight()/2;
                formiga_rainha_all.setY(cima_formigas_all);
            } else if (baixo_formigas_all >= relative_barata_all.getHeight() + formiga_rainha_all.getHeight()/2) {
                baixo_formigas_all = 0 - formiga_rainha_all.getHeight()/2;
                formiga_rainha_all.setY(baixo_formigas_all);
            }

        }

    }


    public void direcoes_barata() {



        if (isDados_recebidos_barata_all()) {
            if (contagens_barata_all == 40) {
//                animation_45_graus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotacao);
//                aranha .startAnimation(animation_45_graus);

                direcoes_barata_all = random_barata_all.nextInt(18);
                contagens_barata_all = 0;
            }
            if (direcoes_barata_all >= 0 && direcoes_barata_all <= 2) {
                barata_all.setBackgroundResource(R.mipmap.barata1);
                cima_barata_all = (int) barata_noj_all.getY();
                cima_barata_all -= 1;
                barata_noj_all.setY(cima_barata_all);
            } else if (direcoes_barata_all > 2 && direcoes_barata_all <= 4) {

                barata_all.setBackgroundResource(R.mipmap.barata5);
                baixo_barata_all = (int) barata_noj_all.getY();
                baixo_barata_all += 1;
                barata_noj_all.setY(baixo_barata_all);
            } else if (direcoes_barata_all > 4 && direcoes_barata_all <= 6) {
                barata_all.setBackgroundResource(R.mipmap.barata3);
                esquerda_barata_all = (int) barata_noj_all.getX();
                esquerda_barata_all -= 1;
                barata_noj_all.setX(esquerda_barata_all);
            } else if (direcoes_barata_all > 6 && direcoes_barata_all <= 8) {
                barata_all.setBackgroundResource(R.mipmap.barata7);
                direita_barata_all = (int) barata_noj_all.getX();
                direita_barata_all += 1;
                barata_noj_all.setX(direita_barata_all);

            } else if (direcoes_barata_all > 8 && direcoes_barata_all <= 10) {
                barata_all.setBackgroundResource(R.mipmap.barata6);
                direita_barata_all = (int) barata_noj_all.getX();
                baixo_barata_all = (int) barata_noj_all.getY();
                direita_barata_all += 1;
                baixo_barata_all += 1;
                barata_noj_all.setY(baixo_barata_all);
                barata_noj_all.setX(direita_barata_all);

            } else if (direcoes_barata_all > 10 && direcoes_barata_all <= 12) {
                barata_all.setBackgroundResource(R.mipmap.barata4);
                esquerda_barata_all = (int) barata_noj_all.getX();
                baixo_barata_all = (int) barata_noj_all.getY();
                esquerda_barata_all -= 1;
                baixo_barata_all += 1;
                barata_noj_all.setY(baixo_barata_all);
                barata_noj_all.setX(esquerda_barata_all);


            } else if (direcoes_barata_all > 12 && direcoes_barata_all <= 14) {
                barata_all.setBackgroundResource(R.mipmap.barata2);
                esquerda_barata_all = (int) barata_noj_all.getX();
                esquerda_barata_all -= 1;
                subindo_all_barata_all = (int) barata_noj_all.getY();
                subindo_all_barata_all -= 1;
                barata_noj_all.setY(subindo_all_barata_all);
                barata_noj_all.setX(esquerda_barata_all);

            } else if (direcoes_barata_all > 14 && direcoes_barata_all <= 16) {
                barata_all.setBackgroundResource(R.mipmap.barata8);
                direita_barata_all = (int) barata_noj_all.getX();
                subindo_all_barata_all = (int) barata_noj_all.getY();
                direita_barata_all += 1;
                subindo_all_barata_all -= 1;
                barata_noj_all.setY(subindo_all_barata_all);
                barata_noj_all.setX(direita_barata_all);


            }


            if (direita_barata_all >= relative_barata_all.getWidth() + barata_noj_all.getWidth() / 2) {
                direita_barata_all = 0 - barata_noj_all.getWidth() / 2;
                barata_noj_all.setX(direita_barata_all);
            } else if (esquerda_barata_all < -barata_noj_all.getWidth() / 2) {
                esquerda_barata_all = relative_barata_all.getWidth() + barata_noj_all.getWidth() / 2;
                barata_noj_all.setX(esquerda_barata_all);
            }

            if (cima_barata_all < -relative_barata_all.getHeight() / 2) {
                cima_barata_all = relative_barata_all.getHeight() + barata_noj_all.getHeight() / 2;
                barata_noj_all.setY(cima_barata_all);
            } else if (baixo_barata_all >= relative_barata_all.getHeight() + barata_noj_all.getHeight() / 2) {
                baixo_barata_all = 0 - barata_noj_all.getHeight() / 2;
                barata_noj_all.setY(baixo_barata_all);
            }

        }


    }

    public boolean isDados_recebidos_barata_all() {
        return dados_recebidos_barata_all;
    }

    public void setDados_recebidos_barata_all(boolean dados_recebidos_barata_all) {
        this.dados_recebidos_barata_all = dados_recebidos_barata_all;
    }


    public boolean isDados_recebidos_formigas_all() {
        return dados_recebidos_formigas_all;
    }

    public void setDados_recebidos_formigas_all(boolean dados_recebidos_formigas_all) {
        this.dados_recebidos_formigas_all = dados_recebidos_formigas_all;
    }


    public boolean isDados_recebidos_all() {
        return dados_recebidos_all;
    }

    public void setDados_recebidos_all(boolean dados_recebidos_all) {
        this.dados_recebidos_all = dados_recebidos_all;
    }

    public boolean isDados_recebidos_aranha_all() {
        return dados_recebidos_aranha_all;
    }

    public void setDados_recebidos_aranha_all(boolean dados_recebidos_aranha_all) {
        this.dados_recebidos_aranha_all = dados_recebidos_aranha_all;
    }


    public boolean isDados_recebidos_rato_all() {
        return dados_recebidos_rato_all;
    }

    public void setDados_recebidos_rato_all(boolean dados_recebidos_rato_all) {
        this.dados_recebidos_rato_all = dados_recebidos_rato_all;
    }
}