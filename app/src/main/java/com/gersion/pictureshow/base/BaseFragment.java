package com.gersion.pictureshow.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gersion.pictureshow.dagger2.component.ContextComponent;
import com.gersion.pictureshow.ui.activity.MainActivity;
import com.gersion.pictureshow.ui.fragment.GirlsFragment;
import com.gersion.pictureshow.ui.fragment.WeChatFragment;
import com.gersion.pictureshow.ui.fragment.WeatherFragment;
import com.gersion.pictureshow.ui.fragment.joke.JokeFragment;
import com.gersion.pictureshow.ui.fragment.joke.PictureFragment;
import com.gersion.pictureshow.ui.fragment.joke.RandomFragment;

import butterknife.ButterKnife;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.base
 * @待完成
 * @创建时间 2016/11/21
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected Context mContext;
    protected boolean mIsVisible = false;
    protected ContextComponent mContextComponent;
    protected ProgressDialog mProgressDialog;
    private Toast mToast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setResourceId(), null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(mView);
        mContext = getActivity();
//        mContextComponent = DaggerContextComponent.builder().contextModule(new ContextModule(mContext)).build();
        initProgressDialog();
        initView();
        initEvent();
        setToolBarTitle();
    }

    protected void setToolBarTitle() {
        MainActivity activity = (MainActivity) getActivity();
        if (this instanceof JokeFragment) {
            activity.setTitle("搞笑大全");
        } else if (this instanceof PictureFragment) {
            activity.setTitle("搞笑图片");
        } else if (this instanceof RandomFragment) {
            activity.setTitle("随机图片");
        } else if (this instanceof GirlsFragment) {
            activity.setTitle("美女图片");
        } else if (this instanceof WeChatFragment) {
            activity.setTitle("微信精选");
        } else if (this instanceof WeatherFragment) {
            activity.setTitle("天气");
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mIsVisible = true;
            onVisible();

        } else {
            mIsVisible = false;
            onInVisible();
        }
    }

    protected void onInVisible() {

    }

    protected void onVisible() {
    }

    protected void initProgressDialog() {
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setMessage("正在奋力的加载中...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(true);
    }


    protected void showToast(String message) {
        if (mToast == null) {
            mToast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        mToast.show();
    }

    protected abstract int setResourceId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();
}
