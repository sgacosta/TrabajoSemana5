package com.avantadi.petagramCurso3Semana5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.avantadi.petagramCurso3Semana5.adapter.MascotaAdaptador;
import com.avantadi.petagramCurso3Semana5.base_datos.BaseDatosMascotas;
import com.avantadi.petagramCurso3Semana5.pojo.Mascota;

import java.util.ArrayList;

public class SegundaActividad extends AppCompatActivity {

    private Context contexto;
    private RecyclerView RecyclerViewListaMacotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        contexto = this;
        //Action Bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //activandpo la navegación hacia atrás
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //asociación XML a RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        //LayoutManagwer: LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(this);
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagwerMascotas);

        //Adaptador: se pasan las 5 mascotas con más rating
        BaseDatosMascotas baseDatosMascotas = new BaseDatosMascotas(contexto);
        ArrayList<Mascota> mascotas = baseDatosMascotas.obtenerLas5MascotasConMasRating();

        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(contexto,mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);

    }

    //si se pulsa retroceder se realiza un Intent a MainActivity
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(SegundaActividad.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}