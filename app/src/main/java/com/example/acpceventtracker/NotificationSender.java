package com.example.acpceventtracker;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/***
 * A class to 
 */

public class NotificationSender {
    private Context context;

    public NotificationSender(Context context){
        this.context = context;
    }

    public void sendTestNotification(){
        Intent intent = new Intent(context, SettingsPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, context.getString(R.string.channel_id))
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("testTitle")
                .setContentText("testContent :)")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(0, builder.build());
    }
}
