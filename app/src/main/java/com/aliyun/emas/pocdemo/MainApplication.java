package com.aliyun.emas.pocdemo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;


import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.HonorRegister;
import com.alibaba.sdk.android.push.huawei.HuaWeiRegister;
import com.alibaba.sdk.android.push.noonesdk.PushInitConfig;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.alibaba.sdk.android.push.register.MeizuRegister;
import com.alibaba.sdk.android.push.register.OppoRegister;
import com.alibaba.sdk.android.push.register.VivoRegister;

public class MainApplication extends Application {
    Context applicationContext ;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
//        Config.init(this);

        PushInitConfig pushInitConfig = new PushInitConfig.Builder()
                .application(this)
                .appKey(Config.APP_KEY)    //请填写你自己的appKey
                .appSecret(Config.APP_SECRET)    //请填写你自己的appSecret
                .build();
        PushServiceFactory.init(pushInitConfig);
        PushServiceFactory.getCloudPushService().setDebug(true);
        PushServiceFactory.getCloudPushService().setLogLevel(CloudPushService.LOG_DEBUG);
        PushServiceFactory.getCloudPushService().setNotificationSmallIcon(R.mipmap.ic_launcher);
        createNotificationChannel();
        initOthers();
    }

    private void initOthers() {
        HuaWeiRegister.register(this); // 接入华为辅助推送
        HonorRegister.register(this);  //荣耀推送
//        MiPushRegister.register(this, "2882303761520226056", "5882022666056"); // 初始化小米辅助推送
        VivoRegister.registerAsync(applicationContext); //接入vivo辅助推送
        OppoRegister.registerAsync(applicationContext, "9a2d869058e94b3b9ef8ad254d45d722", "e519313fd30545afb8338810b6b941f7"); //OPPO辅助推送
        MeizuRegister.registerAsync(applicationContext, "121026", "ba7cd1a355d8416dab0142e390170e5a"); //接入魅族辅助推送
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel("8.0up", "notification channel", NotificationManager.IMPORTANCE_HIGH);
            mChannel.setDescription("notification description");
//        getSystemService(NOTIFICATION_SERVICE)
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            // 设置通知出现时的震动（如果 android 设备支持的话）
            mChannel.enableVibration(true);
            long[] longArray = {100, 200, 300, 400, 500, 400, 300, 200, 400};
            mChannel.setVibrationPattern(longArray);
            //最后在notificationmanager中创建该通知渠道
            mNotificationManager.createNotificationChannel(mChannel);
        }
    }
}
