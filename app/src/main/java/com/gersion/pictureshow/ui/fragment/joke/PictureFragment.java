package com.gersion.pictureshow.ui.fragment.joke;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseJokeFragment;
import com.gersion.pictureshow.constants.Constants;
import com.gersion.pictureshow.model.bean.DataBean;
import com.gersion.pictureshow.model.bean.JokeBean;
import com.gersion.pictureshow.presenter.PictureFragmentPresenter;
import com.gersion.pictureshow.ui.adapter.PictureJokeAdapter;
import com.gersion.pictureshow.view.IHomeFragmentView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
public class PictureFragment extends BaseJokeFragment implements IHomeFragmentView, View.OnClickListener {
    private PictureFragmentPresenter mPictureFragmentPresenter;
    private FloatingActionButton mFabButton;

    @Override
    protected int setResourceId() {
        return R.layout.fragment_picture;
    }

    @Override
    protected void initView() {
        mRvJoke = (XRecyclerView) mView.findViewById(R.id.rv_joke);
        mFabButton = (FloatingActionButton) mView.findViewById(R.id.fab_button);
        mBaseRVAdapter = new PictureJokeAdapter(mData);
        initXRecyclerView();
    }

    @Override
    protected void initData() {
        mPictureFragmentPresenter = new PictureFragmentPresenter(this);
        mPictureFragmentPresenter.requestGet();
    }

    @Override
    protected void initEvent() {
        mRvJoke.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mIsRefresh = true;
                mIsLoadMore = false;
                mPictureFragmentPresenter.requestGet();
            }

            @Override
            public void onLoadMore() {
                mIsLoadMore = true;
                mIsRefresh = false;
                mPictureFragmentPresenter.requestGet();
            }
        });

        mFabButton.setOnClickListener(this);
    }

    @Override
    public void onLoadMore(String result) {
        mRvJoke.loadMoreComplete();
        handleData(result);
    }

    @Override
    public void onRefresh(String result) {
        num = 0;
        mRvJoke.refreshComplete();
        mData.clear();
        handleData(result);
    }


    @Override
    public HashMap<String, String> getParamas() {
        if (mIsLoadMore) {
            num++;
        }
        HashMap<String, String> map = getMap();
        map.put("key", Constants.APPKEY_JOKE);
        map.put("page", num + "");
        map.put("pagesize", "20");
        return map;
    }

    @Override
    public void onClick(View view) {
        Random random = new Random();
        num = random.nextInt(1000);
        mPictureFragmentPresenter.requestGet();
    }
}
