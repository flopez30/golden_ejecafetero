package com.golden.ejecafetero.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.golden.ejecafetero.Entidades.Poi;
import com.golden.ejecafetero.Fragments.DetallePoiFragment;
import com.golden.ejecafetero.Fragments.MainFragment;
import com.golden.ejecafetero.Fragments.PoiFragment;
import com.golden.ejecafetero.Fragments.PreferenciasFragment;
import com.golden.ejecafetero.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, iComunicaFragments{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    //variable del fragment detalle
    DetallePoiFragment detallePoiFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        //lo sgt se implementa luego de haber implementado NavigationView.OnNavigationItemSelectedListener
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        //cargar fragment principal en la actividad
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new MainFragment());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //para cerrar automaticamente el menu
        drawerLayout.closeDrawer(GravityCompat.START);
        if(menuItem.getItemId() == R.id.home){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new MainFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.lugares){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new PoiFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.preferencias){
         startActivity(new Intent(this, PreferenciasFragment.class));
        }

        return false;
    }


    @Override
    public void enviarPoi(Poi poi) {
        //gracias a hbaer implementado de la interface "iComunicaFragments" se tiene la implementacion del metodo enviarPoi
        //o mejor dicho este metodo.
        //Aqui se realiza toda la logica necesaria para poder realizar el envio
        detallePoiFragment = new DetallePoiFragment();
        //objeto bundle para transportar la informacion
        Bundle bundleEnvio = new Bundle();
        //se manda el objeto que le esta llegando:
        bundleEnvio.putSerializable("objeto", poi);
        detallePoiFragment.setArguments(bundleEnvio);

        //CArgar fragment en el activity
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, detallePoiFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        /*
         getSupportFragmentManager().beginTransaction()
                 .replace(R.id.container_fragment, detallePoiFragment)
                 .addToBackStack(null).commit();
        */
        //***Luego pasar a programar al fragmentdetalle
    }




}
