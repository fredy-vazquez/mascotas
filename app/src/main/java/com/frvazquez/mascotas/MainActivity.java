package com.frvazquez.mascotas;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;


import com.frvazquez.mascotas.adapter.PageAdapter;
import com.frvazquez.mascotas.fragments.MascotasFragment;
import com.frvazquez.mascotas.fragments.PerfilMascotaFragment;
import com.frvazquez.mascotas.view.AcercaDe;
import com.frvazquez.mascotas.view.Contacto;
import com.frvazquez.mascotas.view.TopMascotas;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarViews();
        setUpViewPage();

        if(toolbar == null) {
            setSupportActionBar(toolbar);
        }
    }

    private void iniciarViews() {
        toolbar = findViewById(R.id.toolbar);
        tableLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    private void setUpViewPage() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.getTabAt(0).setIcon(R.drawable.ic_house);
        tableLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    private ArrayList<Fragment> agregarFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotasFragment());
        fragments.add(new PerfilMascotaFragment());
        return fragments;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuTopFavoritos:
                 intent = new Intent(MainActivity.this, TopMascotas.class);
                 startActivity(intent);
                break;
            case R.id.menuContacto:
                intent = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.menuAcercaDe:
                intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}