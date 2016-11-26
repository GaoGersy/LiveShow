package com.gersion.pictureshow;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow
 * @待完成
 * @创建时间 2016/11/22
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class ShowApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger
                .init("gersy")                 // default PRETTYLOGGER or use just init()
                .methodCount(2)                 // default 2
//                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(0);

        Fresco.initialize(this);
    }
}
