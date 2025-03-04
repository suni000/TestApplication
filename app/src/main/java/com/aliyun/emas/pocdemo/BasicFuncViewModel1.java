package com.aliyun.emas.pocdemo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class BasicFuncViewModel1 extends AndroidViewModel {
    private static String RESPONSE_CHANNEL_OPEN = "on";
    public BasicFuncViewModel1(@NonNull Application application) {
        super(application);
    }
}
