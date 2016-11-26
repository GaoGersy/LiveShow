package com.gersion.pictureshow.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseFragment;
import com.gersion.pictureshow.base.BaseJokeFragment;
import com.gersion.pictureshow.base.BaseRVAdapter;
import com.gersion.pictureshow.base.OnItemClickListener;
import com.gersion.pictureshow.constants.Constants;
import com.gersion.pictureshow.model.bean.RandomBean;
import com.gersion.pictureshow.model.bean.WeChatBean;
import com.gersion.pictureshow.presenter.WeChatFragmentPresenter;
import com.gersion.pictureshow.ui.activity.MainActivity;
import com.gersion.pictureshow.ui.activity.WeChatActivity;
import com.gersion.pictureshow.ui.adapter.WeChatAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.orhanobut.logger.Logger;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public class WeChatFragment extends BaseJokeFragment implements OnItemClickListener {

    private List<WeChatBean.ResultBean.ListBean> mDatas = new ArrayList<>();
    private WeChatFragmentPresenter mWeChatFragmentPresenter;
    private WeChatBean mWeChatBean;

    @Override
    protected int setResourceId() {
        return R.layout.fragment_wechat;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    protected void initView() {
        mRvJoke = (XRecyclerView) mView.findViewById(R.id.xRecyclerView);

        mBaseRVAdapter = new WeChatAdapter(mDatas);

        initXRecyclerView();
    }

    @Override
    protected void initData() {
        mWeChatFragmentPresenter = new WeChatFragmentPresenter(this);
        mWeChatFragmentPresenter.requestGet();
    }

    @Override
    protected void initEvent() {
        mRvJoke.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mIsRefresh = true;
                mIsLoadMore = false;
                mWeChatFragmentPresenter.requestGet();
            }

            @Override
            public void onLoadMore() {
                mIsLoadMore = true;
                mIsRefresh = false;
                mWeChatFragmentPresenter.requestGet();
            }
        });
        mBaseRVAdapter.setOnItemClickListener(this);
    }

    protected void handleData(String result) {
        mDatas.clear();
        mWeChatBean = gson.fromJson(result, WeChatBean.class);
        mDatas.addAll(mWeChatBean.result.list);
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
        map.put("key", Constants.APPKEY_WEIXIN);
        map.put("pno",num+"");
        return map;
    }

    @Override
    public void onItemClick(View view,int position) {
        Intent intent = new Intent(getActivity(), WeChatActivity.class);
        intent.putExtra("url",mDatas.get(position).url);
        startActivity(intent);
    }
}
