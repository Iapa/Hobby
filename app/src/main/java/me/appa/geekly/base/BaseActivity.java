package me.appa.geekly.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.squareup.leakcanary.RefWatcher;
import me.appa.geekly.APP;

/**
 * Created by niuxm on 2016/3/15.
 */
public  class BaseActivity extends AppCompatActivity implements View
        .OnClickListener {

    @Override protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = APP.getRefWatcher(this);
        refWatcher.watch(this);
    }


    @Override public void onClick(View v) {

    }
}

