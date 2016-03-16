package me.appa.geekly.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import me.appa.geekly.R;
import me.appa.geekly.base.BaseActivity;
import me.appa.geekly.main.presenter.MainPresenter;
import me.appa.geekly.main.presenter.MainPresenterImpl;
import me.appa.geekly.main.view.MainView;
import me.appa.geekly.picture.widget.PicFragment;

public class MainActivity extends BaseActivity implements MainView{

    @Bind(R.id.toolsbar) Toolbar mToolbar;
    @Bind(R.id.drawerlayout) DrawerLayout mDrawerLayout;
    @Bind(R.id.navigation) NavigationView mNavigationView;
    @Bind(R.id.content) FrameLayout mContent;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private MainPresenter mMainPresenter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,mToolbar,
                R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        setupDrawerContent(mNavigationView);
        mToolbar.setTitle("图片");
        mMainPresenter = new MainPresenterImpl(this);
        switch2Pic();
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mMainPresenter.switchNavigation(item.getItemId());
                item.setCheckable(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

    }


    @Override public void switch2News() {

    }


    @Override public void switch2Pic() {
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.content,
                                           PicFragment.getInstance()).commit();
    }
}
