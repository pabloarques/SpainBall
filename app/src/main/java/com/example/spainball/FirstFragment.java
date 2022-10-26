package com.example.spainball;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.spainball.databinding.FragmentFirstBinding;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Personajes> items;
    private PersonajesAdapter adapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       binding.btnDetalle.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_FirstFragment_to_SecondFragment));
    }

    class PersonajesAdapter extends ArrayAdapter<Personajes> {
        public PersonajesAdapter(Context context, int resource, List<Personajes> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            Personajes personaje = getItem(position);

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.fragment_second, parent, false);
            }

            //union del codigo en las views del layout
        /*
            TextView txtPoke = convertView.findViewById(R.id.txtPoke);
            ImageView img_poke = convertView.findViewById(R.id.img_poke);

            txtPoke.setText(pokemon.getNombre());

            Glide.with(getContext()).load(
                    pokemon.getImage()
            ).into(img_poke);
        */
            return convertView;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}