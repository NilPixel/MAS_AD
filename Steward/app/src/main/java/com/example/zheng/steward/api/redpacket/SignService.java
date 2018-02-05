package com.example.zheng.steward.api.redpacket;

import com.example.zheng.steward.model.redpacket.SignModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zheng on 2018/2/5.
 */

public interface SignService {
    @GET("api/demo-sign/")
    Call<SignModel> getSignInfo(@Query("uid") String userId, @Query("token") String token);
}
