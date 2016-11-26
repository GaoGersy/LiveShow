package com.gersion.pictureshow.ui.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseViewHolder;
import com.gersion.pictureshow.model.bean.DataBean;
import com.gersion.pictureshow.model.bean.JokeBean;
import com.gersion.pictureshow.utils.StringUtils;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow
 * @待完成
 * @创建时间 2016/11/22
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class JokeViewHolder extends BaseViewHolder<DataBean> {

    private TextView mContent;
    private TextView mTime;

    public JokeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        mContent = (TextView) itemView.findViewById(R.id.tv_content);
        mTime = (TextView) itemView.findViewById(R.id.tv_time);

    }

    @Override
    public void setData(DataBean dataBean){
        mContent.setText(StringUtils.reSetString(dataBean.content));
        mTime.setText(dataBean.updatetime);
    }


}
