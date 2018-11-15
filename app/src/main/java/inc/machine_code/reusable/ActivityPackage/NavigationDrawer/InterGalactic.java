package inc.machine_code.reusable.ActivityPackage.NavigationDrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import inc.machine_code.reusable.R;

public class InterGalactic extends Fragment {


    private RecyclerView rv;
    private static String[] spacecrafts = {"Pioneer", "Voyager", "Casini", "Spirit", "Challenger"};

    public static InterGalactic newInstance() {
        return new InterGalactic();
    }

    //  @Nullable
    //  @Override
    // public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    //View rootView = inflater.inflate(R.layout.intergalactic, null);

    //REFERENCE
    //  rv = (RecyclerView) rootView.findViewById(R.id.intergalactic_RV);

    //LAYOUT MANAGER
    //  rv.setLayoutManager(new LinearLayoutManager(getActivity()));

    //ADAPTER
    //  rv.setAdapter(new MyAdapter(getActivity(), spacecrafts));

    // return rootView;
    //  }
}
