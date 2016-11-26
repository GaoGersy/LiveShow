package com.gersion.pictureshow.ui.adapter;

import android.content.Context;
import android.view.View;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseRVAdapter;
import com.gersion.pictureshow.base.BaseViewHolder;
import com.gersion.pictureshow.model.bean.DataBean;
import com.gersion.pictureshow.ui.viewholder.JokeViewHolder;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.adapter
 * @待完成
 * @创建时间 2016/11/22
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class JokeAdapter extends BaseRVAdapter<DataBean> {

    public JokeAdapter(List<DataBean> data) {
        super(data);
    }

    @Override
    protected BaseViewHolder setViewHolder(View view) {
        return new JokeViewHolder(view);
    }

    @Override
    protected int setResourseId() {
        return R.layout.item_joke;
    }

}
