package me.appa.geekly.utils;

import me.appa.geekly.APP;

/**
 * Created by niuxm on 2016/3/17.
 */
public class MeasureUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     * @param dpValue
     * @return
     */
    public static int dp2px(float dpValue) {
        float scale = APP.getContext()
                           .getResources()
                           .getDisplayMetrics().density;

        return (int) (dpValue*scale+0.5f);
    }
}
