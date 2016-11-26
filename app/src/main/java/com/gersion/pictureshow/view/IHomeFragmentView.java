package com.gersion.pictureshow.view;

import java.util.HashMap;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.view
 * @待完成
 * @创建时间 2016/11/22
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public interface IHomeFragmentView {
    void onRequestSuccess(String result);
    void onRequestFailed();
    void showLoading();
    void hideLoading();
    void onLoadMore(String result);
    void onRefresh(String result);
    HashMap<String,String> getParamas();
    boolean isLoadMore();
    boolean isRefresh();
}
