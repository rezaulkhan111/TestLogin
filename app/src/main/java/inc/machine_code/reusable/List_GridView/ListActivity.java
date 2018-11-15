package inc.machine_code.reusable.List_GridView;

import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import inc.machine_code.reusable.MainActivity;
import inc.machine_code.reusable.R;

public class ListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    ListView list;
    // static final String[] MOBILE_OS = new String[]{"Android", "iOS", "Windows", "Linux"};
    ArrayList<String> MOBILE_OS;
    MobileArrayAdapter adapter;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        swipeContainer = findViewById(R.id.swipeContainer);
        MOBILE_OS = new ArrayList<>();
        MOBILE_OS.add("A");
        MOBILE_OS.add("V");
        MOBILE_OS.add("C");
        MOBILE_OS.add("F");
        MOBILE_OS.add("E");
        MOBILE_OS.add("Z");
        MOBILE_OS.add("R");
        MOBILE_OS.add("L");
        MOBILE_OS.add("T");
        MOBILE_OS.add("G");
        MOBILE_OS.add("Q");

        Collections.sort(MOBILE_OS);
        list = findViewById(R.id.list_View_t);

        adapter = new MobileArrayAdapter(this, R.layout.list_item, MOBILE_OS);
        list.setAdapter(adapter);

        swipeContainer.setOnRefreshListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu_item, menu);
        Search(menu);
        return true;
    }

    private void Search(Menu menu) {
        MenuItem searchViewMenuItem = menu.findItem(R.id.menu_search_bar);
        SearchView _search_view;
        _search_view = (SearchView) MenuItemCompat.getActionView(searchViewMenuItem);
        int searchImgId = android.support.v7.appcompat.R.id.search_button;
        ImageView _image_view = _search_view.findViewById(searchImgId);
        _search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String get_custom_text) {
                adapter.getFilter().filter(get_custom_text);
                return false;
            }
        });
    }

    @Override
    public void onRefresh() {

        swipeContainer.setColorSchemeColors(255, 255, 255);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Stop animation (This will be after 3 seconds)
                swipeContainer.setRefreshing(false);
            }
        }, 4000);
    }
}
