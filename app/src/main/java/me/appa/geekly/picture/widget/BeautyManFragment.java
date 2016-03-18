package me.appa.geekly.picture.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import me.appa.geekly.R;
import me.appa.geekly.base.BaseFragment;
import me.appa.geekly.utils.MeasureUtil;

/**
 * Created by niuxm on 2016/3/16.
 */
public class BeautyManFragment extends BaseFragment implements PictureAdatper
        .ItemViewHolder.ClickListener{

    @Bind(R.id.pic_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.pic_recyclerview) RecyclerView mRecyclerView;

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pager, container,
                false);
        ButterKnife.bind(this,view);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,R
                .color.colorPrimaryDark,R.color.colorAccent,R.color.cardview_dark_background);

        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.addItemDecoration(new BaseSpacesItemDecoration(
                MeasureUtil.dp2px(2)));
        PictureAdatper pictureAdatper = new PictureAdatper(this);
        DefaultItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setChangeDuration(250);
        mRecyclerView.setItemAnimator(itemAnimator);

        mRecyclerView.setAdapter(pictureAdatper);

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


    @Override public void onItemClicked(int position) {
        Snackbar.make(mRecyclerView, "this is a snacker"+position,
                Snackbar.LENGTH_SHORT).show();
    }


    @Override public boolean onItemLongClickListener(int position) {

        return false;
    }
}
