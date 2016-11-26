package com.gersion.pictureshow.ui.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseActivity;
import com.gersion.pictureshow.ui.fragment.GirlsFragment;
import com.gersion.pictureshow.ui.fragment.WeChatFragment;
import com.gersion.pictureshow.ui.fragment.WeatherFragment;
import com.gersion.pictureshow.ui.fragment.joke.JokeFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBnvMenu;
    private TextView mTvShow;
    private FragmentManager mFragmentManager;
    private Toolbar mToolbar;

    @Override
    protected int setResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    protected void initEvent() {
        mBnvMenu.setOnNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (id) {
            case R.id.girls:
                transaction.replace(R.id.fl_container, new GirlsFragment());
                break;
            case R.id.joke:
                transaction.replace(R.id.fl_container, new JokeFragment());
                break;
            case R.id.wechat:
                transaction.replace(R.id.fl_container, new WeChatFragment());
                break;
            case R.id.weather:
                transaction.replace(R.id.fl_container, new WeatherFragment());
                break;

        }
        transaction.commit();

        return true;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void initView() {
        mBnvMenu = (BottomNavigationView) findViewById(R.id.bnv_menu);
        mTvShow = (TextView) findViewById(R.id.tv_show);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("美女");
        setSupportActionBar(mToolbar);

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fl_container, new GirlsFragment());
        transaction.commit();
    }

    public void setTitle(String title) {
        mToolbar.setTitle(title);
    }
}
