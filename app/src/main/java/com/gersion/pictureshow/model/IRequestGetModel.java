package com.gersion.pictureshow.model;

import java.util.HashMap;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.model
 * @待完成
 * @创建时间 2016/11/22
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public interface IRequestGetModel {
    void getDataFromNet(String url, HashMap<String,String> paramaters, OnGetDataListener listener);
}
