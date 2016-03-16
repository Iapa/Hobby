package me.appa.geekly;

import android.app.Application;
import android.content.Context;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import okhttp3.OkHttpClient;

/**
 * Created by niuxm on 2016/3/15.
 */
public class APP extends Application {

    private RefWatcher mRefWatcher;
    private Context mContext;


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
    }


    //some utils class need context
    public Context getContext() {
        return this.getApplicationContext();
    }



    /*new OkHttpClient.Builder()
            .addNetworkInterceptor(new StethoInterceptor())
            .build()*/
}
