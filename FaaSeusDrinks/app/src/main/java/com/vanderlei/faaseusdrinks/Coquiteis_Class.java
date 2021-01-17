package com.vanderlei.faaseusdrinks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Coquiteis_Class extends AppCompatActivity {
    ImageView img;
    URL url;
    Handler handler = new Handler();
    Bitmap bitmap = null;
    final Bitmap bitmapaux = bitmap;



    String[] titulo_coqui = {"Coquetel Veracruz","Vodka com Morango","Melancia com Vodka",
        "Sorvete com Vodka","Espresso Martini","Vesper Martini","Cosmopolitan","Coquetel de Pêssego","Moscow Mule" ,"Frozen Original","Dirty Martini"};



    String[] descricao_coqui = {"bebida típica do México","gostinho doce e frutado",
            "uma bebida divertida que deixará qualquer festa mais legal", "nada melhor para refrescar",
            "uma rebeldia ao clássico drink","drink do 007 James Bond","coquetel clássico muito apreciado pelo público feminino",
            "esse coquetel é muito usado nas festas de fim de ano","sirva esse drink numa caneca de cobre",
            "o drink frozen original é delicioso, fácil de fazer e muito refrescante!","dirty martini um novo paladar a ser descuberto"

    };

    ListView lista_coquiteis;
    int imagens_coqui[]= {R.mipmap.caipirinha_de_abacaxi,R.mipmap.vodka_morango,
            R.mipmap.caipirinha_de_melancia,R.mipmap.vodka_sorvete,R.mipmap.coquital_explesso_martine,
            R.mipmap.coquital_vesper_martini,R.mipmap.caipirinha_icone_cosmopolitan,R.mipmap.caipirinha_de_pessego,
            R.mipmap.coquital_moscow_mule,R.mipmap.coquital_frozen_original,R.mipmap.coquital_dirty_martini};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coquiteis__class);

        lista_coquiteis = findViewById(R.id.lista_coquiteis);
        MyAdapter adapter = new MyAdapter(this, titulo_coqui,descricao_coqui,imagens_coqui);
        lista_coquiteis.setAdapter(adapter);

        lista_coquiteis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        if (position == 0){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_Veracruz.class);
                            startActivity(intent);
                        }

                    case 1:
                        if (position == 1){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_Vodk_mornago.class);
                            startActivity(intent);                        }


                    case 2:
                        if (position == 2){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_Vodk_melancia.class);
                            startActivity(intent);                                                }



                    case 3:
                        if (position == 3){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_Vodk_sorvete.class);
                            startActivity(intent);


                        }



                    case 4:
                        if (position == 4){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_Espresso_martini.class);
                            startActivity(intent);


                        }

                    case 5:
                        if (position == 5){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_vesper_martine.class);
                            startActivity(intent);


                        }


                    case 6:
                        if (position == 6){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_Cosmopolitan.class);
                            startActivity(intent);


                        }


                    case 7:
                        if (position == 7){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_pessego.class);
                            startActivity(intent);


                        }



                    case 8:
                        if (position == 8){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_Moscow_mule.class);
                            startActivity(intent);


                        }

                    case 9:
                        if (position == 9){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_coquetel_Frozen_original.class);
                            startActivity(intent);


                        }


                    case 10:
                        if (position == 10){
                            Intent intent = new Intent(Coquiteis_Class.this, Coquitel_class_dirty_martini.class);
                            startActivity(intent);


                        }

                }
            }
        });
    }


    public void push_image_web(){
        new Thread() {
            public void run() {


                final View view[];


                try {
                    url = new URL("https://drive.google.com/file/d/18wccAxXcINlg3U25r5bSPxf0e1hZZrN8/view?usp=sharing");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream inputs = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputs);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        img = new ImageView(getBaseContext());
                        img.setImageBitmap(bitmapaux);
                        View[] vew = new View[]{img};


                    }
                });

            }

        }.start();
    }



    static class MyAdapter extends ArrayAdapter {
        int[] imagearrary;
        String[] tituloArray;
        String[] descricaoArray;


        public MyAdapter(@NonNull Context context, String[] titulo1, String[] descricao1, int[] img1) {
            super(context, R.layout.lista_coquitel,R.id.titulo_coqui,titulo1);
            this.imagearrary = img1;
            this.tituloArray=titulo1;
            this.descricaoArray=descricao1;

        }


        @Override
        public View getView(int position, View converView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.lista_coquitel,parent,false);

            ImageView myImage = row.findViewById(R.id.img_coqui);
            TextView myTitulo = row.findViewById(R.id.titulo_coqui);
            TextView myDescricao = row.findViewById(R.id.descricao_coqui);



            myImage.setImageResource(imagearrary[position]);
            myTitulo.setText(tituloArray[position]);
            myDescricao.setText(descricaoArray[position]);
            return row;


        }


    }


}