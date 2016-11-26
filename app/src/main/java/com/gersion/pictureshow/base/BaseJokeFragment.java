package com.gersion.pictureshow.base;

import com.google.gson.Gson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.gersion.pictureshow.dagger2.component.ContextComponent;
import com.gersion.pictureshow.model.bean.DataBean;
import com.gersion.pictureshow.model.bean.JokeBean;
import com.gersion.pictureshow.view.IHomeFragmentView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public abstract class BaseJokeFragment extends BaseFragment implements IHomeFragmentView {

    protected ContextComponent mContextComponent;
    protected boolean mIsLoadMore = false;
    protected boolean mIsRefresh = false;
    protected boolean mIsReady = false;
    protected boolean mIsFirst = true;
    protected boolean mIsLoading = false;
    protected boolean mIsLoaded = false;
    protected int num = 0;
    protected Gson gson = new Gson();
    protected BaseRVAdapter mBaseRVAdapter;
    protected List<DataBean> mData;
    protected XRecyclerView mRvJoke;
    protected JokeBean mJokeBean;

    protected HashMap<String, String> mHashMap;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mData = new ArrayList<>();
        mIsReady = true;
        onLazyLoad();
    }

    protected void initXRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvJoke.setLayoutManager(layoutManager);
        mRvJoke.setLoadingMoreProgressStyle(ProgressStyle.BallTrianglePath);
        mRvJoke.setRefreshProgressStyle(ProgressStyle.BallTrianglePath);
        mRvJoke.setAdapter(mBaseRVAdapter);
    }

    protected void handleData(String result) {
        mData.clear();
        mJokeBean = gson.fromJson(result, JokeBean.class);
        mData.addAll(mJokeBean.result.data);
        if (mIsLoadMore) {
            mBaseRVAdapter.updateData(mData);
        } else {
            mBaseRVAdapter.setData(mData);
        }
        mBaseRVAdapter.notifyDataSetChanged();
    }

    public HashMap<String, String> getMap() {
        if (mHashMap == null) {
            synchronized (BaseJokeFragment.class) {
                if (mHashMap == null) {
                    mHashMap = new HashMap<>();
                }
            }
        } else {
            mHashMap.clear();
        }
        return mHashMap;
    }


    protected void onLazyLoad() {
//        Logger.d("mIsLoading="+mIsLoading+" mIsVisible="+mIsVisible+" mIsReady="+mIsReady+" mIsFirst="+mIsFirst);
        if (mIsLoading) {
            return;
        }
        if (mIsVisible && mIsReady && mIsFirst) {
            mIsFirst = false;
            initData();
        }
    }

    @Override
    public void onRequestSuccess(String result) {
        handleData(result);
    }

    @Override
    protected void onVisible() {
        onLazyLoad();
    }

    @Override
    public boolean isLoadMore() {
        return mIsLoadMore;
    }

    @Override
    public boolean isRefresh() {
        return mIsRefresh;
    }

    @Override
    public void onRequestFailed() {
        showToast("数据请求失败");
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mIsLoadMore = false;
        mIsReady = false;
        mIsRefresh = false;
        mIsLoaded = false;
        mIsFirst = true;
    }
}
