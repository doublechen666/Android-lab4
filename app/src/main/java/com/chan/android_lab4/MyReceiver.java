package com.chan.android_lab4;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction().equals("static_action"))
        {
            Bundle bundle = intent.getExtras();
//            Toast.makeText(context, bundle.getString("name"), Toast.LENGTH_LONG).show();

            //获取通知栏管理
            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            //实例化通知栏构造器
            Notification.Builder builder = new Notification.Builder(context);
            //对builder进行配置
            builder.setContentTitle("shopping list")
                    .setContentText(bundle.getString("name")+"仅售"+bundle.getString("price"))
                    .setTicker("you have a new message~")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.ferrero)
                    .setAutoCancel(true);
            Notification notify=builder.build();
            manager.notify(0,notify);
        }
    }
}
