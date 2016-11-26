package com.gersion.pictureshow.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.base
 * @待完成
 * @创建时间 2016/11/24
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {
    private OnItemClickListener mListener;

    public BaseViewHolder(View itemView) {
        this(itemView,null);
    }
    public BaseViewHolder(View itemView,OnItemClickListener listener) {
        super(itemView);
        mListener = listener;
        initView(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mListener!=null) {
            mListener.onItemClick(view, getAdapterPosition()-1);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    protected abstract void initView(View itemView);

    public abstract void setData(T t);
}
