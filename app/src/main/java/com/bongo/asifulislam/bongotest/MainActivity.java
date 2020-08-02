package com.bongo.asifulislam.bongotest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.bongo.asifulislam.bongotest.fragments.AnagramFragment;
import com.bongo.asifulislam.bongotest.fragments.InterfaceClassFragment;
import com.bongo.asifulislam.bongotest.fragments.VideoPlayerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm;
    private static String TAG_FRAGMENT="1";

    final Fragment fragment1 =AnagramFragment.newInstance();
    final Fragment fragment2 = InterfaceClassFragment.newInstance();
    final Fragment fragment3 =VideoPlayerFragment.newInstance();
    Fragment activefragment=fragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);

        fm = getSupportFragmentManager();


        loadFragment();
        navigation.setOnNavigationItemSelectedListener(this);

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("TAG_FRAGMENT", TAG_FRAGMENT);

    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(this, "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        TAG_FRAGMENT = savedInstanceState.getString("TAG_FRAGMENT");
    }

    private boolean loadFragment() {
        switch (TAG_FRAGMENT){
            case "1":
                activefragment=fragment1;
                break;
            case "2":
                activefragment=fragment2;
                break;
            case "3":
                activefragment=fragment3;
                break;
        }

        //switching fragment
        if (activefragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, activefragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_home:
                activefragment = fragment1;
                TAG_FRAGMENT="1";
                break;
            case R.id.navigation_dashboard:
                activefragment = fragment2;
                TAG_FRAGMENT="2";
                break;
            case R.id.navigation_notifications:
                activefragment = fragment3;
                TAG_FRAGMENT="3";
               break;
        }

      return loadFragment();
    }
}