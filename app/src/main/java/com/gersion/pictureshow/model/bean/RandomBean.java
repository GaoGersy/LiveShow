package com.gersion.pictureshow.model.bean;

import java.util.List;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.model.bean
 * @待完成
 * @创建时间 2016/11/25
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class RandomBean {

    public String reason;
    public int error_code;

    public List<ResultBean> result;

    public class ResultBean {
        public String content;
        public String hashId;
        public String unixtime;
        public String url;

    }
}
