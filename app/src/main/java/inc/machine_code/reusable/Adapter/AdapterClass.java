package inc.machine_code.reusable.Adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import inc.machine_code.reusable.Filter.FilterClass;
import inc.machine_code.reusable.R;
import inc.machine_code.reusable.ViewHolder.AdapterViewHolder;
import inc.machine_code.reusable.model.List_Data;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> implements Filterable {

    private final ICallback callback;
    public ArrayList<List_Data> filterable_Data_List;
    private final ArrayList<List_Data> Main_data_List;
    private FilterClass filterClass;


    public AdapterClass(ICallback callback, ArrayList<List_Data> filterable_Data_List) {
        this.callback = callback;
        this.filterable_Data_List = filterable_Data_List;
        this.Main_data_List = filterable_Data_List;
    }

    public interface ICallback {
        void inClickEvent(List_Data list_data, int ID);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        viewHolder.onBind(i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List_Data listData = filterable_Data_List.get(i);
                int nameID = filterable_Data_List.get(i).getId();
                callback.inClickEvent(listData, nameID);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filterable_Data_List.size();
    }

    @Override
    public Filter getFilter() {
        if (filterClass == null) {
            filterClass = new FilterClass(Main_data_List, this);
        }
        return filterClass;
    }

    public class ViewHolder extends AdapterViewHolder {
        final TextView tv_ID;
        final TextView tv_NAME;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ID = itemView.findViewById(R.id.tv_id);
            tv_NAME = itemView.findViewById(R.id.tv_name);
        }

        @Override
        public void onBind(int position) {
            List_Data list_data = filterable_Data_List.get(position);
            tv_ID.setText(String.valueOf(list_data.getId()));
            tv_NAME.setText(list_data.getName());

        }
    }
}
