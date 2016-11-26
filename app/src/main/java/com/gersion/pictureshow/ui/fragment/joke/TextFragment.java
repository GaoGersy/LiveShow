package com.gersion.pictureshow.ui.fragment.joke;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseFragment;
import com.gersion.pictureshow.base.BaseJokeFragment;
import com.gersion.pictureshow.constants.Constants;
import com.gersion.pictureshow.dagger2.component.DaggerContextComponent;
import com.gersion.pictureshow.dagger2.component.DaggerJokeAdapterComponent;
import com.gersion.pictureshow.dagger2.module.ContextModule;
import com.gersion.pictureshow.dagger2.module.JokeAdapterModule;
import com.gersion.pictureshow.model.bean.DataBean;
import com.gersion.pictureshow.model.bean.JokeBean;
import com.gersion.pictureshow.presenter.TextFragmentPresenter;
import com.gersion.pictureshow.ui.adapter.JokeAdapter;
import com.gersion.pictureshow.view.IHomeFragmentView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.fragment
 * @待完成
 * @创建时间 2016/11/21
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class TextFragment extends BaseJokeFragment implements IHomeFragmentView,View.OnClickListener {

    private TextFragmentPresenter mHomePresenter;
    private FloatingActionButton mFabButton;

    @Override
    protected int setResourceId() {
        return R.layout.fragment_text;
    }

    @Override
    protected void initView() {
        mRvJoke = (XRecyclerView) mView.findViewById(R.id.rv_joke);
        mFabButton = (FloatingActionButton) mView.findViewById(R.id.fab_button);
        mBaseRVAdapter = new JokeAdapter(mData);

        initXRecyclerView();
    }

    @Override
    protected void initData() {
        mHomePresenter = new TextFragmentPresenter(this);
        mHomePresenter.requestGet();
    }

    @Override
    protected void initEvent() {
        mRvJoke.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mIsRefresh = true;
                mIsLoadMore = false;
                mHomePresenter.requestGet();
            }

            @Override
            public void onLoadMore() {
                mIsRefresh = false;
                mIsLoadMore = true;
                mHomePresenter.requestGet();
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
        num=0;
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
        mHomePresenter.requestGet();
    }
}
