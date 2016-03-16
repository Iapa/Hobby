package me.appa.geekly.picture.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import me.appa.geekly.R;
import me.appa.geekly.base.BaseFragment;

/**
 * Created by niuxm on 2016/3/16.
 */
public class BeautyManFragment extends BaseFragment{

    @Bind(R.id.pic_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.pic_recyclerview) RecyclerView mRecyclerView;

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pager, container,
                false);
        ButterKnife.bind(this,view);

        return view;
    }
    public BeautyManFragment() {
    }


    public static BeautyManFragment getInstance(int type) {
        BeautyManFragment beautyManFragment = new BeautyManFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        beautyManFragment.setArguments(bundle);
        return beautyManFragment;
    }

}
