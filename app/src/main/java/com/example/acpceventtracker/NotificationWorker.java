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
        if(notifType == null){
            System.out.println("<><><><><><><><><><><><><><><><><>notifType is null<><><><><><><><><><><><><><><><><>");
            notifType = this.getInputData().getString("notifType"); // the type of notification passed as input data
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<READ INPUT DATA>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }

        if(notifType.equals("garden")) {
            notificationSender.sendGardenNotification();
            System.out.println(">>>>>>>>>>>>>>>>>DATA RECEIVED: GARDEN");
        }
        else if(notifType.equals("fishing")) {
            notificationSender.sendFishingNotification();
            System.out.println(">>>>>>>>>>>>>>>>>DATA RECEIVED: FISHING");
        }
        else if(notifType.equals("gyroid")) {
            notificationSender.sendGyroidNotification();
            System.out.println(">>>>>>>>>>>>>>>>>DATA RECEIVED: GYROID");
        }

        // Indicate whether the work finished successfully with the Result
        return Result.success();
    }
}
