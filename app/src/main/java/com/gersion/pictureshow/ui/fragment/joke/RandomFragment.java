package com.gersion.pictureshow.ui.fragment.joke;

import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseFragment;
import com.gersion.pictureshow.base.BaseJokeFragment;
import com.gersion.pictureshow.constants.Constants;
import com.gersion.pictureshow.model.bean.JokeBean;
import com.gersion.pictureshow.model.bean.RandomBean;
import com.gersion.pictureshow.presenter.RandomFragmentPresenter;
import com.gersion.pictureshow.presenter.TextFragmentPresenter;
import com.gersion.pictureshow.ui.adapter.JokeAdapter;
import com.gersion.pictureshow.ui.adapter.PictureJokeAdapter;
import com.gersion.pictureshow.ui.adapter.RandomJokeAdapter;
import com.gersion.pictureshow.view.IHomeFragmentView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.fragment.joke
 * @待完成
 * @创建时间 2016/11/23
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class RandomFragment extends BaseJokeFragment implements IHomeFragmentView{
    RandomFragmentPresenter mRandomFragmentPresenter = new RandomFragmentPresenter(this);
    private List<RandomBean.ResultBean> mDatas = new ArrayList<>();
    private RandomBean mRandomBean;

    @Override
    protected int setResourceId() {
        return R.layout.fragment_random;
    }

    @Override
    protected void initView() {
        mRvJoke = (XRecyclerView) mView.findViewById(R.id.rv_joke);
        mBaseRVAdapter = new RandomJokeAdapter(mDatas);
        initXRecyclerView();
    }

    @Override
    protected void initData() {
        mRandomFragmentPresenter = new RandomFragmentPresenter(this);
        mRandomFragmentPresenter.requestGet();
    }

    @Override
    protected void initEvent() {
        mRvJoke.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mIsRefresh = true;
                mIsLoadMore = false;
                mRandomFragmentPresenter.requestGet();
            }

            @Override
            public void onLoadMore() {
                mIsRefresh = false;
                mIsLoadMore = true;
                mRandomFragmentPresenter.requestGet();
            }
        });

    }

    protected void handleData(String result) {
        mDatas.clear();
        mRandomBean = gson.fromJson(result, RandomBean.class);
        mDatas.addAll(mRandomBean.result);
        if (mIsLoadMore){
            mBaseRVAdapter.updateData(mDatas);
        }else {
            mBaseRVAdapter.setData(mDatas);
        }
        mBaseRVAdapter.notifyDataSetChanged();
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
        mDatas.clear();
        handleData(result);
    }

    @Override
    public HashMap<String, String> getParamas() {
        if (mIsLoadMore) {
            num++;
        }
        HashMap<String, String> map = getMap();
        map.put("key", Constants.APPKEY_JOKE);
        map.put("type", "pic");
        return map;
    }

}
