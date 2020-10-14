package com.avantadi.petagramCurso3Semana5.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avantadi.petagramCurso3Semana5.adapter.PerfilMascotaAdaptador;
import com.avantadi.petagramCurso3Semana5.base_datos.BaseDatosMascotas;
import com.avantadi.petagramCurso3Semana5.pojo.Mascota;
import com.avantadi.petagramCurso3Semana5.R;

import java.util.ArrayList;


public class PerfilMascotaFragment extends Fragment {

    private Context contexto;
    private RecyclerView RecyclerViewListaPerfilMacotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contexto = getActivity();

        // Inflate the layout for this fragment
        View v_rv_fragment_perfil = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        TextView tvNombreFPM = (TextView) v_rv_fragment_perfil.findViewById(R.id.tvNombreFPM);
        tvNombreFPM.setText("Mara");


        //asociación XML a RecyclerView
        RecyclerViewListaPerfilMacotas = (RecyclerView) v_rv_fragment_perfil.findViewById(R.id.rvPerfilMascotas);

        /*
        //LayoutManagwer: LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(getActivity());
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        */

        //LayoutManagwer: GridLayoutManager
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        RecyclerViewListaPerfilMacotas.setLayoutManager(glm);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaPerfilMacotas.setLayoutManager(glm);


        //Adaptador: se le pasa un ArraList con las mascotas para el perfil obtenidas de la base de datos
        BaseDatosMascotas baseDatosMascotas = new BaseDatosMascotas(contexto);
        ArrayList<Mascota> mascotas = baseDatosMascotas.obtenerTodasLasMascotasParaPerfil(R.drawable.icons8_dog_100);

        PerfilMascotaAdaptador adaptadorPerfilMascotas = new PerfilMascotaAdaptador(mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaPerfilMacotas.setAdapter(adaptadorPerfilMascotas);

        return v_rv_fragment_perfil;
    }




}