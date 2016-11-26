package com.gersion.pictureshow.presenter;

import com.gersion.pictureshow.constants.Constants;
import com.gersion.pictureshow.model.IRequestGetModel;
import com.gersion.pictureshow.model.OnGetDataListener;
import com.gersion.pictureshow.model.RequestGetModel;
import com.gersion.pictureshow.ui.fragment.joke.PictureFragment;
import com.gersion.pictureshow.ui.fragment.joke.TextFragment;
import com.gersion.pictureshow.view.IHomeFragmentView;

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
public class PictureFragmentPresenter {
    private IRequestGetModel mRequestGetModel = new RequestGetModel();
    private IHomeFragmentView mHomeFragmentView;
    public PictureFragmentPresenter(PictureFragment pictureFragment){
        mHomeFragmentView = pictureFragment;
    }

    public void requestGet(){
        mHomeFragmentView.showLoading();
        mRequestGetModel.getDataFromNet(Constants.BASE_URL_JOKE_PICTURE, mHomeFragmentView.getParamas(), new OnGetDataListener() {
            @Override
            public void onSucess(String s) {
                mHomeFragmentView.hideLoading();
                if(mHomeFragmentView.isLoadMore()){
                    mHomeFragmentView.onLoadMore(s);
                }else if (mHomeFragmentView.isRefresh()){
                    mHomeFragmentView.onRefresh(s);
                }else{
                    mHomeFragmentView.onRequestSuccess(s);
                }
            }

            @Override
            public void onFailed() {
                mHomeFragmentView.hideLoading();
                mHomeFragmentView.onRequestFailed();
            }
        });
    }
}
