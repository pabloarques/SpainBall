package com.example.spainball;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.spainball.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private PersonajesAdapter adapter;
    private ArrayList<Personajes> items;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        items = new ArrayList<>();
        adapter = new PersonajesAdapter(
                getContext(),
                R.id.txt_nombre,
                items
        );

        binding.lvPersonajes.setAdapter(adapter);
        refresh();

        binding.lvPersonajes.setOnItemClickListener((adapter, fragment, i, l) -> {
            Personajes per = (Personajes) adapter.getItemAtPosition(i);
            Bundle args = new Bundle();

            args.putSerializable("items", items);

            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_personajesVista, args);

        });

    }


    private void refresh () {
        Toast.makeText(getContext(), "Refrescando...", Toast.LENGTH_LONG).show();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());


        executor.execute(() -> {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

            PersonajesApi api = new PersonajesApi();
            ArrayList<Personajes> personajes = api.getPersonaje();
            handler.post(() -> {
                adapter.clear();
                adapter.addAll(personajes);
            });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}