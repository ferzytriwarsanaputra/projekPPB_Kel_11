package com.example.projek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.projek.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new home());

        binding.bottomNav.setOnItemSelectedListener(item->{
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new home());
                    break;
                case R.id.quiz:
                    replaceFragment(new quiz());
                    break;
            }
            return true;
        });

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle =  new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.mat_sino:
                        replaceFragment(new materi_sinonim());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.mat_anto:
                        replaceFragment(new materi_antonim());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.kam_sino:
                        replaceFragment(new kamus_sinonim());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.kam_anto:
                        replaceFragment(new kamus_antonim());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_about:
                        openDialog();
                        drawerLayout.closeDrawer(GravityCompat.START);
                }

                return false;
            }
        });
    }
    public void openDialog(){
        about about = new about();
        about.show(getSupportFragmentManager(), "about");
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmlayout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}