package de.eightbitboy.minsim.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.eightbitboy.minsim.R;
import de.eightbitboy.minsim.fragments.inventory.InventoryFragment;
import de.eightbitboy.minsim.fragments.level.LevelFragment;
import de.eightbitboy.minsim.fragments.level.dummy.DummyContent;

//TODO read about the interfaces
//http://stackoverflow.com/questions/24777985/how-to-implement-onfragmentinteractionlistener
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation) BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment levelFragment = new LevelFragment();
        final Fragment inventoryFragment = new InventoryFragment();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, levelFragment).commit();

        navigation.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment = levelFragment;
                        break;
                    case R.id.navigation_dashboard:
                        fragment = inventoryFragment;
                        break;
                }

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, fragment).commit();

                return true;
            }
        });
    }
}
