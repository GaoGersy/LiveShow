package com.gersion.pictureshow.ui.adapter;

import android.view.View;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseRVAdapter;
import com.gersion.pictureshow.base.BaseViewHolder;
import com.gersion.pictureshow.model.bean.DataBean;
import com.gersion.pictureshow.model.bean.JokeBean;
import com.gersion.pictureshow.model.bean.RandomBean;
import com.gersion.pictureshow.ui.viewholder.PictureJokeViewHolder;
import com.gersion.pictureshow.ui.viewholder.RandomJokeViewHolder;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.adapter
 * @待完成
 * @创建时间 2016/11/24
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class RandomJokeAdapter extends BaseRVAdapter<RandomBean.ResultBean> {

    public RandomJokeAdapter(List<RandomBean.ResultBean> data) {
        super(data);
    }

    @Override
    protected BaseViewHolder setViewHolder(View view) {
        return new RandomJokeViewHolder(view);
    }

    @Override
    protected int setResourseId() {
        return R.layout.item_picture_joke;
    }
}
