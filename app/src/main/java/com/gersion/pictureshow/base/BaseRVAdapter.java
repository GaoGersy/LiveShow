package com.gersion.pictureshow.base;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gersion.pictureshow.ui.activity.MainActivity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

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
public abstract class BaseRVAdapter<T> extends RecyclerView.Adapter implements OnItemClickListener {
    protected List<T> mData = new ArrayList<>();
    protected BaseViewHolder mViewHolder;
    private int mPosition;
    protected OnItemClickListener mListener;
    private Context mContext;

    public BaseRVAdapter(List<T> data) {
        if (data != null && data.size()>0){
            mData.addAll(data);
        }
    }

    public void updateData(List<T> data){
        mData.addAll(data);
    }

    public void setData(List<T> data){
        mData = data;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view =  LayoutInflater.from(mContext).inflate(setResourseId(), parent,false);
        mViewHolder = setViewHolder(view);
        mViewHolder.setOnItemClickListener(this);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mPosition = position;
        BaseViewHolder<T> holder1 = (BaseViewHolder<T>) holder;
        holder1.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected abstract BaseViewHolder setViewHolder(View view);

    protected abstract int setResourseId();

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @Override
    public void onItemClick(View view, int position) {
        mListener.onItemClick(view,position);
    }
}
