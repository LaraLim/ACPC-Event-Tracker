package com.example.acpceventtracker;

/**
 * References:
 * https://developer.android.com/guide/topics/ui/controls/togglebutton
 * https://developer.android.com/reference/android/widget/Switch
 * */

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class SettingsPage extends AppCompatActivity {

    TextView notifPageTitle, notifSubtitle;
    Switch notifSwitchGarden, notifSwitchFishing, notifSwitchGyroidite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        notifPageTitle = findViewById(R.id.notifPageTitle);
        notifSubtitle = findViewById(R.id.notifSubtitle);

        // switches are mutually exclusive
        notifSwitchGarden = findViewById(R.id.notifSwitchGarden);
        notifSwitchFishing = findViewById(R.id.notifSwitchFishing);
        notifSwitchGyroidite = findViewById(R.id.notifSwitchGyroidite);

        //notification toggle and settings

        // garden notification switch
        notifSwitchGarden.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    notifSwitchFishing.setChecked(false);
                    notifSwitchGyroidite.setChecked(false);


                } else {

                }
            }
        });

        // fishing notification switch
        notifSwitchFishing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    notifSwitchGarden.setChecked(false);
                    notifSwitchGyroidite.setChecked(false);


                } else {

                }
            }
        });

        // gyroidite notification switch
        notifSwitchGyroidite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    notifSwitchGarden.setChecked(false);
                    notifSwitchFishing.setChecked(false);


                } else {

                }
            }
        });
    }
}
