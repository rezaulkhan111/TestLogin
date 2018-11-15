package inc.machine_code.reusable.List_GridView;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FilterList extends Filter {
    private final ArrayList<String> MOBILE_OS;
    MobileArrayAdapter arrayAdapter;

    public FilterList(ArrayList<String> stringlist, MobileArrayAdapter adapter) {
        MOBILE_OS = stringlist;
        this.arrayAdapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults results = new FilterResults();
        if (constraint != null && constraint.length() > 0) {
            constraint = constraint.toString();

            ArrayList<String> S_filter = new ArrayList<>();
            for (int i = 0; i < MOBILE_OS.size(); i++) {
                if (MOBILE_OS.get(i).equalsIgnoreCase(constraint.toString())) {

                    S_filter.add(MOBILE_OS.get(i));
                }
            }
            results.count = S_filter.size();
            results.values = S_filter;
        } else {
            results.count = MOBILE_OS.size();
            results.values = MOBILE_OS;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        try {
            arrayAdapter.filterData = (ArrayList<String>) results.values;
            arrayAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
