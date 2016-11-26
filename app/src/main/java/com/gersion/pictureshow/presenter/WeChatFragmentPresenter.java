package com.gersion.pictureshow.presenter;

import com.gersion.pictureshow.constants.Constants;
import com.gersion.pictureshow.model.IRequestGetModel;
import com.gersion.pictureshow.model.OnGetDataListener;
import com.gersion.pictureshow.model.RequestGetModel;
import com.gersion.pictureshow.ui.fragment.WeChatFragment;
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
public class WeChatFragmentPresenter {
    private IRequestGetModel mRequestGetModel = new RequestGetModel();
    private IHomeFragmentView mWeChatFragment;
    public WeChatFragmentPresenter(WeChatFragment weChatFragment){
        mWeChatFragment = weChatFragment;
    }

    public void requestGet(){
        mWeChatFragment.showLoading();
        mRequestGetModel.getDataFromNet(Constants.BASE_URL_WEIXIN, mWeChatFragment.getParamas(), new OnGetDataListener() {
            @Override
            public void onSucess(String s) {
                mWeChatFragment.hideLoading();
                if(mWeChatFragment.isLoadMore()){
                    mWeChatFragment.onLoadMore(s);
                }else if (mWeChatFragment.isRefresh()){
                    mWeChatFragment.onRefresh(s);
                }else{
                    mWeChatFragment.onRequestSuccess(s);
                }
            }

            @Override
            public void onFailed() {
                mWeChatFragment.hideLoading();
                mWeChatFragment.onRequestFailed();
            }
        });
    }
}
