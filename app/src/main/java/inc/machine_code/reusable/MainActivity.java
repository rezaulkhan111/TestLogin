package inc.machine_code.reusable;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

import inc.machine_code.reusable.ActivityPackage.BottomNavigation.BottomNavigationActivity;
import inc.machine_code.reusable.ActivityPackage.BottomSheet.BottomSheetActivity;
import inc.machine_code.reusable.ActivityPackage.Calendar.CalendarActivity;
import inc.machine_code.reusable.ActivityPackage.CheckBox.CheckBoxActivity;
import inc.machine_code.reusable.ActivityPackage.Dialog.DialogActivity;
import inc.machine_code.reusable.ActivityPackage.NavigationDrawer.NavigationActivity;
import inc.machine_code.reusable.ActivityPackage.Notification.NotificationActivity;
import inc.machine_code.reusable.ActivityPackage.Spinner.SpinnerActivity;
import inc.machine_code.reusable.ActivityPackage.TabLayout.TabLayoutActivity;
import inc.machine_code.reusable.Adapter.AdapterClass;
import inc.machine_code.reusable.List_GridView.ListActivity;
import inc.machine_code.reusable.model.List_Data;

public class MainActivity extends AppCompatActivity implements AdapterClass.ICallback {

    private AdapterClass adapter;
    private final ArrayList<List_Data> dataArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id._recycler_view_layout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataArrayList.add(new List_Data(10, "Navigation Drawer"));
        dataArrayList.add(new List_Data(11, "Bottom Sheet Layout"));
        dataArrayList.add(new List_Data(12, "Dialog"));
        dataArrayList.add(new List_Data(13, "All Buttons, Check Box"));
        dataArrayList.add(new List_Data(14, "Spinner"));
        dataArrayList.add(new List_Data(15, "Bottom Navigation"));
        dataArrayList.add(new List_Data(16, "Calendar"));
        dataArrayList.add(new List_Data(17, "Notification"));
        dataArrayList.add(new List_Data(18, "List/GridView"));
        dataArrayList.add(new List_Data(19, "Tab Layout"));
        //  dataArrayList.add(new List_Data(20, "Tab Layout"));


        adapter = new AdapterClass(this, dataArrayList);
        recyclerView.setAdapter(adapter);

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
        //SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView _search_view;
        _search_view = (SearchView) MenuItemCompat.getActionView(searchViewMenuItem);
        int searchImgId = android.support.v7.appcompat.R.id.search_button;
        ImageView _image_view = _search_view.findViewById(searchImgId);
        // _image_view.setImageResource(R.drawable.ic_search_item_icon);
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
    public void inClickEvent(List_Data list_data, int ID) {

        if (list_data.getId() == 10) {
            Intent navigation_intent = new Intent(this, NavigationActivity.class);
            startActivity(navigation_intent);
        }
        if (list_data.getId() == 11) {
            Intent bottom_sheet_Intent = new Intent(this, BottomSheetActivity.class);
            startActivity(bottom_sheet_Intent);
        }
        if (list_data.getId() == 12) {
            Intent dialog_Intent = new Intent(this, DialogActivity.class);
            startActivity(dialog_Intent);
        }
        if (list_data.getId() == 13) {
            Intent check_box_Intent = new Intent(this, CheckBoxActivity.class);
            startActivity(check_box_Intent);
        }
        if (list_data.getId() == 14) {
            Intent Spinner_Intent = new Intent(this, SpinnerActivity.class);
            startActivity(Spinner_Intent);
        }
        if (list_data.getId() == 15) {
            Intent Bottom_Navigation_Intent = new Intent(this, BottomNavigationActivity.class);
            startActivity(Bottom_Navigation_Intent);
        }
        if (list_data.getId() == 16) {
            Intent Bottom_Navigation_Intent = new Intent(this, CalendarActivity.class);
            startActivity(Bottom_Navigation_Intent);
        }
        if (list_data.getId() == 17) {
            Intent Bottom_Navigation_Intent = new Intent(this, NotificationActivity.class);
            startActivity(Bottom_Navigation_Intent);
        }
        if (list_data.getId() == 18) {
            Intent Bottom_Navigation_Intent = new Intent(this, ListActivity.class);
            startActivity(Bottom_Navigation_Intent);
        }
        if (list_data.getId() == 19) {
            Intent Tab_Layout_Intent = new Intent(this, TabLayoutActivity.class);
            startActivity(Tab_Layout_Intent);
        }
//        if (list_data.getId() == 20) {
//            Intent Bottom_Navigation_Intent = new Intent(this, NotificationActivity.class);
//            startActivity(Bottom_Navigation_Intent);
//        }
    }
}
