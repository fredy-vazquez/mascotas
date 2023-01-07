package com.frvazquez.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.frvazquez.mascotas.adapter.MascotaAdaptador;
import com.frvazquez.mascotas.model.Mascota;
import com.frvazquez.mascotas.view.TopMascotas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();
        iniciarRecycleView();

    }

    public void verTop(View view) {
        Intent intent = new Intent(MainActivity.this, TopMascotas.class);
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

        mascotas.add(new Mascota("Cheto", 12, R.drawable.cheto_9));
        mascotas.add(new Mascota("Catty", 10, R.drawable.cat_9));
        mascotas.add(new Mascota("pati", 10, R.drawable.rina_9));
        mascotas.add(new Mascota("ramiro", 17, R.drawable.ramil_9));
        mascotas.add(new Mascota("ron", 21, R.drawable.ron_9));
        mascotas.add(new Mascota("cebas", 5, R.drawable.dony_9));
        mascotas.add(new Mascota("jami<", 7, R.drawable.perry_9));

    }

}