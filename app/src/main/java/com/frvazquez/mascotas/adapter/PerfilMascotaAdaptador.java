package com.frvazquez.mascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frvazquez.mascotas.R;
import com.frvazquez.mascotas.model.Mascota;

import java.util.ArrayList;

public class PerfilMascotaAdaptador extends  RecyclerView.Adapter<PerfilMascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public PerfilMascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cardview_perfil, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.tvRaiting.setText(String.valueOf(mascota.getRating()));
        holder.ivMascota.setImageResource(mascota.getFoto());
        holder.ivHuesoAmarillo.setImageResource(R.drawable.ic_bone_yellow_9);
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivMascota;
        private ImageView ivHuesoAmarillo;
        private TextView tvRaiting;

        public MascotaViewHolder(View view){
            super(view);

            ivMascota = view.findViewById(R.id.ivMascota);
            ivHuesoAmarillo = view.findViewById(R.id.tvHuesoAmarillo);

            tvRaiting =  view.findViewById(R.id.tvRaiting);
        }
    }
}
