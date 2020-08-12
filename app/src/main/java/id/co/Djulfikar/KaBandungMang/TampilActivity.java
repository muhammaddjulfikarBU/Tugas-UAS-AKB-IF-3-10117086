package id.co.Djulfikar.KaBandungMang;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

/**
 * * Created by 12 Agustus 2020 - 10117086 - RD Muhammad Djulfikar BU - IF3
 */


public class TampilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Home_Fragment home_fragment;
    private TampilFragment wisata_fragment;

    private TampilFragment alunalun, braga, caringintilu, punclut, shelter, dagodreampark, kiara, wonderland,
            pvj, pascal,orchid;


    private Button bDirection;
    private LatLng dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Fragment
        wisata_fragment = new TampilFragment(R.layout.fragment_wisata);


        //Wisata
        alunalun = new TampilFragment(R.layout.alunalun);
        braga = new TampilFragment(R.layout.braga);
        caringintilu = new TampilFragment(R.layout.caringintilu);
        punclut = new TampilFragment(R.layout.punclut);
        shelter = new TampilFragment(R.layout.shelter);
        dagodreampark = new TampilFragment(R.layout.dagodreampark);
        kiara = new TampilFragment(R.layout.kiara);
        wonderland = new TampilFragment(R.layout.wonderland);
        pvj = new TampilFragment(R.layout.pvj);
        pascal = new TampilFragment(R.layout.pascal);
        orchid = new TampilFragment(R.layout.orchid);



        home_fragment = new Home_Fragment(this);
        pushFragment(home_fragment);

        bDirection = findViewById(R.id.direction);
        bDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dir != null){
                    Intent i = new Intent("android.intent.action.MAPS");
                    i.putExtra("Lat", dir.latitude);
                    i.putExtra("Lon", dir.longitude);
                    startActivity(i);
                }else{
                    Toast.makeText(TampilActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        bDirection.setVisibility(View.GONE);

        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_home:
                pushFragment(home_fragment);
                break;
            case R.id.nav_wisata:
                pushFragment(wisata_fragment);
                break;


            //Tentang
            case R.id.nav_tentang_aplikasi:
                final Dialog dialog = new Dialog(this, R.style.dialog_notitle);
                dialog.setContentView(R.layout.tentang_aplikasi);
                dialog.show();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //Wisata Fragment
    public void wisata(View v) {
        switch (v.getId()) {
            case R.id.wisata1:

                pushFragment(alunalun);
                dir = new LatLng(-6.921410, 107.606993	);
                break;
            case R.id.wisata2:
                pushFragment(braga);
                dir = new LatLng(-6.917649, 107.609355);
                break;
            case R.id.wisata3:
                pushFragment(caringintilu);
                dir = new LatLng(-6.858157, 107.664776);
                break;
            case R.id.wisata4:
                pushFragment(punclut);
                dir = new LatLng(-6.841955, 107.622701);
                break;
            case R.id.wisata5:
                pushFragment(shelter);
                dir = new LatLng(-6.899692, 107.611442);
                break;
            case R.id.wisata6:
                pushFragment(dagodreampark);
                dir = new LatLng(-6.847512, 107.625585);
                break;
            case R.id.wisata7:
                pushFragment(kiara);
                dir = new LatLng(-6.916107, 107.640708);
                break;
            case R.id.wisata8:
                pushFragment(wonderland);
                dir = new LatLng(-6.816897, 107.612443);
                break;
            case R.id.wisata9:
                pushFragment(pvj);
                dir = new LatLng(-6.889334, 107.596190);
                break;
            case R.id.wisata10:
                pushFragment(pascal);
                dir = new LatLng(-6.914475, 107.592710);
                break;
            case R.id.wisata11:
                pushFragment(orchid);
                dir = new LatLng(-6.780546, 107.637443);
                break;

        }
        bDirection.setVisibility(View.VISIBLE);
    }




    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.rootLayout, fragment);
                ft.commit();
            }
        }
    }
}
