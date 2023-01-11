package com.frvazquez.mascotas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.frvazquez.mascotas.MainActivity;
import com.frvazquez.mascotas.R;
import com.frvazquez.mascotas.adapter.MascotaAdaptador;
import com.frvazquez.mascotas.model.Mascota;
import com.frvazquez.mascotas.view.TopMascotas;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView lista;
    private View v;

    public static MascotasFragment newInstance(String param1, String param2) {
        MascotasFragment fragment = new MascotasFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        cargarDatos();
        iniciarRecycleView();
        return v;
    }

    private void iniciarRecycleView() {
        lista = v.findViewById(R.id.myRv);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lista.setLayoutManager(llm);
        iniciarlizarAdaptador();
    }


    private void iniciarlizarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        lista.setAdapter(adaptador);
    }

    private void cargarDatos() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Cheto", 12, R.drawable.cheto_9));
        mascotas.add(new Mascota("Catty", 10, R.drawable.cat_9));
        mascotas.add(new Mascota("pati", 10, R.drawable.rina_9));
        mascotas.add(new Mascota("ramiro", 17, R.drawable.ramil_9));
        mascotas.add(new Mascota("ron", 21, R.drawable.ron_9));
        mascotas.add(new Mascota("cebas", 5, R.drawable.dony_9));
        mascotas.add(new Mascota("jami<", 7, R.drawable.perry_9));

    }

    public void verTop(View view) {
        Intent intent = new Intent(getActivity(), TopMascotas.class);
        startActivity(intent);
    }


}