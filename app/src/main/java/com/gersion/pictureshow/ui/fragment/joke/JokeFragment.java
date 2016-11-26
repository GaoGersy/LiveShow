package com.gersion.pictureshow.ui.fragment.joke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseFragment;
import com.gersion.pictureshow.ui.adapter.JokePagerAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.fragment
 * @待完成
 * @创建时间 2016/11/23
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class JokeFragment extends BaseFragment {
    private SmartTabLayout mViewpagertab;
    private ViewPager mVpJoke;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;

    @Override
    protected int setResourceId() {
        return R.layout.fragment_joke;
    }

    @Override
    protected void initView() {
//        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) mView.findViewById(
//                R.id.collapse_toolbar);
//        collapsingToolbar.setTitleEnabled(false);
//        appBarLayout = (AppBarLayout) mView.findViewById(R.id.appBarLayout);
//        appBarLayout.addOnOffsetChangedListener(this);
//
//        toolbar = (Toolbar) mView.findViewById(R.id.toolbar);
//
//        //set the toolbar
//        int toolbar_hight = 100;
//        CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) toolbar.getLayoutParams();
//        params.height = toolbar_hight;
//        toolbar.setLayoutParams(params);

        mViewpagertab = (SmartTabLayout) mView.findViewById(R.id.viewpagertab);
        mVpJoke = (ViewPager) mView.findViewById(R.id.vp_joke);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        JokePagerAdapter adapter = new JokePagerAdapter(getChildFragmentManager());
        mVpJoke.setAdapter(adapter);
        mViewpagertab.setViewPager(mVpJoke);
    }


//    @Override
//    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//        float alpha = (float) Math.abs(verticalOffset) / (float) appBarLayout.getTotalScrollRange() * 1.0f;
//        toolbar.setAlpha(alpha);
//    }
}
