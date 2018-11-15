package inc.machine_code.reusable.List_GridView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import inc.machine_code.reusable.Filter.FilterClass;
import inc.machine_code.reusable.R;

public class MobileArrayAdapter extends ArrayAdapter<String> implements Filterable {

    private final Context context;
    public ArrayList<String> filterData;
    public ArrayList<String> Main_Data;
    private FilterList filterable;

    public MobileArrayAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<String> Main_Data) {
        super(context, resource, Main_Data);
        this.context = context;
        this.Main_Data = Main_Data;
        this.filterData = Main_Data;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if (filterable == null) {
            filterable = new FilterList(Main_Data, this);
        }
        return filterable;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowView = null;
        if (inflater != null) {
            rowView = inflater.inflate(R.layout.list_item, parent, false);
            TextView textView = rowView.findViewById(R.id.label);
            ImageView imageView = rowView.findViewById(R.id.logo);
            textView.setText(Main_Data.get(position));
            String s = Main_Data.get(position);
            imageView.setImageResource(R.drawable.ic_action_name);
            // return rowView;
        }
        return rowView;
    }
}
