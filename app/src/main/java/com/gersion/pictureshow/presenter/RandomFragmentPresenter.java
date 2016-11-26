package com.gersion.pictureshow.presenter;

import com.gersion.pictureshow.base.BaseFragment;
import com.gersion.pictureshow.constants.Constants;
import com.gersion.pictureshow.model.IRequestGetModel;
import com.gersion.pictureshow.model.OnGetDataListener;
import com.gersion.pictureshow.model.RequestGetModel;
import com.gersion.pictureshow.ui.fragment.joke.PictureFragment;
import com.gersion.pictureshow.ui.fragment.joke.RandomFragment;
import com.gersion.pictureshow.view.IHomeFragmentView;
import com.orhanobut.logger.Logger;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.presenter
 * @待完成
 * @创建时间 2016/11/23
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class RandomFragmentPresenter {
    private IRequestGetModel mRequestGetModel = new RequestGetModel();
    private IHomeFragmentView mRandomFragment;
    public RandomFragmentPresenter(RandomFragment randomFragment){
        mRandomFragment = randomFragment;
    }

    public void requestGet(){
        mRandomFragment.showLoading();
        mRequestGetModel.getDataFromNet(Constants.BASE_URL_JOKE_PICTURE_RANDOM, mRandomFragment.getParamas(), new OnGetDataListener() {
            @Override
            public void onSucess(String s) {
                mRandomFragment.hideLoading();
                if(mRandomFragment.isLoadMore()){
                    mRandomFragment.onLoadMore(s);
                }else if (mRandomFragment.isRefresh()){
                    mRandomFragment.onRefresh(s);
                }else{
                    mRandomFragment.onRequestSuccess(s);
                }
            }

            @Override
            public void onFailed() {
                mRandomFragment.hideLoading();
                mRandomFragment.onRequestFailed();
            }
        });
    }
}
