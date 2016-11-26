package com.gersion.pictureshow.utils;

import com.orhanobut.logger.Logger;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.gersion.pictureshow.utils
 * @待完成
 * @创建时间 2016/11/23
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class StringUtils {
    public static String reSetString(String content){
        String result = content.replaceAll("\\s{2,}", "\n");
        return result;
    }
}
