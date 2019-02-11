package com.example.rajayambigms.googlemap;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private fragment_Explore fragment_explore;
    private fragment_Commute fragment_commute;
    private fragment_Foryou fragment_foryou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        fragment_explore = new fragment_Explore();
        fragment_commute = new fragment_Commute();
        fragment_foryou = new fragment_Foryou();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                if(R.id.bottom_nav_explore == id) {
                    setFragments(fragment_explore);
                    return true;
                }
                else if(R.id.bottm_nav_commute == id) {
                    setFragments(fragment_commute);
                    return  true;
                }
                else if(R.id.bottom_nav_foryou == id) {
                    setFragments(fragment_foryou);
                    return true;
                }

                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_explore);
    }

    private void setFragments(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();

    }
}
