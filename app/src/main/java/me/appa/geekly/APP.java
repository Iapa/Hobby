package me.appa.geekly;

import android.app.Application;
import android.content.Context;
import com.facebook.stetho.Stetho;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by niuxm on 2016/3/15.
 */
public class APP extends Application {

    private RefWatcher mRefWatcher;
    private static Context mContext;


    //
    public static RefWatcher getRefWatcher(Context context) {
        APP app = (APP) context.getApplicationContext();
        return app.mRefWatcher;
    }


    @Override public void onCreate() {
        super.onCreate();
        Logger.init();
        mRefWatcher = LeakCanary.install(this);
        Stetho.initializeWithDefaults(this);
        mContext = this;
    }


    //some utils class need context
    public static Context getContext() {
        return mContext;
    }



    /*new OkHttpClient.Builder()
            .addNetworkInterceptor(new StethoInterceptor())
            .build()*/
}
