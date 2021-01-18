package com.vanderlei.apertaaperta1;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private List<Usuario> list;

    public UsuarioAdapter(Context context, List<Usuario> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.usuario, null);

        TextView tv = (TextView) layout.findViewById(R.id.nome_lsta);
        tv.setText(list.get(position).getNome());




//        if (position >= 3){
//            BD bd = new BD(context);
//            bd.deletar(list.get(3));
//        }
        ImageButton deletarBt = (ImageButton) layout.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                BD bd = new BD(context);
                bd.deletar(list.get(auxPosition));
                layout.setVisibility(View.GONE);


            }


        });

        return layout;
    }

}
