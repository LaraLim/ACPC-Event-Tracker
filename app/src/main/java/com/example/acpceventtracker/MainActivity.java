package com.example.acpceventtracker;

/**
 * References:
 * https://developer.android.com/reference/androidx/work/PeriodicWorkRequest.Builder
 * */

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.acpceventtracker.ui.main.SectionsPagerAdapter;
import com.example.acpceventtracker.databinding.ActivityMainBinding;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Duration notificationInterval = Duration.ofMinutes(15);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        // below this is notification setup stuff:

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(getString(R.string.channel_id), name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // using the floating button to test sending notifications and accessing the notification settings page
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationSender notificationSender = new NotificationSender(MainActivity.this);
                notificationSender.sendGardenNotification();
                startActivity(new Intent(MainActivity.this, SettingsPage.class)); // open the notification settings page
            }
        });

        // testing WorkRequests and WorkManager with notifications

        // create the PeriodicWorkRequest
        WorkRequest notificationWorkRequest = new PeriodicWorkRequest.Builder(NotificationWorker.class, notificationInterval).build();

        // submit the request to the system
        WorkManager.getInstance(getApplicationContext()).enqueue(notificationWorkRequest);
    }
}