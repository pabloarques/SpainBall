package com.example.spainball;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.spainball.databinding.FragmentPersonajesVistaBinding;


public class personajesVista extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentPersonajesVistaBinding binding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentPersonajesVistaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Bundle args = getArguments();

        if(args != null){
            Personajes personaje = (Personajes) args.getSerializable("item");

            if(personaje != null){
                actualizar(personaje);

            }

        }

        return view;
    }

    private void actualizar(@NonNull Personajes personaje){

        binding.txtNombre2.setText("Nombre: "+ personaje.getNombre());
        binding.txtRaza.setText("Raza: "+personaje.getRaza());
        binding.txtPoder2.setText("Nivel de Poder: "+ String.valueOf(personaje.getNivelPoder()));

        Glide.with(getContext()).load(
                personaje.getImagen()
        ).into(binding.imgPers2);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}