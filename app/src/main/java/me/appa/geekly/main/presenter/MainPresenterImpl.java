package me.appa.geekly.main.presenter;

import me.appa.geekly.R;
import me.appa.geekly.main.view.MainView;

/**
 * Created by niuxm on 2016/3/16.
 */
public class MainPresenterImpl implements MainPresenter {

    MainView mMainView;


    public MainPresenterImpl(MainView mainView) {
        mMainView = mainView;
    }


    @Override public void switchNavigation(int id) {
        switch (id) {
            case R.id.menu_news:
                mMainView.switch2News();
                break;
            case R.id.menu_pic:
                mMainView.switch2Pic();
                break;
            default:
                mMainView.switch2Pic();
                break;
        }
    }
}
