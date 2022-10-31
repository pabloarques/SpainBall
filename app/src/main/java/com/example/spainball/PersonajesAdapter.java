package com.example.spainball;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PersonajesAdapter extends ArrayAdapter<Personajes> {
    public PersonajesAdapter(Context context, int resource, List<Personajes> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Personajes personaje = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_personajes, parent, false);
        }

            TextView txtNombre = convertView.findViewById(R.id.txt_nombre);
            ImageView imagen = convertView.findViewById(R.id.img_per);

            txtNombre.setText(personaje.getNombre());

            Glide.with(getContext()).load(

                    personaje.getImagen()
            ).into(imagen);
        return convertView;
    }

}