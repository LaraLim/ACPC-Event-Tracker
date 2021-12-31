package com.example.acpceventtracker;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
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

        //notification toggle
    }
}
