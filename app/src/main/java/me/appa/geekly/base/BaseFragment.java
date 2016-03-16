package me.appa.geekly.base;

import android.support.v4.app.Fragment;
import com.squareup.leakcanary.RefWatcher;
import me.appa.geekly.APP;

/**
 * Created by niuxm on 2016/3/16.
 */
public  class BaseFragment extends Fragment{


    @Override public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = APP.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
