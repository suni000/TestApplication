package com.aliyun.emas.pocdemo;

import android.content.Context;

import com.alibaba.sdk.android.push.AliyunMessageIntentService;
import com.alibaba.sdk.android.push.notification.CPushMessage;

import java.util.Map;

public class MsgService extends AliyunMessageIntentService {
    @Override
    protected void onNotification(Context context, String s, String s1, Map<String, String> map) {

    }

    @Override
    protected void onMessage(Context context, CPushMessage cPushMessage) {

    }

    @Override
    protected void onNotificationOpened(Context context, String s, String s1, String s2) {

    }

    @Override
    protected void onNotificationClickedWithNoAction(Context context, String s, String s1, String s2) {

    }

    @Override
    protected void onNotificationRemoved(Context context, String s) {

    }

    @Override
    protected void onNotificationReceivedInApp(Context context, String s, String s1, Map<String, String> map, int i, String s2, String s3) {

    }
}
