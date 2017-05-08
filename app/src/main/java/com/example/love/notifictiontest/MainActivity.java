package com.example.love.notifictiontest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    /*
    通知的基本实现
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                /*
                要掌握PendingIntent和Intent的使用以及前者接受的四个参数
                 */
                Intent intent = new Intent(this, Main2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("让爱如初，温暖如昨；让我爱你，永远为期，时光恰好，你我带笑")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.one)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.two))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)       //第一种自动取消通知的方法，任一种都可以
                        //.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg"))) 设置通知的声音
                        //.setVibrate(new long[] {0,1000,1000,1000})  设置通知震动 {静止时长 震动时长 依此类推}
                        //.setLights(Color.GREEN,1000,1000)   设置通知闪光灯 闪 亮 闪 亮...
                        //.setDefaults(NotificationCompat.DEFAULT_ALL)//默认效果
                        /*
                        怎么感觉设定显示超长文字的时候没有一点改变，放佛不起作用
                         */
                        //.setStyle(new NotificationCompat.BigTextStyle().bigText("让爱如初，温暖如昨；让我爱你，永远为期，时光恰好，你我带笑"))
                        //.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.two)))
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        /*
                        通知的重要程度，MAX > HIGH > DEFAULT > LOW > MIN
                         */
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}
