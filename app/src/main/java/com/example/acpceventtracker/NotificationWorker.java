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
    public NotificationWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {
        NotificationSender notificationSender = new NotificationSender(getApplicationContext());
        notificationSender.sendTestNotification();

        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }

}
