package com.avantadi.petagramCurso3Semana5.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avantadi.petagramCurso3Semana5.adapter.MascotaAdaptador;
import com.avantadi.petagramCurso3Semana5.base_datos.BaseDatosMascotas;
import com.avantadi.petagramCurso3Semana5.pojo.Mascota;
import com.avantadi.petagramCurso3Semana5.R;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment  {
    private Context contexto;

    private RecyclerView RecyclerViewListaMacotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contexto = getActivity();
        // Inflate the layout for this fragment
        View v_rv_fragment = inflater.inflate(R.layout.fragment_recycler_view, container, false);


        //asociación XML a RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) v_rv_fragment.findViewById(R.id.rvMascotas);

        //LayoutManagwer: LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(getActivity());
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagwerMascotas);



        //Adaptador: se le pasa un ArraList con las mascotas obtenidas de la base de datos
        BaseDatosMascotas baseDatosMascotas = new BaseDatosMascotas(contexto);
        ArrayList<Mascota> mascotas = baseDatosMascotas.obtenerTodasLasMascotas();

        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(contexto,mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);

        return v_rv_fragment;
    }



    public void mostrarFragmentoPerfil() {
        Fragment someFragment = new PerfilMascotaFragment();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .show(someFragment)
                .commit();

    }
}