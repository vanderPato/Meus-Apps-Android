package com.vanderlei.faaseusdrinks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Caipirinha_Class extends AppCompatActivity {

    String [] titulo= {"Caipirinha de Limão","Caipirinha de Maracuja","Caipirinha de Kiwi",
            "Caipirinha de Frutas Vermelas","Caipirinha de Seriguela","Caipirinha de Lichia",
            "Caipirinha de Laranja","Caipirinha de Morango","Caipirinha de Manga","Caipirinha de Abacaxi",
            "Caipirinha de Uva","Caipirinha de Pessego","Caipirinha de Melancia","Caipirinha de Goiaba" };



    String [] descricao= {"caipirinha de limao faça a sua!","caipirinha de maracuja faça a sua!",
            "caipirinha de kiwi faça a sua!","caipirinha de frutas vermelas faça a sua!","caipirinha de seriguela faça a sua!",
            "caipirinha de lichia faça a sua!","caipirinha de laranja faça a sua!","caipirinha de morango faça a sua!",
            "caipirinha de manga faça a sua!","caipirinha de abacaxi faça a sua!","caipirinha de uva faça a sua!","caipirinha de pessego faça a sua!",
            "caipirinha de melancia faça a sua!","caipirinha de goiaba faça a sua!"

    };
    ListView lista_caipirinha_limao;
    int [] imagens = {R.mipmap.caipirinha_iconepersonalizado,R.mipmap.caipirinha_de_maracuja,R.mipmap.caipirinha_de_kiwi,
            R.mipmap.caipirinha_de_frutas_vermelhas,R.mipmap.caipirinha_de_seriguela,R.mipmap.caipirinha_de_lichia,
            R.mipmap.caipirinha_de_laranja_,R.mipmap.caipirinha_de_morango,R.mipmap.caipirinha_de_manga,
            R.mipmap.caipirinha_de_abacaxi,R.mipmap.caipirinha_de_uva,R.mipmap.caipirinha_de_pessego,R.mipmap.caipirinha_de_melancia,
            R.mipmap.caipirinha_de_goiaba,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caipirinha__class);

        lista_caipirinha_limao = findViewById(R.id.lista_caipirinha);


        MyAdapter adapter = new MyAdapter(this,titulo,descricao,imagens);
        lista_caipirinha_limao.setAdapter(adapter);

        lista_caipirinha_limao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Caipirinha_Class.this, ""+ position, Toast.LENGTH_SHORT).show();


                switch (position){
                    case 0:
                        if (position == 0){
                        Intent intent = new Intent(Caipirinha_Class.this, Faca_capipirinha_de_limao.class);
                        startActivity(intent);
                        }
                        case 1:
                        if (position == 1){
                            Intent intent = new Intent(Caipirinha_Class.this, Faca_capipirinha_de_maracuja.class);
                            startActivity(intent);
                        }
                        case 2:
                        if (position == 2){
                            Intent intent = new Intent(Caipirinha_Class.this, Faca_capipirinha_de_kiwi.class);
                            startActivity(intent);
                        }
                        case 3:
                        if (position == 3){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_frutas_vermelhas.class);
                            startActivity(intent);
                        }
                        case 4:
                        if (position == 4){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_seriguela.class);
                            startActivity(intent);
                        }
                        case 5:
                        if (position == 5){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_lichia.class);
                            startActivity(intent);
                        }

                        case 6:
                        if (position == 6){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_laranja.class);
                            startActivity(intent);
                        }
                        case 7:
                        if (position == 7){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_morango.class);
                            startActivity(intent);
                        }


                        case 8:
                        if (position == 8){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_d_manga.class);
                            startActivity(intent);
                        }
                        case 9:
                        if (position == 9){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_abacaxi.class);
                            startActivity(intent);
                        }

                    case 10:

                        if (position == 10){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_uva.class);
                            startActivity(intent);
                        }

                    case 11:
                        if (position == 11){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_pessego.class);
                            startActivity(intent);
                        }


                    case 12:
                        if (position == 12){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_melancia.class);
                            startActivity(intent);
                        }


                    case 13:
                        if (position == 13){
                            Intent intent = new Intent(Caipirinha_Class.this, Caipirinha_de_goiaba.class);
                            startActivity(intent);
                        }


                }


            }
        });


    }

    static class MyAdapter extends ArrayAdapter {
        int []imagearrary;
        String[] tituloArray;
        String[] descricaoArray;


        public MyAdapter(@NonNull Context context, String[] titulo1, String[] descricao1, int[] img1) {
            super(context, R.layout.minha_lista,R.id.titulo,titulo1);
            this.imagearrary = img1;
            this.tituloArray=titulo1;
            this.descricaoArray=descricao1;

        }


        @Override
        public View getView(int position, View converView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.minha_lista,parent,false);

            ImageView myImage = row.findViewById(R.id.img);
            TextView myTitulo = row.findViewById(R.id.titulo);
            TextView myDescricao = row.findViewById(R.id.descricao);



            myImage.setImageResource(imagearrary[position]);
            myTitulo.setText(tituloArray[position]);
            myDescricao.setText(descricaoArray[position]);
            return row;


        }


    }



}