package inc.machine_code.reusable.ActivityPackage.NavigationDrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import inc.machine_code.reusable.R;

public class InterGalactic extends Fragment {

    private static InterGalactic myProjectListFragment;
    private RecyclerView rv;
    private static ArrayList<String> spacecrafts = new ArrayList<String>() {
    };

    private final static String TAG = "lch";

    public InterGalactic getMyProjectListFragment() {
        FragmentManager mFragmentManager = getFragmentManager();

        if (mFragmentManager != null) {
            mFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerID2,
                            myProjectListFragment, "myProjectListFragment")
                    .commit();
        }
        return myProjectListFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        spacecrafts.add("aaaaaaaaa");
        spacecrafts.add("aaaaaaaaa");
        spacecrafts.add("aaaaaaaaa");
        spacecrafts.add("aaaaaaaaa");
        spacecrafts.add("aaaaaaaaa");
        spacecrafts.add("aaaaaaaaa");


        View rootView = inflater.inflate(R.layout.intergalactic, container, false);
        rv = rootView.findViewById(R.id._recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv.setAdapter(new MyAdapter(getActivity(), spacecrafts));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public String toString() {
        return "InterGalactic";
    }
}
