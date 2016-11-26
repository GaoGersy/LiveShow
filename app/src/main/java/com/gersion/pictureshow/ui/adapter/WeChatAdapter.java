package com.gersion.pictureshow.ui.adapter;

import android.view.View;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseRVAdapter;
import com.gersion.pictureshow.base.BaseViewHolder;
import com.gersion.pictureshow.model.bean.WeChatBean;
import com.gersion.pictureshow.ui.viewholder.WeChatViewHolder;

import java.util.List;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.adapter
 * @待完成
 * @创建时间 2016/11/26
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class WeChatAdapter extends BaseRVAdapter<WeChatBean.ResultBean.ListBean>{
    public WeChatAdapter(List<WeChatBean.ResultBean.ListBean> data) {
        super(data);
    }

    @Override
    protected BaseViewHolder setViewHolder(View view) {
        return new WeChatViewHolder(view);
    }

    @Override
    protected int setResourseId() {
        return R.layout.item_wechat;
    }
}
