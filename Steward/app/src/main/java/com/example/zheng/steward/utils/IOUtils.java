package com.example.zheng.steward.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by zheng on 2018/2/5.
 */

public class IOUtils {
    /**
     * 关闭流
     */
    public static boolean close(Closeable io) {
        if (io != null) {
            try {
                io.close();
            } catch (IOException e) {
                LogUtils.e(e);
            }
        }
        return true;
    }
}
