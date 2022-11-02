package com.example.spainball;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.bumptech.glide.Glide;
import com.example.spainball.databinding.FragmentPersonajesVistaBinding;
import com.example.spainball.databinding.LvPersonajesBinding;

import java.util.List;


public class PersonajesAdapter extends ArrayAdapter<Personajes> {
    public PersonajesAdapter(Context context, int resource, List<Personajes> objects) {
        super(context, resource, objects);

    }

    private FragmentPersonajesVistaBinding binding;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Personajes personaje = getItem(position);
        LvPersonajesBinding binding = null;

        if (convertView == null) {
            binding = LvPersonajesBinding.inflate(LayoutInflater.from(getContext()), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);

        } else {
            binding = (LvPersonajesBinding ) convertView.getTag();

        }
        binding.txtNombre.setText(personaje.getNombre());

        Glide.with(getContext()).load(
                personaje.getImagen()
        ).into(binding.imgPer);


        return binding.getRoot();
    }

}