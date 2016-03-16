package me.appa.geekly;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import me.appa.geekly.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(mToolbar);

        // create our manager instance after the content view is set
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true);

        // set a custom tint color for all system bars
        tintManager.setTintColor(R.color.colorPrimaryDark);
        // set a custom navigation bar resource
        tintManager.setNavigationBarTintResource(R.color.colorPrimaryDark);

        // set a custom status bar drawable
        tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
    }
}
