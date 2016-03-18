package me.appa.geekly.picture.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import me.appa.geekly.R;
import me.appa.geekly.base.BaseFragment;

/**
 * Created by niuxm on 2016/3/16.
 */
public class PicFragment extends BaseFragment{

    @Bind(R.id.pic_viewpager) ViewPager mViewPager;
    @Bind(R.id.tab_layout) TabLayout mTabLayout;

    public static PicFragment getInstance() {

        PicFragment mPicFragment = new PicFragment();
        Bundle bundle = new Bundle();
        mPicFragment.setArguments(bundle);
        return mPicFragment;
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pic, container,
                false);
        ButterKnife.bind(this,view);
        mViewPager.setOffscreenPageLimit(3);
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());

        return view;
    }


    private void setupViewPager(ViewPager viewPager) {
        PicPagerAdapter pagerAdapter = new PicPagerAdapter(
                getChildFragmentManager());

        pagerAdapter.addFragments(BeautyManFragment.getInstance(1),"美女");
        pagerAdapter.addFragments(BeautyManFragment.getInstance(2),"帅哥");
        pagerAdapter.addFragments(BeautyManFragment.getInstance(3),"风景");
        viewPager.setAdapter(pagerAdapter);
    }


    private class PicPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments = new ArrayList<>();
        private List<String> mTitle = new ArrayList<>();

        public PicPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override public Fragment getItem(int position) {
            return mFragments.get(position);
        }


        @Override public int getCount() {
            return 3;
        }


        public void addFragments(Fragment fragment, String title) {
            mFragments.add(fragment);
            mTitle.add(title);
        }


        @Override public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
        }
    }
}
