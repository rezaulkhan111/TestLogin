package inc.machine_code.reusable.ActivityPackage.BottomNavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import inc.machine_code.reusable.R;

public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(false);
                switch (menuItem.getItemId()) {
                    case R.id.action_favorites:
                        Toast.makeText(getApplicationContext(), "Favorites", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_schedules:
                        Toast.makeText(getApplicationContext(), "Schedules", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_music:
                        Toast.makeText(getApplicationContext(), "Music", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }
}
