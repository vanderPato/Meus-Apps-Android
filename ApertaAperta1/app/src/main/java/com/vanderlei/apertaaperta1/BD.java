package com.vanderlei.apertaaperta1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BD {
    private SQLiteDatabase bd;

    public BD(Context context){
        BDCore auxBd = new BDCore(context);
        bd = auxBd.getWritableDatabase();
    }


    public void inserir(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        bd.insert("usuario", null, valores);


    }



    public void deletar(Usuario usuario){
        bd.delete("usuario", "_id = "+usuario.getId(), null);
    }


    public List<Usuario> buscar(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id", "nome"};

        Cursor cursor = bd.query("usuario", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Usuario u = new Usuario();
                u.setId(cursor.getLong(0));
                u.setNome(cursor.getString(1));
//                u.setEmail(cursor.getString(2));
//                u.setPontouaao_game(cursor.getInt(3));
                list.add(u);

            }while(cursor.moveToNext());
        }

        return(list);
    }
}
