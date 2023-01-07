package com.frvazquez.mascotas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.frvazquez.mascotas.MainActivity;
import com.frvazquez.mascotas.R;
import com.frvazquez.mascotas.adapter.MascotaAdaptador;
import com.frvazquez.mascotas.model.Mascota;

import java.util.ArrayList;

public class TopMascotas extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_mascotas);
        cargarDatos();
        iniciarRecycleView();
    }

    public void regresar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void iniciarRecycleView() {
        lista = findViewById(R.id.myRv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lista.setLayoutManager(llm);
        iniciarlizarAdaptador();
    }


    private void iniciarlizarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        lista.setAdapter(adaptador);
    }

    private void cargarDatos() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("ron", 21, R.drawable.ron_9));
        mascotas.add(new Mascota("ramiro", 17, R.drawable.ramil_9));
        mascotas.add(new Mascota("Cheto", 12, R.drawable.cheto_9));
        mascotas.add(new Mascota("Catty", 10, R.drawable.cat_9));
        mascotas.add(new Mascota("pati", 10, R.drawable.rina_9));
    }



}