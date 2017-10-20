package cn.cibn.hostlibrary;

import android.app.Application;

/**
 * Created by 15210 on 2017/10/19.
 */

public class HostApplication extends Application {
    public static HostApplication hostApplication;
    public HostClass hostClass;
    @Override
    public void onCreate() {
        super.onCreate();
        hostApplication = this;
//        hostClass = HostClass.getInstance(this);
//        hostClass.loadCibnSdk();
    }

    public HostApplication getInstance(){
        return hostApplication;
    }
}
