package com.frvazquez.mascotas.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.frvazquez.mascotas.R;
import com.frvazquez.mascotas.adapter.MascotaAdaptador;
import com.frvazquez.mascotas.adapter.PerfilMascotaAdaptador;
import com.frvazquez.mascotas.model.Mascota;
import com.frvazquez.mascotas.view.TopMascotas;

import java.util.ArrayList;


public class PerfilMascotaFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView lista;
    private View v;

    public static PerfilMascotaFragment newInstance(String param1, String param2) {
        PerfilMascotaFragment fragment = new PerfilMascotaFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);
        cargarDatos();
        iniciarRecycleView();
        return v;
    }

    private void iniciarRecycleView() {
        lista = v.findViewById(R.id.rvPerfil);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        lista.setLayoutManager(glm);
        iniciarlizarAdaptador();
    }


    private void iniciarlizarAdaptador() {
        PerfilMascotaAdaptador adaptador = new PerfilMascotaAdaptador(mascotas, getActivity());
        lista.setAdapter(adaptador);
    }

    private void cargarDatos() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("doggi", 5, R.drawable.dog_9));
        mascotas.add(new Mascota("doggi", 2, R.drawable.dog_9));
        mascotas.add(new Mascota("doggi", 7, R.drawable.dog_9));
        mascotas.add(new Mascota("doggi", 4, R.drawable.dog_9));
        mascotas.add(new Mascota("doggi", 8, R.drawable.dog_9));
        mascotas.add(new Mascota("doggi", 10, R.drawable.dog_9));
        mascotas.add(new Mascota("doggi", 10, R.drawable.dog_9));
        mascotas.add(new Mascota("doggi", 4, R.drawable.dog_9));

    }

    public void verTop(View view) {
        Intent intent = new Intent(getActivity(), TopMascotas.class);
        startActivity(intent);
    }

}