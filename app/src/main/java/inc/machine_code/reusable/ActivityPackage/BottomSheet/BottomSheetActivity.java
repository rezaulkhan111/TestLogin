package inc.machine_code.reusable.ActivityPackage.BottomSheet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import inc.machine_code.reusable.MainActivity;
import inc.machine_code.reusable.R;

@SuppressLint("Registered")
public class BottomSheetActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();


    Button btnExpandSheet;
    Button btnBottomSheetDialog;
    BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_activity);

        btnBottomSheetDialog = findViewById(R.id.btn_Bottom_Sheet_Dialog);
        btnExpandSheet = findViewById(R.id.btn_Expand_Sheet);
        sheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet_Scroll));
        sheetBehavior.setHideable(true);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        btnExpandSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    btnExpandSheet.setText("Show");
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    btnExpandSheet.setText("Hide");
                }
            }
        });
        btnBottomSheetDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showBottomSheetDialog();
    }

    private void showBottomSheetDialog() {
        @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        ImageView _iv_facebook, _iv_twitter, _iv_mail;
        TextView _tv_bottom_sheet;
        String text = "If you need more about satellite category. Satellite type short meaning Search Google";

        _tv_bottom_sheet = view.findViewById(R.id.tv_more_info);
        _iv_facebook = view.findViewById(R.id.iv_facebook);
        _iv_twitter = view.findViewById(R.id.iv_twitter);
        _iv_mail = view.findViewById(R.id.iv_mail);

        _iv_facebook.setImageResource(R.mipmap.ic_launcher_round);
        _iv_twitter.setImageResource(R.mipmap.ic_launcher_round);
        _iv_mail.setImageResource(R.mipmap.ic_launcher_round);

        _tv_bottom_sheet.setMovementMethod(ScrollingMovementMethod.getInstance());
        _tv_bottom_sheet.setVerticalScrollBarEnabled(true);
        _tv_bottom_sheet.setText(text);
        _tv_bottom_sheet.setTextColor(Color.rgb(255, 102, 140));

        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();
    }
}
