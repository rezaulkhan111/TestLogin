package inc.machine_code.reusable.ActivityPackage.NavigationDrawer;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import inc.machine_code.reusable.R;

import static android.widget.Toast.*;

public class InterGalactic extends Fragment {

    //private static InterGalactic myProjectListFragment;
    private RecyclerView rv;
    private static ArrayList<String> spacecrafts = new ArrayList<String>();

    TextView textView;
    //  private final static String TAG = "lch";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        spacecrafts.add("aaaaaaaaa");
//        spacecrafts.add("aaaaaaaaa");
//        spacecrafts.add("aaaaaaaaa");
//        spacecrafts.add("aaaaaaaaa");
//        spacecrafts.add("aaaaaaaaa");
//        spacecrafts.add("aaaaaaaaa");

        View rootView = inflater.inflate(R.layout.recycler_view_layout, container, false);
        // rootView.findViewById(R.id.rev_layout_containerID_);
        rv = rootView.findViewById(R.id.recycler_view_id);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new MyAdapter(getActivity(), spacecrafts));

        return rootView;
    }
}
