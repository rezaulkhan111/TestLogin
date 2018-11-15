package inc.machine_code.reusable.ActivityPackage.NavigationDrawer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class CustomViewHolder extends RecyclerView.ViewHolder {
    private int mCurrentPosition;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
    }


    public void onBind(int position) {
        mCurrentPosition = position;
    }

    public int getmCurrentPosition() {
        return mCurrentPosition;
    }
}
