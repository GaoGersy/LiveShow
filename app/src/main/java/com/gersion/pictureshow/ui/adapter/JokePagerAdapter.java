package com.gersion.pictureshow.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.gersion.pictureshow.ui.factory.JokeFragmentFactory;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.adapter
 * @待完成
 * @创建时间 2016/11/23
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class JokePagerAdapter extends FragmentStatePagerAdapter {

    public JokePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = JokeFragmentFactory.getFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String titile = null;
        switch (position){
            case 0:
                titile = "搞笑图片";
                break;
            case 1:
                titile = "精品笑话";
                break;
            case 2:
                titile = "随机一下";
                break;
        }
        return titile;
    }
}
