package com.gersion.pictureshow.ui.factory;

import android.support.v4.app.Fragment;

import com.gersion.pictureshow.ui.fragment.joke.PictureFragment;
import com.gersion.pictureshow.ui.fragment.joke.RandomFragment;
import com.gersion.pictureshow.ui.fragment.joke.TextFragment;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.factory
 * @待完成
 * @创建时间 2016/11/23
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class JokeFragmentFactory {
    static TextFragment mTextFragment;
    static PictureFragment mPictureFragment ;
    static RandomFragment mRandomFragment ;
    static Fragment mFragment;
    public static Fragment getFragment(int position){
        switch (position){
            case 0:
                mFragment =  getPictureFragment();
                break;
            case 1:
                mFragment = getTextFragment();
            break;
            case 2:
                mFragment =  getRandomFragment();
            break;
        }
        return mFragment;
    }

    private static TextFragment getTextFragment(){
        if (mTextFragment == null){
            synchronized (JokeFragmentFactory.class){
                if (mTextFragment == null){
                    mTextFragment = new TextFragment();
                }
            }
        }
        return mTextFragment;
    }

    private static RandomFragment getRandomFragment(){
        if (mRandomFragment == null){
            synchronized (JokeFragmentFactory.class){
                if (mRandomFragment == null){
                    mRandomFragment = new RandomFragment();
                }
            }
        }
        return mRandomFragment;
    }

    private static PictureFragment getPictureFragment(){
        if (mPictureFragment == null){
            synchronized (JokeFragmentFactory.class){
                if (mPictureFragment == null){
                    mPictureFragment = new PictureFragment();
                }
            }
        }
        return mPictureFragment;
    }
}
