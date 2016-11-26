package com.gersion.pictureshow.ui.viewholder;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gersion.pictureshow.R;
import com.gersion.pictureshow.base.BaseViewHolder;
import com.gersion.pictureshow.model.bean.DataBean;
import com.orhanobut.logger.Logger;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.ui.viewholder
 * @待完成
 * @创建时间 2016/11/24
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class PictureJokeViewHolder extends BaseViewHolder<DataBean> {

    private SimpleDraweeView mSdvImageView;
    private TextView mTvContent;

    public PictureJokeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        mSdvImageView = (SimpleDraweeView) itemView.findViewById(R.id.sdv_image_view);
        mTvContent = (TextView) itemView.findViewById(R.id.content);
    }
    @Override
    public void setData(DataBean dataBean) {
        Uri uri = Uri.parse(dataBean.url);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        mSdvImageView.setAspectRatio(1.33f);
        mSdvImageView.setController(controller);
        mTvContent.setText(dataBean.content);

    }

}
