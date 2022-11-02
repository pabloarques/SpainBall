package com.example.spainball;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.spainball.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private PersonajesAdapter adapter;
    private ArrayList<Personajes> items;
    private  PersonajesViewModel model;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @SuppressLint("FragmentLiveDataObserve")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items = new ArrayList<>();
        adapter = new PersonajesAdapter(
                getContext(),
                R.id.txt_nombre,
                items
        );


        binding.lvPersonajes.setAdapter(adapter);
        binding.lvPersonajes.setOnItemClickListener((adapter, fragment, i, l) -> {
            Bundle args = new Bundle();

            Personajes item = (Personajes) adapter.getItemAtPosition(i);

            args.putSerializable("item", item);

            if (!esTablet()){
                NavHostFragment.findNavController(
                this
                ).navigate(R.id.action_SecondFragment_to_personajesVista, args);
            } else {
                NavHostFragment.findNavController(
                        this
                ).navigate(R.id.action_personajesVista4_self, args);

            }

        });

        model = new ViewModelProvider(getActivity()).get(PersonajesViewModel.class);
        model.getPersonajes().observe(getActivity(), personajes -> {
            adapter.clear();
            adapter.addAll(personajes);
        });
        model.refresh();
    }

    boolean esTablet() {
        return getResources().getBoolean(R.bool.tablet);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}