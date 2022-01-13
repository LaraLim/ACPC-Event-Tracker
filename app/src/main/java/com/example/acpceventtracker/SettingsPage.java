package com.example.acpceventtracker;

/**
 * References:
 * https://developer.android.com/guide/topics/ui/controls/togglebutton
 * https://developer.android.com/reference/android/widget/Switch
 * https://codinginfinite.com/setting-input-output-data-with-workmanager/
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
import androidx.work.Data;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.time.Duration;

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

        NotificationSender notificationSender = new NotificationSender(SettingsPage.this);

        // garden notification switch
        notifSwitchGarden.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    notifSwitchFishing.setChecked(false);
                    notifSwitchGyroidite.setChecked(false);

                    Duration notificationInterval = Duration.ofMinutes(90);
                    Data notifTypeData = new Data.Builder().putString("notifType", "garden").build(); // create Data object specifying the notification type

                    // clear workManager
                    WorkManager.getInstance(getApplicationContext()).cancelAllWorkByTag("fishingNotif");
                    WorkManager.getInstance(getApplicationContext()).cancelAllWorkByTag("gyroidNotif");

                    // create the PeriodicWorkRequest
                    WorkRequest notificationWorkRequest = new PeriodicWorkRequest.Builder(NotificationWorker.class, notificationInterval)
                            .setInputData(notifTypeData) // notification type
                            .addTag("gardenNotif")
                            .build();
                    WorkManager.getInstance(getApplicationContext()).enqueue(notificationWorkRequest); // submit request to the system

//                    notificationSender.sendGardenNotification(); // this is a test
                }
            }
        });

        // fishing notification switch
        notifSwitchFishing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    notifSwitchGarden.setChecked(false);
                    notifSwitchGyroidite.setChecked(false);

                    Duration notificationInterval = Duration.ofHours(3);
                    Data notifTypeData = new Data.Builder().putString("notifType", "fishing").build(); // create Data object specifying the notification type

                    // clear workManager
                    WorkManager.getInstance(getApplicationContext()).cancelAllWorkByTag("gardenNotif");
                    WorkManager.getInstance(getApplicationContext()).cancelAllWorkByTag("gyroidNotif");

                    // create the PeriodicWorkRequest
                    WorkRequest notificationWorkRequest = new PeriodicWorkRequest.Builder(NotificationWorker.class, notificationInterval)
                            .setInputData(notifTypeData) // notification type
                            .addTag("fishingNotif")
                            .build();
                    WorkManager.getInstance(getApplicationContext()).enqueue(notificationWorkRequest); // submit request to the system

//                    notificationSender.sendFishingNotification(); // this is a test
                }
            }
        });

        // gyroidite notification switch
        notifSwitchGyroidite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    notifSwitchGarden.setChecked(false);
                    notifSwitchFishing.setChecked(false);

                    Duration notificationInterval = Duration.ofHours(1);
                    Data notifTypeData = new Data.Builder().putString("notifType", "gyroid").build(); // create Data object specifying the notification type

                    // clear workManager
                    WorkManager.getInstance(getApplicationContext()).cancelAllWorkByTag("gardenNotif");
                    WorkManager.getInstance(getApplicationContext()).cancelAllWorkByTag("fishingNotif");

                    // create the PeriodicWorkRequest
                    WorkRequest notificationWorkRequest = new PeriodicWorkRequest.Builder(NotificationWorker.class, notificationInterval)
                            .setInputData(notifTypeData) // notification
                            .addTag("gyroidNotif")
                            .build();
                    WorkManager.getInstance(getApplicationContext()).enqueue(notificationWorkRequest); // submit request to the system

//                    notificationSender.sendGyroidNotification(); // this is a test
                }
            }
        });
    }
}
