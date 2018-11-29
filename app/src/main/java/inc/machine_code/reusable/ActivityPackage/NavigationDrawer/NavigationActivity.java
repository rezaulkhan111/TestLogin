package inc.machine_code.reusable.ActivityPackage.NavigationDrawer;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import inc.machine_code.reusable.ActivityPackage.BottomSheet.BottomSheetActivity;
import inc.machine_code.reusable.R;

public class NavigationActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_activity);

        initViews();
        setToolbar();
        setNavItemSelectedListener();
        setDrawerLayoutListener();
    }

    private void initViews() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void replaceFragment(android.app.Fragment fragment) {

        getFragmentManager().popBackStack();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment, "HomeDairy");
        transaction.addToBackStack(null);
        transaction.commit();
        Toast.makeText(this, "" + fragment.getClass(), Toast.LENGTH_SHORT).show();

    }

    public void setDrawerLayoutListener() {
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
//                        Toast.makeText(MainActivity.this, "Slide", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDrawerOpened(@NonNull View drawerView) {

                        // Respond when the drawer is opened
                        Toast.makeText(NavigationActivity.this, "OPEN", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDrawerClosed(@NonNull View drawerView) {
                        // Respond when the drawer is closed
                        Toast.makeText(NavigationActivity.this, "CLOSE", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
//                        Toast.makeText(MainActivity.this, "StateChange", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_action_name);
    }

    public void setNavItemSelectedListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                android.support.v4.app.Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {

                    case R.id.item_camera:
                        selectedFragment = new InterGalactic();
                        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        assert selectedFragment != null;
                        transaction.replace(R.id.frame, selectedFragment);
                        transaction.commit();

                        Log.e("aaa", "onNavigationItemSelected: "+"item_camera");
                        break;

                    case R.id.item_gallery:

                        Log.e("111", "onNavigationItemSelected: ");
                        break;
                }
                return true;
            }
        });
    }

}
