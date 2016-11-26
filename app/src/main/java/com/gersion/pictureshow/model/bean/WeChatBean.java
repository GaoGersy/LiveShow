package com.gersion.pictureshow.model.bean;

import java.util.List;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.model.bean
 * @待完成
 * @创建时间 2016/11/26
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class WeChatBean {

    public String reason;
    public ResultBean result;
    public int error_code;

    public static class ResultBean {
        public int totalPage;
        public int ps;
        public int pno;

        public List<ListBean> list;

        public  class ListBean {
            public String firstImg;
            public String id;
            public String source;
            public String title;
            public String url;
            public String mark;

        }
    }
}
