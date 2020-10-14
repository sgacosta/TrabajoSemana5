package com.avantadi.petagramCurso3Semana5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.avantadi.petagramCurso3Semana5.pojo.Mascota;
import com.avantadi.petagramCurso3Semana5.R;

import java.util.ArrayList;

public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> Mascotas;


    //al llamar al Constructor se guardan los datos en el ArrayLisy
    public PerfilMascotaAdaptador(ArrayList<Mascota> Mascotas) {
        this.Mascotas = Mascotas;
    }

    //infla el layout cardview_Mascota
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //asociar el layout al reclyclerView: se infla el layout que va a reciclar el recyclerView (cardview_mascota)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota,parent,false);
        //el layout a reciclar (cardview_mascota) ya inflado, se pasa al constructor MascotaViewHolder (para que obtenga cada View) y se retorna
        return new MascotaViewHolder(v) ;
    }

    //se pasa la lista a cada elemento y se asocia cada elemento con su View
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder MascotaViewHolder, int position) {
        final Mascota mascota = Mascotas.get(position);
        //se dotan los Views del Holder
        MascotaViewHolder.imgFotoPerfilCV.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvTotalPerfilCV.setText(Integer.toString(mascota.getRating()));

      }


    //cantiadad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return Mascotas.size();
    }


    //esta clase es static
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private  ImageView imgFotoPerfilCV;
        private  TextView tvTotalPerfilCV;
        private ImageView imgTotalPerfilCV;

        //Constructor: se pasa la vista cardview_mascota
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoPerfilCV    = (ImageView) itemView.findViewById(R.id.imgFotoPerfilCV);
            tvTotalPerfilCV   = (TextView) itemView.findViewById(R.id.tvTotalPerfilCV);
            imgTotalPerfilCV  = (ImageView) itemView.findViewById(R.id.imgTotalPerfilCV);

        }
    }


}
