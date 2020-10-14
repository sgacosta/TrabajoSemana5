package com.avantadi.petagramCurso3Semana5;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.avantadi.petagramCurso3Semana5.adapter.PaginaAdaptador;
import com.avantadi.petagramCurso3Semana5.fragment.PerfilMascotaFragment;
import com.avantadi.petagramCurso3Semana5.fragment.RecyclerViewFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tablayout = (TabLayout) findViewById(R.id.tablayout) ;
        viewpager = (ViewPager) findViewById(R.id.viewPager) ;

        setUpViewPager();

        if(toolbar != null){
            //se asigna a toolbar las acciones ActionBar (se aplicarán onCreateOptionsMenu y onOptionsItemSelected)
            setSupportActionBar(toolbar);

        }

    }

    //lista de fragmentos
    private ArrayList<Fragment> agregarFragmentos(){
        ArrayList<Fragment> fragmentos = new ArrayList<>();
        fragmentos.add(new RecyclerViewFragment());
        fragmentos.add(new PerfilMascotaFragment());
        return fragmentos;
    }

    //establecer ViewPager con el adaptador correspondiente
    private void setUpViewPager(){
        viewpager.setAdapter(new PaginaAdaptador(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,agregarFragmentos()));

        //tabLayout de toolbar
        tablayout.setupWithViewPager(viewpager);

        tablayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_baseline_pets_24);

    }

    //menu opciones ---------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_completo,menu);
        //return true;
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Snackbar.make(getCurrentFocus(),getResources().getString(R.string.menu_title_mAbout),Snackbar.LENGTH_SHORT).show();
                Intent intento1 = new Intent(this, com.avantadi.petagramCurso3Semana5.AcercaDeActivity.class);
                startActivity(intento1);
                break;
            case R.id.mContacto:
                Snackbar.make(getCurrentFocus(),getResources().getString(R.string.menu_title_mContacto),Snackbar.LENGTH_SHORT).show();
                Intent intento2 = new Intent(this, com.avantadi.petagramCurso3Semana5.ContactoActivity.class);
                startActivity(intento2);
                break;
            case R.id.mybutton:
                // intent SegundaActividad
                Intent intento3 = new Intent(this, com.avantadi.petagramCurso3Semana5.SegundaActividad.class);
                startActivity(intento3);

        }

        return super.onOptionsItemSelected(item);
    }





}