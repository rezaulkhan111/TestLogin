package inc.machine_code.reusable.Filter;

import android.widget.Filter;

import java.util.ArrayList;

import inc.machine_code.reusable.Adapter.AdapterClass;
import inc.machine_code.reusable.model.List_Data;

public class FilterClass extends Filter {

    private final ArrayList<List_Data> list_dataArrayList;
    AdapterClass adapterClass;

    public FilterClass(ArrayList<List_Data> list_dataArrayList, AdapterClass adapterClass) {
        this.list_dataArrayList = list_dataArrayList;
        this.adapterClass = adapterClass;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults results = new FilterResults();
        if (constraint != null && constraint.length() > 0) {
            //CHANGE TO UPPER
            constraint = constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<List_Data> filteredPlayers = new ArrayList<>();
            for (int i = 0; i < list_dataArrayList.size(); i++) {
                //CHECK
                if (list_dataArrayList.get(i).getName().toUpperCase().contains(constraint)) {
                    filteredPlayers.add(list_dataArrayList.get(i));
                }
            }
            results.count = filteredPlayers.size();
            results.values = filteredPlayers;
        } else {
            results.count = list_dataArrayList.size();
            results.values = list_dataArrayList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapterClass.filterable_Data_List = (ArrayList<List_Data>) results.values;
        adapterClass.notifyDataSetChanged();
    }
}
