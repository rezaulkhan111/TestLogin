package inc.machine_code.reusable.ActivityPackage.CheckBox;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.chip.Chip;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import inc.machine_code.reusable.R;

public class CheckBoxActivity extends AppCompatActivity {

    CheckBox checkBox1;
    RadioGroup radioGroup;
    ToggleButton toggle;
    FloatingActionButton fab;
    Chip chip;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        checkBox1 = findViewById(R.id.checkBox1);
        radioGroup = findViewById(R.id.rg_android_phone);
        fab = findViewById(R.id.floatingActionButton);
        toggle = findViewById(R.id.toggleButton);


        CheckBoxMethod();
        ToggleMethod();
        RadioGroupMehod();
        FloatingButtonMethod();
    }

    private void ChipMethod(){

    }

    private void RadioGroupMehod() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getId()) {
                    case 1:
                        Toast.makeText(getApplicationContext(), "" + group.getId(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "" + group.getId(), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "" + group.getId(), Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });
    }

    private void CheckBoxMethod() {
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Check Box 1 ***** " + isChecked, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Check Box 1 ***** " + isChecked, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ToggleMethod() {

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "ON" + isChecked, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "OFF" + isChecked, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void FloatingButtonMethod() {

        // fab.setTooltipText("Send an email");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Here's a Snackbar", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}
