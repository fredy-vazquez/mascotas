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

public class MascotaAdaptador extends  RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.tvNombreMascota.setText(mascota.getNombre());
        holder.tvRaiting.setText(String.valueOf(mascota.getRating()));
        holder.ivMascota.setImageResource(mascota.getFoto());
        holder.ivHuesoBlanco.setImageResource(R.drawable.ic_bone_white_9);
        holder.ivHuesoAmarillo.setImageResource(R.drawable.ic_bone_yellow_9);

        holder.ivHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setRating(mascota.getRating() + 1);
                holder.tvRaiting.setText(String.valueOf(mascota.getRating()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivMascota;
        private ImageView ivHuesoBlanco;
        private ImageView ivHuesoAmarillo;
        private TextView tvNombreMascota;
        private TextView tvRaiting;

        public MascotaViewHolder(View view){
            super(view);

            ivMascota = view.findViewById(R.id.ivMascota);
            ivHuesoBlanco = view.findViewById(R.id.ivHuesoBlanco);
            ivHuesoAmarillo = view.findViewById(R.id.tvHuesoAmarillo);
            tvNombreMascota = view.findViewById(R.id.tvNombreMascota);
            tvRaiting =  view.findViewById(R.id.tvRaiting);
        }
    }
}
