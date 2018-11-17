package inc.machine_code.reusable.ActivityPackage.NavigationDrawer;

import android.annotation.SuppressLint;
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
import android.view.MenuItem;
import android.view.View;

import inc.machine_code.reusable.ActivityPackage.BottomSheet.BottomSheetActivity;
import inc.machine_code.reusable.R;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    InterGalactic obj;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_activity);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_action_name);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // set item as selected to persist highlight
        menuItem.setChecked(true);
        int id = menuItem.getItemId();
        if (id == menuItem.getItemId()) {

            NavigationActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.containerID2, obj.getMyProjectListFragment()).commit();
            mDrawerLayout.closeDrawers();
        }


        // close drawer when item is tapped
        //   mDrawerLayout.closeDrawers();

        // Add code here to update the UI based on the item selected
        // For example, swap UI fragments here


        // DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // drawer.closeDrawer(GravityCompat.START);

        return true;
    }

//        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(@NonNull View view, float v) {
//
//            }
//
//            @Override
//            public void onDrawerOpened(@NonNull View view) {
//
//            }
//
//            @Override
//            public void onDrawerClosed(@NonNull View view) {
//
//            }
//
//            @Override
//            public void onDrawerStateChanged(int i) {
//
//            }
//        });
//
//        navigationView.setNavigationItemSelectedListener(this);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        String string = (String) menuItem.getTitle();
//        if (string == menuItem.getTitle()) {
//
//            startActivity(new Intent(this, BottomSheetActivity.class));
//        }
//        return false;
//    }
}
