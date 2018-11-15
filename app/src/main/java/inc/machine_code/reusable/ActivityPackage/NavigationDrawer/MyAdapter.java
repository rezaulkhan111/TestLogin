package inc.machine_code.reusable.ActivityPackage.NavigationDrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import inc.machine_code.reusable.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context c;
    ArrayList<String> spacecrafts;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(c).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }


    class ViewHolder extends CustomViewHolder {
        ImageView _imageView;
        TextView _textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            _imageView = itemView.findViewById(R.id.logo);
            _textView = itemView.findViewById(R.id.label);
        }

        @Override
        public void onBind(int position) {
            String s = spacecrafts.get(position);
            _imageView.setImageResource(R.drawable.ic_action_name);
            _textView.setText(s);
        }
    }

}
