package com.example.zheng.steward.model.exception;

import com.example.zheng.steward.R;
import com.example.zheng.steward.utils.UIUtils;

/**
 * Created by jarvis on 2018/3/22.
 */

public class ServerException extends Exception {
    public ServerException(int errorCode) {
        this(UIUtils.getString(R.string.error_code) + errorCode);
    }

    public ServerException(String message) {
        super(message);
    }
}
