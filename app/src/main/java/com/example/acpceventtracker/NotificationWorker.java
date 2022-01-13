package com.example.acpceventtracker;

/**
 * References:
 * https://developer.android.com/topic/libraries/architecture/workmanager/basics#java
 * */

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotificationWorker extends Worker {

    private String notifType;

    public NotificationWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
        notifType = null;
    }

    @Override
    public Result doWork() {
        NotificationSender notificationSender = new NotificationSender(getApplicationContext());
        notifType = this.getInputData().getString("notifType"); // the type of notification passed as input data

        if(notifType.equals("garden")) {
            notificationSender.sendGardenNotification();
        }
        else if(notifType.equals("fishing")) {
            notificationSender.sendFishingNotification();
        }
        else if(notifType.equals("gyroid")) {
            notificationSender.sendGyroidNotification();
        }

        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }
}
