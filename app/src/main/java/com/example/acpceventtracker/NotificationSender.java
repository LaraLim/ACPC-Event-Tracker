package com.example.acpceventtracker;

/**
 * References:
 * https://developer.android.com/training/notify-user/build-notification#java
 * */

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationSender {
    private Context context;

    public NotificationSender(Context context){
        this.context = context;
    }

    public void sendGardenNotification(){
        Intent intent = new Intent(context, SettingsPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, context.getString(R.string.channel_id))
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Tend to Pocket Camp garden")
                .setContentText("Water or harvest flowers \uD83C\uDF37\uD83C\uDF3C\uD83C\uDF3B")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(0, builder.build());
    }

    public void sendFishingNotification(){
        Intent intent = new Intent(context, SettingsPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, context.getString(R.string.channel_id))
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Pocket Camp tourney fish respawned")
                .setContentText("Catch fish & reach goals \uD83C\uDFA3\uD83D\uDC20")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(0, builder.build());
    }

    public void sendGyroidNotification(){
        Intent intent = new Intent(context, SettingsPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 2, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, context.getString(R.string.channel_id))
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Pocket Camp gyroidites respawned")
                .setContentText("Collect gyroidites & craft furniture \uD83E\uDDFA")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(0, builder.build());
    }
}
