package com.vanderlei.apertaaperta1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Usuario usuario = new Usuario();
    Random random = new Random();
    RelativeLayout layout;
    Timer timer;
    Handler handler;
    Button restart;
    Sons_game sons_game;




    int fim_de_jogo = 10;

    int duble_pontuacao,dube_fim_game;
    ImageView meteoro_caindo1, meteoro_caindo2, meteoro_caindo3, meteoro_caindo4,vida;

    ImageButton figura1, figura2, figura3, figura4,
            figura5, figura6, figura7, figura8, figura9, figura10, figura11, figura12, figura13, figura14, figura15, figura16;

    TextView tx_1, tx_2, tx_3, tx_4, tx_5, tx_6, tx_7, tx_8, tx_9, tx_10, tx_11, tx_12, tx_13, tx_14, tx_15, tx_16,
            tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10, tx11, tx12, tx13, tx14, tx15, tx16, tx17, painel,painel_fim_game,painel_fim_game1;


    int valor_tx2 = 0, valor_tx3 = 0, valor_tx4 = 0, valor_tx5, valor_tx6, valor_tx7,
            valor_tx8, valor_tx9, valor_tx10, valor_tx11, valor_tx12, valor_tx13, valor_tx14, valor_tx15, valor_tx16, valor_tx17,
            contagem_fin_1, contagem_fin_2, contagem_fin_3, contagem_fin_4, pontuacao = 5,
            contagem_fin_5, contagem_fin_6, contagem_fin_7, contagem_fin_8, contagem_fim_9,
            contagem_fim_10, contagem_fim_11, contagem_fim_12, contagem_fim_13, contagem_fim_14, contagem_fim_15, contagem_fim_16;

    float level_cair = 1;

    boolean ligar_cair = true, ligar_cair1 = false, ligar_cair2 = false, ligar_cair3 = false,
            ligar_cair5 = true, ligar_cair6 = false, ligar_cair7 = false, ligar_cair8 = false,
            ligar_esquerdo = true, ligar_esquerdo1 = false, ligar_esquerdo2 = false, ligar_esquerdo3 = false,
            ligar_direito = true, ligar_direito1 = false, ligar_direito2 = false, ligar_direito3 = false,pause_play = false;

    boolean meteoro_ligado = true;
    int meteoro_ativado = 500, meteoro_ativado1 = 500, meteoro_ativado2 = 500, meteoro_ativado3 = 500;
    int meteoroX = 0, meteoroX1 = 0, meteoroX2 = 0, meteoroX3 = 0;

    float velocidade_cair = -500, velocidade_cair1 = -500, velocidade_cair2 = -500, velocidade_cair3 = -500,
            velocidade_cair4 = -700, velocidade_cair5 = -500, velocidade_cair6 = -500, velocidade_cair7 = -500,
            ativado_esquerdo = -800, ativado_esquerdo1 = -300, ativado_esquerdo2 = -400, ativado_esquerdo3 = -400,
            ativado_p_direito = -400, ativado_p_direito1 = -400, ativado_p_direito2 = -400, ativado_p_direito3 = -400;


    float figura1_x, figura2_x, figura3_x, figura4_x, figura5_x, figura6_x, figura7_x, figura8_x, figura9_x;
    float tx1_x;



    float figura1_y, figura2_y, figura3_y, figura4_y, figura5_y, figura6_y, figura7_y, figura8_y, figura9_y, figura10_y, figura11_y, figura12_y, figura13_y, figura14_y, figura15_y, figura16_y;
    float tx1_y;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




       AdView adView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);





        vida = findViewById(R.id.vida);
        painel_fim_game = findViewById(R.id.painel_fim_game);
        painel_fim_game1 = findViewById(R.id.painel_fim_game1);
        restart = findViewById(R.id.restart);

        figura1 = findViewById(R.id.figura1);
        tx_1 = findViewById(R.id.tx_1);
        tx2 = findViewById(R.id.tx2);

        figura2 = findViewById(R.id.figura2);
        tx_2 = findViewById(R.id.tx_2);
        tx3 = findViewById(R.id.tx3);

        figura3 = findViewById(R.id.figura3);
        tx_3 = findViewById(R.id.tx_3);
        tx4 = findViewById(R.id.tx4);


        figura4 = findViewById(R.id.figura4);
        tx_4 = findViewById(R.id.tx_4);
        tx5 = findViewById(R.id.tx5);

        figura5 = findViewById(R.id.figura5);
        tx_5 = findViewById(R.id.tx_5);
        tx6 = findViewById(R.id.tx6);

        figura6 = findViewById(R.id.figura6);
        tx_6 = findViewById(R.id.tx_6);
        tx7 = findViewById(R.id.tx7);


        figura7 = findViewById(R.id.figura7);
        tx_7 = findViewById(R.id.tx_7);
        tx8 = findViewById(R.id.tx8);


        figura8 = findViewById(R.id.figura8);
        tx_8 = findViewById(R.id.tx_8);
        tx9 = findViewById(R.id.tx9);


        figura9 = findViewById(R.id.figura9);
        tx_9 = findViewById(R.id.tx_9);
        tx10 = findViewById(R.id.tx10);


        figura10 = findViewById(R.id.figura10);
        tx_10 = findViewById(R.id.tx_10);
        tx11 = findViewById(R.id.tx11);


        figura11 = findViewById(R.id.figura11);
        tx_11 = findViewById(R.id.tx_11);
        tx12 = findViewById(R.id.tx12);


        figura12 = findViewById(R.id.figura12);
        tx_12 = findViewById(R.id.tx_12);
        tx13 = findViewById(R.id.tx13);


        figura13 = findViewById(R.id.figura13);
        tx_13 = findViewById(R.id.tx_13);
        tx14 = findViewById(R.id.tx14);


        figura14 = findViewById(R.id.figura14);
        tx_14 = findViewById(R.id.tx_14);
        tx15 = findViewById(R.id.tx15);

        figura15 = findViewById(R.id.figura15);
        tx_15 = findViewById(R.id.tx_15);
        tx16 = findViewById(R.id.tx16);


        figura16 = findViewById(R.id.figura16);
        tx_16 = findViewById(R.id.tx_16);
        tx17 = findViewById(R.id.tx17);


        area_sqlite();

        sons_game = new Sons_game(this);



        meteoro_caindo1 = findViewById(R.id.meteoro_caindo1);
        meteoro_caindo2 = findViewById(R.id.meteoro_caindo2);
        meteoro_caindo3 = findViewById(R.id.meteoro_caindo3);
        meteoro_caindo4 = findViewById(R.id.meteoro_caindo4);


        layout = findViewById(R.id.layout);
        painel = findViewById(R.id.painel);





        timer = new Timer();
        handler = new Handler();


        restart.setVisibility(View.GONE);
        velocidade_cair4 = -500;
        figura5.setY(velocidade_cair4);


        velocidade_cair5 = -500;
        figura6.setY(velocidade_cair5);


        velocidade_cair6 = -500;
        figura7.setY(velocidade_cair6);


        velocidade_cair7 = -500;
        figura8.setY(velocidade_cair7);

        figura5_y = -500;
        figura6_y = -500;
        figura7_y = -500;
        figura8_y = -500;


        tx_5.setY(figura5_y);
        tx_6.setY(figura6_y);
        tx_7.setY(figura7_y);
        tx_8.setY(figura8_y);

        tx6.setY(figura5_y);
        tx7.setY(figura6_y);
        tx8.setY(figura7_y);
        tx9.setY(figura8_y);


        velocidade_cair = -500;
        velocidade_cair1 = -500;
        velocidade_cair2 = -500;
        velocidade_cair3 = -500;
        figura1_y = -500;
        figura2_y = -500;
        figura3_y = -500;
        figura4_y = -500;


        tx_1.setY(figura1_y);
        tx_2.setY(figura2_y);
        tx_3.setY(figura3_y);
        tx_4.setY(figura4_y);

        tx2.setY(figura1_y);
        tx3.setY(figura2_y);
        tx4.setY(figura3_y);
        tx5.setY(figura4_y);

        figura1.setY(velocidade_cair);
        figura2.setY(velocidade_cair1);
        figura3.setY(velocidade_cair2);
        figura4.setY(velocidade_cair3);


        painel_fim_game.setVisibility(View.GONE);
        painel_fim_game1.setVisibility(View.GONE);





        if (pontuacao == 0){
            duble_pontuacao = pontuacao;
        }

        timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {




                                vida();


                                figura1.setBackgroundResource(R.mipmap.img_branco);
                                figura2.setBackgroundResource(R.mipmap.img_branco);
                                figura3.setBackgroundResource(R.mipmap.img_branco);
                                figura4.setBackgroundResource(R.mipmap.img_branco);
                                figura5.setBackgroundResource(R.mipmap.img_branco);
                                figura6.setBackgroundResource(R.mipmap.img_branco);
                                figura7.setBackgroundResource(R.mipmap.img_branco);
                                figura8.setBackgroundResource(R.mipmap.img_branco);

                                caindo(layout,figura1, tx_1,tx2);
                                caindo1(layout,figura2, tx_2,tx3);
                                caindo2(layout,figura3, tx_3,tx4);
                                caindo3(layout,figura4, tx_4,tx5);

                                subindo(layout,figura5,tx_5,tx6);
                                subindo1(layout,figura6,tx_6,tx7);
                                subindo2(layout,figura7,tx_7,tx8);
                                subindo3(layout,figura8,tx_8,tx9);

                                esquerdo_p_direito(layout,figura9,tx_9,tx10);
                                esquerdo_p_direito1(layout,figura10,tx_10,tx11);
                                esquerdo_p_direito2(layout,figura11,tx_11,tx12);
                                esquerdo_p_direito3(layout,figura12,tx_12,tx13);


                                direito_p_esquerdo(layout,figura13,tx_13,tx14);
                                direito_p_esquerdo1(layout,figura14,tx_14,tx15);
                                direito_p_esquerdo2(layout,figura15,tx_15,tx16);
                                direito_p_esquerdo3(layout,figura16,tx_16,tx17);


                                pontuacao();
                                tx_1.setText(String.valueOf(contagem_fin_1));
                                tx2.setText(String.valueOf(valor_tx2));

                                tx_2.setText(String.valueOf(contagem_fin_2));
                                tx3.setText(String.valueOf(valor_tx3));

                                tx_3.setText(String.valueOf(contagem_fin_3));
                                tx4.setText(String.valueOf(valor_tx4));

                                tx_4.setText(String.valueOf(contagem_fin_4));
                                tx5.setText(String.valueOf(valor_tx5));


                                tx_5.setText(String.valueOf(contagem_fin_5));
                                tx6.setText(String.valueOf(valor_tx6));

                                tx_6.setText(String.valueOf(contagem_fin_6));
                                tx7.setText(String.valueOf(valor_tx7));


                                tx_7.setText(String.valueOf(contagem_fin_7));
                                tx8.setText(String.valueOf(valor_tx8));


                                tx_8.setText(String.valueOf(contagem_fin_8));
                                tx9.setText(String.valueOf(valor_tx9));

                                tx_9.setText(String.valueOf(contagem_fim_9));
                                tx10.setText(String.valueOf(valor_tx10));


                                tx_10.setText(String.valueOf(contagem_fim_10));
                                tx11.setText(String.valueOf(valor_tx11));

                                tx_11.setText(String.valueOf(contagem_fim_11));
                                tx12.setText(String.valueOf(valor_tx12));



                                tx_12.setText(String.valueOf(contagem_fim_12));
                                tx13.setText(String.valueOf(valor_tx13));


                                tx_13.setText(String.valueOf(contagem_fim_13));
                                tx14.setText(String.valueOf(valor_tx14));



                                tx_14.setText(String.valueOf(contagem_fim_14));
                                tx15.setText(String.valueOf(valor_tx15));



                                tx_15.setText(String.valueOf(contagem_fim_15));
                                tx16.setText(String.valueOf(valor_tx16));

                                tx_16.setText(String.valueOf(contagem_fim_16));
                                tx17.setText(String.valueOf(valor_tx17));



                                painel.setText(String.valueOf( pontuacao ));
                                painel_fim_game.setText(String.valueOf( " Pontuação final! "));
                                painel_fim_game1.setText(String.valueOf(duble_pontuacao));



                            }
                        });
                    }
                },0,10);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        cenario();
                        cenario1();
                        cenario2();
                        cenario3();


                    }
                });
            }
        },0,5);


                figura1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fin_1+=1;
                        sons_game.playAcertou();
                        c(valor_tx2,contagem_fin_1);


                    }
                });

                figura2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fin_2+=1;
                        sons_game.playAcertou();
                        c(valor_tx3,contagem_fin_2);


                    }
                });

                figura3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fin_3+=1;

                        c(valor_tx4,contagem_fin_3);

                    }
                });

                figura4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fin_4+=1;
                        c(valor_tx5,contagem_fin_4);

                    }
                });

                figura5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fin_5+=1;

                        c(valor_tx6,contagem_fin_5);

                    }
                });

                figura6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fin_6+=1;

                        c(valor_tx7,contagem_fin_6);


                    }
                });

                figura7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fin_7+=1;

                        c(valor_tx8,contagem_fin_7);

                    }
                });

                figura8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fin_8+=1;

                        c(valor_tx9,contagem_fin_8);

                    }
                });

                figura9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fim_9 +=1;

                        c(valor_tx10,contagem_fim_9);


                    }
                });


                figura10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fim_10 +=1;
                        c(valor_tx11,contagem_fim_10);

                    }
                });

                figura11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fim_11 +=1;

                        c(valor_tx12,contagem_fim_11);


                    }
                });

                figura12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fim_12 +=1;

                        c(valor_tx13,contagem_fim_12);


                    }
                });

                figura13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fim_13 +=1;

                        c(valor_tx14,contagem_fim_13);

                    }
                });

                figura14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fim_14 +=1;

                        c(valor_tx15,contagem_fim_14);



                    }
                });

                figura15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fim_15 +=1;

                        c(valor_tx16,contagem_fim_15);

                    }
                });

                figura16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contagem_fim_16 +=1;

                        c(valor_tx17,contagem_fim_16);

                    }
                });



            }



            public void area_sqlite(){
                Intent intent = getIntent();
                if(intent != null){
                    Bundle bundle = intent.getExtras();
                    if(bundle != null){

//                usuario.setPontouaao_game(bundle.getInt("pont"));
                        usuario.setId(bundle.getLong("id"));
                        usuario.setNome(bundle.getString("nome"));
//                usuario.setEmail(bundle.getString("email"));

                        usuario.setNome(painel_fim_game1.getText().toString());
//                ponto.setText(usuario.getPontouaao_game());


//                salvarBt.setVisibility(View.GONE);
//                editarBt.setVisibility(View.VISIBLE);
                    }
                }
            }

    public void salvarUsuario(){
//        usuario.setPontouaao_game(Integer.valueOf(ponto.getText().toString()));
        usuario.setNome(painel_fim_game1.getText().toString());

        BD bd = new BD(this);
        bd.inserir(usuario);

        Toast.makeText(this, "Usu�rio inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }

            public void pausando(){






                if (ligar_cair) {
                    ligar_cair = false;
                }

                if (!ligar_cair){
                    ligar_cair = false;
                }



                if (!ligar_cair1){
                    ligar_cair1 = false;
                }else ligar_cair1 = true;

                if (!ligar_cair2){
                    ligar_cair2 = false;
                }else ligar_cair2 = true;

                if (!ligar_cair3){
                    ligar_cair3 = false;
                }else ligar_cair3 = true;

                if (!ligar_cair5){
                    ligar_cair5 = false;
                }else ligar_cair5 = true;


                if (!ligar_cair6){
                    ligar_cair6 = false;
                }else ligar_cair6 = true;

                if (!ligar_cair7){
                    ligar_cair7 = false;
                }else ligar_cair7 = true;


                if (!ligar_cair8){
                    ligar_cair8 = false;
                }else ligar_cair8 = true;


                if (!ligar_esquerdo){
                    ligar_esquerdo = false;
                }else ligar_esquerdo = true;



                if (!ligar_esquerdo1){
                    ligar_esquerdo1 = false;
                }else ligar_esquerdo1 = true;


                if (!ligar_esquerdo2){
                    ligar_esquerdo2 = false;
                }else ligar_esquerdo2 = true;

                if (!ligar_esquerdo3){
                    ligar_esquerdo3 = false;
                }else ligar_esquerdo3 = true;



                if (!ligar_direito){
                    ligar_direito = false;
                }else ligar_direito = true;



                if (!ligar_direito1){
                    ligar_direito1 = false;
                }else ligar_direito1 = true;



                if (!ligar_direito2){
                    ligar_direito2 = false;
                }else ligar_direito2 = true;



                if (!ligar_direito3){
                    ligar_direito3 = false;
                }else ligar_direito3 = true;




            }

            public void vida(){
                if (fim_de_jogo == 1){
                    vida.setBackgroundResource(R.mipmap.vida_1);
                }

                if (fim_de_jogo == 2){
                    vida.setBackgroundResource(R.mipmap.vida_2);
                }


                if (fim_de_jogo == 3){
                    vida.setBackgroundResource(R.mipmap.vida_3);
                }


                if (fim_de_jogo == 4){
                    vida.setBackgroundResource(R.mipmap.vida_4);
                }


                if (fim_de_jogo == 5){
                    vida.setBackgroundResource(R.mipmap.vida_5);
                }



                if (fim_de_jogo == 6){
                    vida.setBackgroundResource(R.mipmap.via_6);
                }


                if (fim_de_jogo == 7){
                    vida.setBackgroundResource(R.mipmap.vida_7);
                }


                if (fim_de_jogo == 8){
                    vida.setBackgroundResource(R.mipmap.vida_8);
                }


                if (fim_de_jogo == 9){
                    vida.setBackgroundResource(R.mipmap.vida_9);
                }


                if (fim_de_jogo == 10){
                    vida.setBackgroundResource(R.mipmap.vida_10);
                }







            }



            public boolean cenario(){


                if (meteoro_ligado=true){
                    meteoro_ativado +=10;
                    meteoro_caindo1.setY(meteoro_ativado);
                }

                if (meteoro_ativado >= layout.getHeight()){
                    meteoroX = random.nextInt(3000);
                    meteoro_ativado = -1500;
                    meteoro_caindo1.setX(meteoroX);
                    meteoro_caindo1.setY(meteoro_ativado);
                }
                if (meteoroX >= layout.getHeight()){
                    meteoroX = random.nextInt(400);
                    meteoro_caindo1.setX(meteoroX);


                }

                return true;
            }
            public boolean cenario1(){


                if (meteoro_ligado=true){
                    meteoro_ativado1 +=10;
                    meteoro_caindo2.setY(meteoro_ativado1);
                }

                if (meteoro_ativado1 >= layout.getHeight()){
                    meteoroX1 = random.nextInt(3000);
                    meteoro_caindo2.setX(meteoroX1);
                    meteoro_ativado1= -900;
                    meteoro_caindo2.setY(meteoro_ativado1);
                }
                if (meteoroX1 >= layout.getHeight()){
                    meteoroX1 = random.nextInt(400);
                    meteoro_caindo2.setX(meteoroX1);


                }

                return true;
            }
            public boolean cenario2(){


                if (meteoro_ligado=true){
                    meteoro_ativado2 +=10;
                    meteoro_caindo3.setY(meteoro_ativado2);
                }

                if (meteoro_ativado2 >= layout.getHeight()){
                    meteoroX2 = random.nextInt(3000);
                    meteoro_ativado2 = -500;
                    meteoro_caindo3.setX(meteoroX2);
                    meteoro_caindo3.setY(meteoro_ativado2);
                }
                if (meteoroX2 >= layout.getHeight()){
                    meteoroX2 = random.nextInt(400);
                    meteoro_caindo3.setX(meteoroX2);


                }

                return true;
            }
            public boolean cenario3(){


                if (meteoro_ligado=true){
                    meteoro_ativado3 +=10;
                    meteoro_caindo4.setY(meteoro_ativado3);
                }

                if (meteoro_ativado3 >= layout.getHeight()){
                    meteoroX3 = random.nextInt(3000);
                    meteoro_ativado3 = -300;
                    meteoro_caindo4.setX(meteoroX3);
                    meteoro_caindo4.setY(meteoro_ativado3);
                }
                if (meteoroX3>= layout.getHeight()){
                    meteoroX3 = random.nextInt(400);
                    meteoro_caindo4.setX(meteoroX3);


                }

                return true;
            }




            public void restart(View v){
//                ligar_cair = true;
//                ligar_cair1 = false;
//                ligar_cair2 = false;
//                ligar_cair3 = false;
//
//                ligar_cair5 = true;
//                ligar_cair6 = false;
//                ligar_cair7 = false;
//                ligar_cair8 = false;
//
//
//                ligar_esquerdo = true;
//                ligar_esquerdo1 = false;
//                ligar_esquerdo2 = false;
//                ligar_esquerdo3 = false;
//
//
//                ligar_direito = true;
//                ligar_direito1 = false;
//                ligar_direito2 = false;
//                ligar_direito3 = false;
//                pontuacao = 5;
//                fim_de_jogo =10;
//                dube_fim_game =0;
//                duble_pontuacao =0;
//
//
//
//                figura1.setEnabled(true);
//                figura2.setEnabled(true);
//                figura3.setEnabled(true);
//                figura4.setEnabled(true);
//                figura5.setEnabled(true);
//                figura6.setEnabled(true);
//                figura7.setEnabled(true);
//                figura8.setEnabled(true);
//                figura9.setEnabled(true);
//                figura11.setEnabled(true);
//                figura10.setEnabled(true);
//                figura12.setEnabled(true);
//                figura13.setEnabled(true);
//                figura14.setEnabled(true);
//                figura15.setEnabled(true);
//                figura16.setEnabled(true);
//
//
//
//
//                velocidade_cair =  -layout.getWidth()-random.nextInt(800);
//                velocidade_cair1 = -layout.getWidth()-random.nextInt(800);
//                velocidade_cair2 = -layout.getWidth()-random.nextInt(800);
//                velocidade_cair3 = -layout.getWidth()-random.nextInt(800);
//
//                figura1.setY(figura1.getY()+2000);
//                figura2.setY(figura2.getY()+2000);
//                figura3.setY(figura3.getY()+2000);
//                figura4.setY(figura4.getY()+2000);
//
//
//                velocidade_cair4 = layout.getHeight()+random.nextInt(800);
//                velocidade_cair5 = layout.getHeight()+random.nextInt(800);
//                velocidade_cair6 = layout.getHeight()+random.nextInt(800);
//                velocidade_cair7 = layout.getHeight()+random.nextInt(800);
//
////                figura5.setX(figura5.getX() + 1000);
//                figura6.setX(figura6.getX() + 1000);
//                figura8.setX(figura7.getX() + 1000);
//                figura7.setX(figura8.getX() + 1000);
//
//
//
//
//                ativado_esquerdo  =layout.getWidth() + random.nextInt(800);
//                ativado_esquerdo1 =layout.getWidth() + random.nextInt(800);
//                ativado_esquerdo2 =layout.getWidth() + random.nextInt(800);
//                ativado_esquerdo3 =layout.getWidth() + random.nextInt(800);
//
//
//                figura9.setY(figura9.getY()+2000);
//                figura10.setY(figura10.getY()+2000);
//                figura11.setY(figura11.getY()+2000);
//                figura12.setY(figura12.getY()+2000);
//
//                ativado_p_direito  = -layout.getWidth() - random.nextInt(800);
//                ativado_p_direito1 = -layout.getWidth() - random.nextInt(800);
//                ativado_p_direito2 = -layout.getWidth() - random.nextInt(800);
//                ativado_p_direito3 = -layout.getWidth() - random.nextInt(800);
//
//                figura13.setX(figura13.getX()+1000);
//                figura14.setX(figura14.getX()+1000);
//                figura15.setX(figura15.getX()+1000);
//                figura16.setX(figura16.getX()+1000);
//
//                restart.setVisibility(View.GONE);
//                painel_fim_game.setVisibility(View.GONE);
//                painel_fim_game1.setVisibility(View.GONE);
//                painel.setVisibility(View.VISIBLE);
//
                salvarUsuario();

                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            public void pontuacao() {

                if (pontuacao >= 15) {
                    ligar_cair1 = true;
//            figura2.setVisibility(View.VISIBLE);
                }

                if (pontuacao >= 30){
                    ligar_cair6 = true;
                    //            figura3.setVisibility(View.VISIBLE);

                }

                if (pontuacao >= 45){
                    ligar_esquerdo1=true;

                }

                if (pontuacao >= 60){
                    ligar_direito1=true;


                }

                  if (pontuacao >= 75){
                    ligar_cair2=true;


                }

                if (pontuacao >= 90){
                    ligar_cair7=true;


                }


                if (pontuacao >= 105){
                    ligar_direito2=true;


                }



                if (pontuacao >= 120){
                    ligar_esquerdo2=true;


                }




                if (pontuacao >=135){
                    ligar_cair3=true;


                }




                if (pontuacao >= 150){
                    ligar_cair8=true;


                }


                if (pontuacao >= 165){
                    ligar_direito3=true;


                }



                if (pontuacao >= 180){
                    ligar_esquerdo3=true;


                }




                if (pontuacao <= 0){
//                    fim_de_jogo = 0;
                    pontuacao=0;
                    restart.setVisibility(View.VISIBLE);
                    painel_fim_game.setVisibility(View.VISIBLE);
                    painel_fim_game1.setVisibility(View.VISIBLE);
                    painel.setVisibility(View.GONE);

                    ligar_cair = false;
                    ligar_cair1 = false;
                    ligar_cair2 = false;
                    ligar_cair3 = false;
                    ligar_cair5 = false;
                    ligar_cair6 = false;
                    ligar_cair7 = false;
                    ligar_cair8 = false;

                    ligar_esquerdo= false;
                    ligar_esquerdo1= false;
                    ligar_esquerdo2= false;
                    ligar_esquerdo3= false;


                    ligar_direito = false;
                    ligar_direito1 = false;
                    ligar_direito2 = false;
                    ligar_direito3 = false;




                    figura1.setEnabled(false);
                    figura2.setEnabled(false);
                    figura3.setEnabled(false);
                    figura4.setEnabled(false);
                    figura5.setEnabled(false);
                    figura6.setEnabled(false);
                    figura7.setEnabled(false);
                    figura8.setEnabled(false);
                    figura9.setEnabled(false);
                    figura10.setEnabled(false);
                    figura11.setEnabled(false);
                    figura12.setEnabled(false);
                    figura13.setEnabled(false);
                    figura14.setEnabled(false);
                    figura15.setEnabled(false);
                    figura16.setEnabled(false);






                }


                if(fim_de_jogo == 0 ){
                    pontuacao=pontuacao;
                    duble_pontuacao  = pontuacao ;
//                    fim_de_jogo = 0;
                    restart.setVisibility(View.VISIBLE);
                    painel_fim_game.setVisibility(View.VISIBLE);
                    painel_fim_game1.setVisibility(View.VISIBLE);
                    painel.setVisibility(View.GONE);

                    ligar_cair = false;
                    ligar_cair1 = false;
                    ligar_cair2 = false;
                    ligar_cair3 = false;
                    ligar_cair5 = false;
                    ligar_cair6 = false;
                    ligar_cair7 = false;
                    ligar_cair8 = false;

                    ligar_esquerdo= false;
                    ligar_esquerdo1= false;
                    ligar_esquerdo2= false;
                    ligar_esquerdo3= false;


                    ligar_direito = false;
                    ligar_direito1 = false;
                    ligar_direito2 = false;
                    ligar_direito3 = false;




                    figura1.setEnabled(false);
                    figura2.setEnabled(false);
                    figura3.setEnabled(false);
                    figura4.setEnabled(false);
                    figura5.setEnabled(false);
                    figura6.setEnabled(false);
                    figura7.setEnabled(false);
                    figura8.setEnabled(false);
                    figura9.setEnabled(false);
                    figura10.setEnabled(false);
                    figura11.setEnabled(false);
                    figura12.setEnabled(false);
                    figura13.setEnabled(false);
                    figura14.setEnabled(false);
                    figura15.setEnabled(false);
                    figura16.setEnabled(false);



                }
               /* if (fim_de_jogo == 0){
                    fim_de_jogo = 0;
                    restart.setVisibility(View.VISIBLE);
                    painel_fim_game.setVisibility(View.VISIBLE);
                    painel_fim_game1.setVisibility(View.VISIBLE);
                    painel.setVisibility(View.GONE);

                    ligar_cair = false;
                    ligar_cair1 = false;
                    ligar_cair2 = false;
                    ligar_cair3 = false;
                    ligar_cair5 = false;
                    ligar_cair6 = false;
                    ligar_cair7 = false;
                    ligar_cair8 = false;

                    ligar_esquerdo= false;
                    ligar_esquerdo1= false;
                    ligar_esquerdo2= false;
                    ligar_esquerdo3= false;


                    ligar_direito = false;
                    ligar_direito1 = false;
                    ligar_direito2 = false;
                    ligar_direito3 = false;




                    figura1.setEnabled(false);
                    figura2.setEnabled(false);
                    figura3.setEnabled(false);
                    figura4.setEnabled(false);
                    figura5.setEnabled(false);
                    figura6.setEnabled(false);
                    figura7.setEnabled(false);
                    figura8.setEnabled(false);
                    figura9.setEnabled(false);
                    figura10.setEnabled(false);
                    figura11.setEnabled(false);
                    figura12.setEnabled(false);
                    figura13.setEnabled(false);
                    figura14.setEnabled(false);
                    figura15.setEnabled(false);
                    figura16.setEnabled(false);



                }*/

            }

            public void c(int val, int conta){
                if (conta <= val){
                    sons_game.playAcertou();
                }else if (conta > val){
                    sons_game.playErrou();
                }
            }

            public void esquerdo_p_direito(View layout, View figura1, View tx1, View tx2){


                tx2.setX(figura9.getX() +figura1.getWidth()/2.5f);
                tx2.setY(figura9.getY() +figura1.getHeight()/2.7f);


                tx1.setX(figura9.getX()+figura1.getWidth());
                tx1.setY(figura9.getY());

                figura1.setX(getAtivado_esquerdo());
                figura9.setBackgroundResource(R.mipmap.img_branco);


                if (contagem_fim_9 == valor_tx10){
                    figura9.setBackgroundResource(R.mipmap.img_verde);
                }


                if (ligar_esquerdo){
                    setAtivado_esquerdo(ativado_esquerdo+=1);
                    figura1.setX(getAtivado_esquerdo());

                }

                if (getAtivado_esquerdo()> layout.getWidth()+300){

                    figura9_y = random.nextInt(3000);
                    figura9.setY(figura9_y);
                    setAtivado_esquerdo(-500);
                }

                if (getAtivado_esquerdo() == -200){
                    valor_tx10 = random.nextInt(12);
                    contagem_fim_9 =0;
                }
                if (figura9_y > layout.getHeight()){
                    figura9_y = random.nextInt(400);
                    figura9.setY(figura9_y);
                }

                if (getAtivado_esquerdo() == layout.getWidth()&& valor_tx10 == contagem_fim_9){
                    pontuacao = pontuacao +2;

                }else if (getAtivado_esquerdo() == layout.getWidth() && valor_tx10 != contagem_fim_9){
                    pontuacao = pontuacao -2;
                    fim_de_jogo -=1;
                }

            }


            public void esquerdo_p_direito1(View layout, View figura1, View tx1, View tx2){

                tx2.setX(figura10.getX() +figura1.getWidth()/2.5f);
                tx2.setY(figura10.getY() +figura1.getHeight()/2.7f);


                tx1.setX(figura10.getX()+figura1.getWidth());
                tx1.setY(figura10.getY());

                figura1.setX(getAtivado_esquerdo1());
                figura10.setBackgroundResource(R.mipmap.img_branco);


                if (contagem_fim_10 == valor_tx11){
                    figura10.setBackgroundResource(R.mipmap.img_vermelha);
                }


                if (ligar_esquerdo1){
                    setAtivado_esquerdo1(ativado_esquerdo1+=1);
                    figura1.setX(getAtivado_esquerdo1());

                }

                if (getAtivado_esquerdo1()>= layout.getWidth()+300){
                    ativado_esquerdo1=  -500;
                    figura10_y = random.nextInt(3000);
                    figura10.setY(figura10_y);
                    setAtivado_esquerdo1(ativado_esquerdo1);
                }

                if (getAtivado_esquerdo1() == -200){
                    valor_tx11 = random.nextInt(12);
                    contagem_fim_10 =0;
                }
                if (figura10_y > layout.getHeight()){
                    figura10_y = random.nextInt(400);
                    figura10.setY(figura10_y);
                }


                if (getAtivado_esquerdo1() == layout.getWidth()&& valor_tx11 == contagem_fim_10){
                    pontuacao = pontuacao +2;

                }else if (getAtivado_esquerdo1() == layout.getWidth() && valor_tx11 != contagem_fim_10){

                    pontuacao = pontuacao -2;
                    fim_de_jogo -=1;

                }
            }

            public void esquerdo_p_direito2(View layout, View figura1, View tx1, View tx2){

                tx2.setX(figura11.getX() +figura1.getWidth()/2.5f);
                tx2.setY(figura11.getY() +figura1.getHeight()/2.7f);


                tx1.setX(figura11.getX()+figura1.getWidth());
                tx1.setY(figura11.getY());

                figura1.setX(getAtivado_esquerdo2());
                figura11.setBackgroundResource(R.mipmap.img_branco);


                if (contagem_fim_11 == valor_tx12){
                    figura11.setBackgroundResource(R.mipmap.img_verde);
                }


                if (ligar_esquerdo2){
                    setAtivado_esquerdo2(ativado_esquerdo2+=1);
                    figura1.setX(getAtivado_esquerdo2());

                }

                if (getAtivado_esquerdo2()>= layout.getWidth()+300){
                    ativado_esquerdo2=  -500;
                    figura11_y = random.nextInt(3000);
                    figura11.setY(figura11_y);
                    setAtivado_esquerdo2(ativado_esquerdo2);
                }

                if (getAtivado_esquerdo2() == -200){
                    valor_tx12 = random.nextInt(12);
                    contagem_fim_11 =0;
                }
                if (figura11_y > layout.getHeight()){
                    figura11_y = random.nextInt(400);
                    figura11.setY(figura11_y);
                }


                if (getAtivado_esquerdo2() == layout.getWidth()&& valor_tx12 == contagem_fim_11){
                    pontuacao = pontuacao +2;

                }else if (getAtivado_esquerdo2() == layout.getWidth() && valor_tx12 != contagem_fim_11){
                    pontuacao = pontuacao -2;
                    fim_de_jogo -=1;

                }

            }

            public void esquerdo_p_direito3(View layout, View figura1, View tx1, View tx2){

                tx2.setX(figura12.getX() +figura1.getWidth()/2.5f);
                tx2.setY(figura12.getY() +figura1.getHeight()/2.7f);


                tx1.setX(figura12.getX()+figura1.getWidth());
                tx1.setY(figura12.getY());

                figura1.setX(getAtivado_esquerdo2());
                figura12.setBackgroundResource(R.mipmap.img_branco);


                if (contagem_fim_12 == valor_tx13){
                    figura12.setBackgroundResource(R.mipmap.img_vermelha);
                }


                if (ligar_esquerdo3){
                    setAtivado_esquerdo3(ativado_esquerdo3+=1);
                    figura1.setX(getAtivado_esquerdo3());

                }

                if (getAtivado_esquerdo3()>= layout.getWidth()+300){
                    ativado_esquerdo3=  -500;
                    figura12_y = random.nextInt(3000);
                    figura12.setY(figura12_y);
                    setAtivado_esquerdo3(ativado_esquerdo3);
                }

                if (getAtivado_esquerdo3() == -200){
                    valor_tx13 = random.nextInt(12);
                    contagem_fim_12 =0;
                }
                if (figura12_y > layout.getHeight()){
                    figura12_y = random.nextInt(400);
                    figura12.setY(figura12_y);
                }


                if (getAtivado_esquerdo3() == layout.getWidth()&& valor_tx13 == contagem_fim_12){
                    pontuacao = pontuacao +2;

                }else if (getAtivado_esquerdo3() == layout.getWidth() && valor_tx13 != contagem_fim_12){
                    pontuacao = pontuacao -2;
                    fim_de_jogo -=1;

                }
            }



            public void direito_p_esquerdo(View layout, View figura1, View tx1, View tx2){

                tx2.setX(figura13.getX() +figura1.getWidth()/2.5f);
                tx2.setY(figura13.getY() +figura1.getHeight()/2.7f);


                tx1.setX(figura13.getX()+figura1.getWidth());
                tx1.setY(figura13.getY());

                figura1.setX(ativado_p_direito);
                figura13.setBackgroundResource(R.mipmap.img_branco);


                if (contagem_fim_13 == valor_tx14){
                    figura13.setBackgroundResource(R.mipmap.img_azul);
                }


                if (ligar_direito){
                    ativado_p_direito-=1;
                    figura1.setX(ativado_p_direito );

                }

                if (ativado_p_direito <= -500){
                    ativado_p_direito=  layout.getWidth()+ 201;
                    figura13_y = random.nextInt(3000);
                    figura13.setY(figura13_y);
                }

                if (ativado_p_direito == layout.getWidth() + 150){
                    valor_tx14 = random.nextInt(12);
                    contagem_fim_13 =0;
                }
                if (figura13_y > layout.getHeight()){
                    figura13_y = random.nextInt(400);
                    figura13.setY(figura13_y);


                }


                if (ativado_p_direito == -300 && valor_tx14 == contagem_fim_13){
                    pontuacao = pontuacao +2;

                }else if (ativado_p_direito  == -300  && valor_tx14 != contagem_fim_13){
                    pontuacao = pontuacao -2;
                    fim_de_jogo -=1;


                }



            }

            public void direito_p_esquerdo1(View layout, View figura1, View tx1, View tx2){

                tx2.setX(figura14.getX() +figura1.getWidth()/2.5f);
                tx2.setY(figura14.getY() +figura1.getHeight()/2.7f);


                tx1.setX(figura14.getX()+figura1.getWidth());
                tx1.setY(figura14.getY());

                figura1.setX(ativado_p_direito1);
                figura14.setBackgroundResource(R.mipmap.img_branco);


                if (contagem_fim_14 == valor_tx15){
                    figura14.setBackgroundResource(R.mipmap.img_vermelha);
                }


                if (ligar_direito1){
                    ativado_p_direito1-=1;
                    figura1.setX(ativado_p_direito1 );

                }

                if (ativado_p_direito1 <= -500){
                    ativado_p_direito1=  layout.getWidth()+ 201;
                    figura14_y = random.nextInt(3000);
                    figura14.setY(figura14_y);
                }

                if (ativado_p_direito1 == layout.getWidth() + 150){
                    valor_tx15 = random.nextInt(12);
                    contagem_fim_14 =0;
                }
                if (figura14_y > layout.getHeight()){
                    figura14_y = random.nextInt(400);
                    figura14.setY(figura14_y);
                }


                if (ativado_p_direito1 == -300 && valor_tx15 == contagem_fim_14){
                    pontuacao = pontuacao +2;

                }else if (ativado_p_direito1  == -300  && valor_tx15 != contagem_fim_14){
                    pontuacao = pontuacao -2;
                    fim_de_jogo -=1;

                }

            }

            public void direito_p_esquerdo2(View layout, View figura1, View tx1, View tx2){

                tx2.setX(figura15.getX() +figura1.getWidth()/2.5f);
                tx2.setY(figura15.getY() +figura1.getHeight()/2.7f);


                tx1.setX(figura15.getX()+figura1.getWidth());
                tx1.setY(figura15.getY());

                figura1.setX(ativado_p_direito2);
                figura15.setBackgroundResource(R.mipmap.img_branco);


                if (contagem_fim_15 == valor_tx16){
                    figura15.setBackgroundResource(R.mipmap.img_verde);
                }


                if (ligar_direito2){
                    ativado_p_direito2-=1;
                    figura1.setX(ativado_p_direito2 );

                }

                if (ativado_p_direito2 <= -500){
                    ativado_p_direito2=  layout.getWidth()+ 201;
                    figura15_y = random.nextInt(3000);
                    figura15.setY(figura15_y);
                }

                if (ativado_p_direito2 == layout.getWidth() + 150){
                    valor_tx16 = random.nextInt(12);
                    contagem_fim_15 =0;
                }
                if (figura15_y > layout.getHeight()){
                    figura15_y = random.nextInt(400);
                    figura15.setY(figura15_y);
                }


                if (ativado_p_direito2 == -300 && valor_tx16 == contagem_fim_15){
                    pontuacao = pontuacao +2;

                }else if (ativado_p_direito2  == -300  && valor_tx16 != contagem_fim_15){
                    pontuacao = pontuacao -2;
                    fim_de_jogo -=1;

                }



            }

            public void direito_p_esquerdo3(View layout, View figura1, View tx1, View tx2){

                tx2.setX(figura16.getX() +figura1.getWidth()/2.5f);
                tx2.setY(figura16.getY() +figura1.getHeight()/2.7f);


                tx1.setX(figura16.getX()+figura1.getWidth());
                tx1.setY(figura16.getY());

                figura1.setX(ativado_p_direito3);
                figura16.setBackgroundResource(R.mipmap.img_branco);


                if (contagem_fim_16 == valor_tx17){
                    figura16.setBackgroundResource(R.mipmap.img_azul);
                }


                if (ligar_direito3){
                    ativado_p_direito3-=1;
                    figura1.setX(ativado_p_direito3 );

                }

                if (ativado_p_direito3 <= -500){
                    ativado_p_direito3=  layout.getWidth()+ 201;
                    figura16_y = random.nextInt(3000);
                    figura16.setY(figura16_y);
                }

                if (ativado_p_direito3 == layout.getWidth() + 150){
                    valor_tx17 = random.nextInt(12);
                    contagem_fim_16 =0;
                }
                if (figura16_y > layout.getHeight()){
                    figura16_y = random.nextInt(400);
                    figura16.setY(figura16_y);
                }


                if (ativado_p_direito3 == -300 && valor_tx17 == contagem_fim_16){
                    pontuacao = pontuacao +2;

                }else if (ativado_p_direito3  == -300  && valor_tx17 != contagem_fim_16){
                    pontuacao = pontuacao -2;
                    fim_de_jogo -=1;

                }


            }



            public void subindo(View layout,View figura1, View tx1, View tx2) {





                if (velocidade_cair4 == layout.getHeight() + 200){
                    contagem_fin_5 =0;
                    valor_tx6 = random.nextInt(25);


                }

                tx2.setX(figura5_x +figura1.getWidth()/2.5f);
                tx2.setY(figura5_y +figura1.getHeight()/2.7f);


                tx1.setX(figura5_x +figura1.getWidth());
                tx1.setY(figura5_y );

                if (ligar_cair5) {
                    velocidade_cair4 -= level_cair;
                    figura5_y = velocidade_cair4;
                    figura1.setY(figura5_y);
                }

                while (velocidade_cair4 <= -10 -layout.getHeight()/2){
                    velocidade_cair4 = layout.getHeight() + 300;

                    figura5_x = random.nextInt(1000);
                    figura1.setX(figura5_x);
                    tx1.setX(figura5_x +figura1.getWidth());
                    tx2.setX(figura5_x +figura1.getWidth());

                    break;
                }

                if(valor_tx6 == contagem_fin_5){
                    figura1.setBackgroundResource(R.mipmap.img_azul);
                }


                while (velocidade_cair4 == -9 -layout.getHeight()/2  && valor_tx6 == contagem_fin_5){
                    pontuacao = pontuacao +2;
                    break;
                }
                while (velocidade_cair4 == -9 -layout.getHeight()/2 && valor_tx6 != contagem_fin_5){
                    pontuacao = pontuacao-2;
                    fim_de_jogo -=1;

                    break;

                }




                if (figura5_x > layout.getWidth()){
                    figura5_x = random.nextInt(400);
                    figura1.setX(figura5_x);

                }




            }

            public void subindo1(View layout,View figura1, View tx1, View tx2) {


                if (velocidade_cair5 == layout.getHeight() + 200){
                    contagem_fin_6 =0;
                    valor_tx7 = random.nextInt(25);


                }

                tx2.setX(figura6_x +figura1.getWidth()/2.5f);
                tx2.setY(figura6_y +figura1.getHeight()/2.7f);


                tx1.setX(figura6_x +figura1.getWidth());
                tx1.setY(figura6_y );

                if (ligar_cair6) {
                    velocidade_cair5 -= level_cair;
                    figura6_y = velocidade_cair5;
                    figura1.setY(figura6_y);
                }

                while (velocidade_cair5 <= -10 -layout.getHeight()/2){
                    velocidade_cair5 = layout.getHeight() +500;

                    figura6_x = random.nextInt(1000);
                    figura1.setX(figura6_x);
                    tx1.setX(figura6_x +figura1.getWidth());
                    tx2.setX(figura6_x +figura1.getWidth());

                    break;
                }

                if(valor_tx7 == contagem_fin_6){
                    figura1.setBackgroundResource(R.mipmap.img_azul);
                }


                while (velocidade_cair5 == -9 -layout.getHeight()/2  && valor_tx7 == contagem_fin_6){
                    pontuacao = pontuacao +2;
                    break;
                }
                while (velocidade_cair5 == -9 -layout.getHeight()/2 && valor_tx7 != contagem_fin_6){
                    pontuacao = pontuacao-2;
                    fim_de_jogo -=1;


                    break;

                }



                if (figura6_x > layout.getWidth()){
                    figura6_x = random.nextInt(400);
                    figura1.setX(figura6_x);

                }




            }

            public void subindo2(View layout,View figura1, View tx1, View tx2) {


                if (velocidade_cair6 == layout.getHeight() + 200){
                    contagem_fin_7 =0;
                    valor_tx8 = random.nextInt(25);


                }

                tx2.setX(figura7_x +figura1.getWidth()/2.5f);
                tx2.setY(figura7_y +figura1.getHeight()/2.7f);


                tx1.setX(figura7_x +figura1.getWidth());
                tx1.setY(figura7_y );

                if (ligar_cair7) {
                    velocidade_cair6 -= level_cair;
                    figura7_y = velocidade_cair6;
                    figura1.setY(figura7_y);
                }

                while (velocidade_cair6 <= -10 -layout.getHeight()/2){
                    velocidade_cair6 = layout.getHeight() +700;

                    figura7_x = random.nextInt(1000);
                    figura1.setX(figura7_x);
                    tx1.setX(figura7_x +figura1.getWidth());
                    tx2.setX(figura7_x +figura1.getWidth());

                    break;
                }

                if(valor_tx8 == contagem_fin_7){
                    figura1.setBackgroundResource(R.mipmap.img_azul);
                }


                while (velocidade_cair6 == -9 -layout.getHeight()/2  && valor_tx8 == contagem_fin_7){
                    pontuacao = pontuacao +2;
                    break;
                }
                while (velocidade_cair6 == -9 -layout.getHeight()/2 && valor_tx8 != contagem_fin_7){
                    pontuacao = pontuacao-2;
                    fim_de_jogo -=1;

                    break;

                }





                if (figura7_x > layout.getWidth()){
                    figura7_x = random.nextInt(400);
                    figura1.setX(figura7_x);

                }




            }

            public void subindo3(View layout,View figura1, View tx1, View tx2) {


                if (velocidade_cair7 == layout.getHeight() + 200){
                    contagem_fin_8 =0;
                    valor_tx9 = random.nextInt(25);


                }

                tx2.setX(figura8_x +figura1.getWidth()/2.5f);
                tx2.setY(figura8_y +figura1.getHeight()/2.7f);


                tx1.setX(figura8_x +figura1.getWidth());
                tx1.setY(figura8_y );

                if (ligar_cair8) {
                    velocidade_cair7 -= level_cair;
                    figura8_y = velocidade_cair7;
                    figura1.setY(figura8_y);
                }

                while (velocidade_cair7 <= -10 -layout.getHeight()/2){
                    velocidade_cair7 = layout.getHeight() +900;

                    figura8_x = random.nextInt(1000);
                    figura1.setX(figura8_x);
                    tx1.setX(figura8_x +figura1.getWidth());
                    tx2.setX(figura8_x +figura1.getWidth());

                    break;
                }

                if(valor_tx9 == contagem_fin_8){
                    figura1.setBackgroundResource(R.mipmap.img_azul);
                }


                while (velocidade_cair7 == -9 -layout.getHeight()/2  && valor_tx9 == contagem_fin_8){
                    pontuacao = pontuacao +2;
                    break;
                }
                while (velocidade_cair7 == -9 -layout.getHeight()/2 && valor_tx9 != contagem_fin_8){
                    pontuacao = pontuacao-2;
                    fim_de_jogo -=1;

                    break;

                }





                if (figura8_x > layout.getWidth()){
                    figura8_x = random.nextInt(400);
                    figura1.setX(figura8_x);

                }




            }




            public void caindo(View layout,View figura1, View tx1, View tx2){


                if (velocidade_cair == -450){
                    valor_tx2 = random.nextInt(25);
                    contagem_fin_1 =0;

                }

                tx2.setX(figura1_x +figura1.getWidth()/2.5f);
                tx2.setY(figura1_y +figura1.getHeight()/2.7f);


                tx1.setX(figura1_x +figura1.getWidth());
                tx1.setY(figura1_y );

                if (ligar_cair) {
                    velocidade_cair += level_cair;
                    figura1_y = velocidade_cair;
                    figura1.setY(figura1_y);
                }

                while (velocidade_cair >= layout.getHeight()+layout.getHeight()/2){
                    velocidade_cair = -500;
                    figura1_x = random.nextInt(1000);
                    figura1.setX(figura1_x);
                    tx1.setX(figura1_x +figura1.getWidth());
                    tx2.setX(figura1_x +figura1.getWidth());

                    break;
                }

                if(valor_tx2 == contagem_fin_1){
                    figura1.setBackgroundResource(R.mipmap.img_verde);
                }


                while (velocidade_cair == layout.getHeight()  + layout.getHeight()/ 3  && valor_tx2 == contagem_fin_1){
                    pontuacao = pontuacao +2;
                    break;
                }
                while (velocidade_cair == layout.getHeight() + layout.getHeight()/3 && valor_tx2 != contagem_fin_1){
                    pontuacao = pontuacao-2;
                    fim_de_jogo -=1;

                    break;
                }





                if (figura1_x > layout.getWidth()){
                    figura1_x = random.nextInt(400);
                    figura1.setX(figura1_x);

                }




            }


            public void caindo1(View layout,View figura1, View tx1, View tx2){



                if (velocidade_cair1 == -450){
                    valor_tx3 = random.nextInt(25);
                    contagem_fin_2 =0;

                }

                tx2.setX(figura2_x +figura1.getWidth()/2.5f);
                tx2.setY(figura2_y +figura1.getHeight()/2.7f);


                tx1.setX(figura2_x +figura1.getWidth());
                tx1.setY(figura2_y );

                if (ligar_cair1) {
                    velocidade_cair1 += level_cair;
                    figura2_y = velocidade_cair1 ;
                    figura1.setY(figura2_y);
                }

                while (velocidade_cair1 >= layout.getHeight()+layout.getHeight()/2){
                    velocidade_cair1 = -500;
                    figura2_x = random.nextInt(1000);
                    figura1.setX(figura2_x);
                    tx1.setX(figura2_x +figura1.getWidth());
                    tx2.setX(figura2_x +figura1.getWidth());

                    break;
                }

                if(valor_tx3 == contagem_fin_2){
                    figura1.setBackgroundResource(R.mipmap.img_verde);
                }


                while (velocidade_cair1  == layout.getHeight() + layout.getHeight()/3  && valor_tx3 == contagem_fin_2){
                    pontuacao = pontuacao +2;
                    break;
                }
                while (velocidade_cair1  == layout.getHeight() + layout.getHeight()/3 && valor_tx3 != contagem_fin_2){
                    pontuacao = pontuacao-2;
                    fim_de_jogo -=1;

                    break;
                }





                if (figura2_x > layout.getWidth()){
                    figura2_x = random.nextInt(400);
                    figura2.setX(figura2_x);

                }




            }


            public void caindo2(View layout,View figura1, View tx1, View tx2){



                if (velocidade_cair2 == -450){
                    valor_tx4 = random.nextInt(25);
                    contagem_fin_3 =0;

                }

                tx2.setX(figura3_x +figura1.getWidth()/2.5f);
                tx2.setY(figura3_y +figura1.getHeight()/2.7f);


                tx1.setX(figura3_x +figura1.getWidth());
                tx1.setY(figura3_y );

                if (ligar_cair2) {
                    velocidade_cair2 += level_cair;
                    figura3_y = velocidade_cair2 ;
                    figura1.setY(figura3_y);
                }

                while (velocidade_cair2 >= layout.getHeight()+layout.getHeight()/2){
                    velocidade_cair2 = -500;
                    figura3_x = random.nextInt(1000);
                    figura1.setX(figura3_x);
                    tx1.setX(figura3_x +figura1.getWidth());
                    tx2.setX(figura3_x +figura1.getWidth());

                    break;
                }

                if(valor_tx4 == contagem_fin_3){
                    figura1.setBackgroundResource(R.mipmap.img_verde);
                }


                while (velocidade_cair2  == layout.getHeight() + layout.getHeight()/3  && valor_tx4 == contagem_fin_3){
                    pontuacao = pontuacao +2;
                    break;
                }
                while (velocidade_cair2  == layout.getHeight() + layout.getHeight()/3 && valor_tx4 != contagem_fin_3){
                    pontuacao = pontuacao-2;
                    fim_de_jogo -=1;

                    break;
                }




                if (figura3_x > layout.getWidth()){
                    figura3_x = random.nextInt(400);
                    figura3.setX(figura3_x);

                }




            }


            public void caindo3(View layout,View figura1, View tx1, View tx2){



                if (velocidade_cair3 == -450){
                    valor_tx5 = random.nextInt(25);
                    contagem_fin_4 =0;

                }

                tx2.setX(figura4_x +figura1.getWidth()/2.5f);
                tx2.setY(figura4_y +figura1.getHeight()/2.7f);


                tx1.setX(figura4_x +figura1.getWidth());
                tx1.setY(figura4_y );

                if (ligar_cair3) {
                    velocidade_cair3 += level_cair;
                    figura4_y = velocidade_cair3 ;
                    figura1.setY(figura4_y);
                }

                while (velocidade_cair3 >= layout.getHeight()+layout.getHeight()/2){
                    velocidade_cair3 = -500;
                    figura4_x = random.nextInt(1000);
                    figura1.setX(figura4_x);
                    tx1.setX(figura4_x +figura1.getWidth());
                    tx2.setX(figura4_x +figura1.getWidth());

                    break;
                }

                if(valor_tx5 == contagem_fin_4){
                    figura1.setBackgroundResource(R.mipmap.img_azul);
                }


                while (velocidade_cair3  == layout.getHeight() + layout.getHeight()/3  && valor_tx5 == contagem_fin_4){
                    pontuacao = pontuacao +2;
                    break;
                }
                while (velocidade_cair3  == layout.getHeight() + layout.getHeight()/3 && valor_tx5 != contagem_fin_4){
                    pontuacao = pontuacao-2;
                    fim_de_jogo -=1;

                    break;
                }




                if (figura4_x > layout.getWidth()){
                    figura4_x = random.nextInt(400);
                    figura4.setX(figura4_x);

                }




            }




            public float getAtivado_esquerdo3() {
                return ativado_esquerdo3;
            }

            public void setAtivado_esquerdo3(float ativado_esquerdo3) {
                this.ativado_esquerdo3 = ativado_esquerdo3;
            }

            public float getAtivado_esquerdo2() {
                return ativado_esquerdo2;
            }

            public void setAtivado_esquerdo2(float ativado_esquerdo2) {
                this.ativado_esquerdo2 = ativado_esquerdo2;
            }

            public float getAtivado_esquerdo1() {
                return ativado_esquerdo1;
            }

            public void setAtivado_esquerdo1(float ativado_esquerdo1) {
                this.ativado_esquerdo1 = ativado_esquerdo1;
            }

            public float getAtivado_esquerdo() {
                return ativado_esquerdo;
            }

            public void setAtivado_esquerdo(float ativado_esquerdo) {
                this.ativado_esquerdo = ativado_esquerdo;
            }

    }



