package com.chan.android_lab4;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DynamicReceiver extends BroadcastReceiver {

    private static final String DYNAMICACTION = "dynamic_action";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        if(intent.getAction().equals(DYNAMICACTION)){
            Bundle bundle = intent.getExtras();

//            Toast.makeText(context, bundle.getString("name"), Toast.LENGTH_LONG).show();

            //获取通知栏管理
            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            //实例化通知栏构造器
            Notification.Builder builder = new Notification.Builder(context);
            //对builder进行配置
            builder.setContentTitle("马上下单")
                    .setContentText(bundle.getString("name")+"已添加到购物车")
                    .setTicker("you have a new message~")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.ferrero)
                    .setAutoCancel(true);
            //绑定Intent，点击可以进入某activity
            Intent mIntent = new Intent(context, MainActivity.class);
            PendingIntent mPendingIntent = PendingIntent.getActivity(context,0,mIntent,0);
            builder.setContentIntent(mPendingIntent);
            //绑定Notification，发送通知请求
            Notification notify=builder.build();
            manager.notify(1,notify);
        }
    }
}