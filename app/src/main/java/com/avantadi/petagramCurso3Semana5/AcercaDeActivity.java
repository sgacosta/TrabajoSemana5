package com.avantadi.petagramCurso3Semana5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //Action Bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarAcercaDe);
        setSupportActionBar(miActionBar);

        //activandpo la navegación hacia atrás
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    //menu opciones ---------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_simplificado,menu);
        //return true;
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mybutton:
                // intent SegundaActividad
                Intent intento3 = new Intent(this, com.avantadi.petagramCurso3Semana5.SegundaActividad.class);
                startActivity(intento3);

        }

        return super.onOptionsItemSelected(item);
    }
}