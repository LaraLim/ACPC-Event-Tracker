package com.example.acpceventtracker;

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
        // Do the work here--in this case, upload the images.
        NotificationSender notificationSender = new NotificationSender(getApplicationContext());
        notificationSender.sendTestNotification();

        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }

}
