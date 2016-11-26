package com.gersion.pictureshow.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.gersion.pictureshow.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.base
 * @待完成
 * @创建时间 2016/11/21
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setResourceId());
        initView();
        initEvent();
        initData();
    }

    public void startIntent(Class clazz){
        startActivity(new Intent(this,clazz));
    }

    public void startIntent(Class clazz, Map<String,String> map){
        Intent intent = new Intent(this, clazz);
        if (map!=null){
            for (String key : map.keySet()) {
                intent.putExtra(key,map.get(key));
            }
        }
        startActivity(intent);
    }

    public void startIntent(Class clazz,String name,Bundle bundle){
        Intent intent = new Intent(this, clazz);
        if (name!=null&&bundle!=null) {
            intent.putExtra(name, bundle);
        }
        startActivity(intent);
    }

    protected void initProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在奋力的加载中...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(true);
    }

    protected abstract int setResourceId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();


}
