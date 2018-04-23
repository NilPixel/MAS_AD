package com.example.zheng.steward.api;

import com.example.zheng.steward.api.base.BaseApiRetrofit;
import com.example.zheng.steward.api.base.MyApi;
import com.example.zheng.steward.model.request.AddGroupMemberRequest;
import com.example.zheng.steward.model.request.AddToBlackListRequest;
import com.example.zheng.steward.model.request.AgreeFriendsRequest;
import com.example.zheng.steward.model.request.ChangePasswordRequest;
import com.example.zheng.steward.model.request.CreateGroupRequest;
import com.example.zheng.steward.model.request.DeleteFriendRequest;
import com.example.zheng.steward.model.request.DeleteGroupMemberRequest;
import com.example.zheng.steward.model.request.DismissGroupRequest;
import com.example.zheng.steward.model.request.FriendInvitationRequest;
import com.example.zheng.steward.model.request.JoinGroupRequest;
import com.example.zheng.steward.model.request.LoginRequest;
import com.example.zheng.steward.model.request.OrderManagerListRequest;
import com.example.zheng.steward.model.request.QuitGroupRequest;
import com.example.zheng.steward.model.request.RegisterRequest;
import com.example.zheng.steward.model.request.RemoveFromBlacklistRequest;
import com.example.zheng.steward.model.request.RestPasswordRequest;
import com.example.zheng.steward.model.request.SendCodeRequest;
import com.example.zheng.steward.model.request.SetFriendDisplayNameRequest;
import com.example.zheng.steward.model.request.SetGroupDisplayNameRequest;
import com.example.zheng.steward.model.request.SetGroupNameRequest;
import com.example.zheng.steward.model.request.SetGroupPortraitRequest;
import com.example.zheng.steward.model.request.SetNameRequest;
import com.example.zheng.steward.model.request.SetPortraitRequest;
import com.example.zheng.steward.model.request.VerifyCodeRequest;
import com.example.zheng.steward.model.response.AddGroupMemberResponse;
import com.example.zheng.steward.model.response.AddToBlackListResponse;
import com.example.zheng.steward.model.response.AgreeFriendsResponse;
import com.example.zheng.steward.model.response.ChangePasswordResponse;
import com.example.zheng.steward.model.response.CreateGroupResponse;
import com.example.zheng.steward.model.response.DefaultConversationResponse;
import com.example.zheng.steward.model.response.DeleteFriendResponse;
import com.example.zheng.steward.model.response.DeleteGroupMemberResponse;
import com.example.zheng.steward.model.response.FriendInvitationResponse;
import com.example.zheng.steward.model.response.GetBlackListResponse;
import com.example.zheng.steward.model.response.GetFriendInfoByIDResponse;
import com.example.zheng.steward.model.response.GetGroupInfoResponse;
import com.example.zheng.steward.model.response.GetGroupMemberResponse;
import com.example.zheng.steward.model.response.GetGroupResponse;
import com.example.zheng.steward.model.response.GetTokenResponse;
import com.example.zheng.steward.model.response.GetUserInfoByIdResponse;
import com.example.zheng.steward.model.response.GetUserInfoByPhoneResponse;
import com.example.zheng.steward.model.response.GetUserInfosResponse;
import com.example.zheng.steward.model.response.HomeDataResponse;
import com.example.zheng.steward.model.response.JoinGroupResponse;
import com.example.zheng.steward.model.response.LoginResponse;
import com.example.zheng.steward.model.response.OrderManagerListResponse;
import com.example.zheng.steward.model.response.QRCodeResponse;
import com.example.zheng.steward.model.response.QiNiuTokenResponse;
import com.example.zheng.steward.model.response.QuitGroupResponse;
import com.example.zheng.steward.model.response.RegisterResponse;
import com.example.zheng.steward.model.response.RemoveFromBlackListResponse;
import com.example.zheng.steward.model.response.RestPasswordResponse;
import com.example.zheng.steward.model.response.SendCodeResponse;
import com.example.zheng.steward.model.response.SetFriendDisplayNameResponse;
import com.example.zheng.steward.model.response.SetGroupDisplayNameResponse;
import com.example.zheng.steward.model.response.SetGroupNameResponse;
import com.example.zheng.steward.model.response.SetGroupPortraitResponse;
import com.example.zheng.steward.model.response.SetNameResponse;
import com.example.zheng.steward.model.response.SetPortraitResponse;
import com.example.zheng.steward.model.response.SyncTotalDataResponse;
import com.example.zheng.steward.model.response.UserRelationshipResponse;
import com.example.zheng.steward.model.response.VerifyCodeResponse;
import com.example.zheng.steward.model.response.VersionResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by zheng on 2018/2/2.
 */

public class ApiRetrofit extends BaseApiRetrofit {

    public MyApi mApi;
    public static ApiRetrofit mInstance;

    private ApiRetrofit() {
        super();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //在构造方法中完成对Retrofit接口的初始化
        mApi = new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(MyApi.class);
    }

    public static ApiRetrofit getInstance() {
        if (mInstance == null) {
            synchronized (ApiRetrofit.class) {
                if (mInstance == null) {
                    mInstance = new ApiRetrofit();
                }
            }
        }
        return mInstance;
    }

    private RequestBody getRequestBody(Object obj) {
        String route = new Gson().toJson(obj);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route);
        return body;
    }

    //登录
    public Observable<LoginResponse> login(String userName, String password, Boolean encrypt) {
        return mApi.login(getRequestBody(new LoginRequest(userName, password, encrypt)));
    }

    //获取首页数据
    public Observable<HomeDataResponse> getHomeData() {
        return mApi.getHomeData();
    }

    //获取二维码字符串
    public Observable<QRCodeResponse> getQRCodeString() {
        return mApi.getQRCodeString();
    }

    //获取订单列表
    public Observable<OrderManagerListResponse> getOrderListData(Integer page, Integer pageLength, String sortMethod, String param, String sellerNo, String store, String applyStatus) {
        return mApi.getOrderListData(getRequestBody(new OrderManagerListRequest(page, pageLength, sortMethod, param, sellerNo, store, applyStatus)));
    }

    public Observable<SendCodeResponse> sendCode(String region, String phone) {
        return mApi.sendCode(getRequestBody(new SendCodeRequest(region, phone)));
    }

    public Observable<VerifyCodeResponse> verifyCode(String region, String phone, String code) {
        return mApi.verifyCode(getRequestBody(new VerifyCodeRequest(region, phone, code)));
    }

    public Observable<RegisterResponse> register(String nickname, String password, String verification_token) {
        return mApi.register(getRequestBody(new RegisterRequest(nickname, password, verification_token)));
    }

    public Observable<GetTokenResponse> getToken() {
        return mApi.getToken();
    }

    //个人信息
    public Observable<SetNameResponse> setName(String nickName) {
        return mApi.setName(getRequestBody(new SetNameRequest(nickName)));
    }

    public Observable<SetPortraitResponse> setPortrait(String portraitUri) {
        return mApi.setPortrait(getRequestBody(new SetPortraitRequest(portraitUri)));
    }

    public Observable<ChangePasswordResponse> changePassword(String oldPassword, String newPassword) {
        return mApi.changePassword(getRequestBody(new ChangePasswordRequest(oldPassword, newPassword)));
    }

    /**
     * @param password           密码，6 到 20 个字节，不能包含空格
     * @param verification_token 调用 /user/verify_code 成功后返回的 activation_token
     */
    public Observable<RestPasswordResponse> restPassword(String password, String verification_token) {
        return mApi.restPassword(getRequestBody(new RestPasswordRequest(password, verification_token)));
    }

    //查询
    public Observable<GetUserInfoByIdResponse> getUserInfoById(String userid) {
        return mApi.getUserInfoById(userid);
    }

    public Observable<GetUserInfoByPhoneResponse> getUserInfoFromPhone(String region, String phone) {
        return mApi.getUserInfoFromPhone(region, phone);
    }

    //好友
    public Observable<FriendInvitationResponse> sendFriendInvitation(String userid, String addFriendMessage) {
        return mApi.sendFriendInvitation(getRequestBody(new FriendInvitationRequest(userid, addFriendMessage)));
    }

    public Observable<UserRelationshipResponse> getAllUserRelationship() {
        return mApi.getAllUserRelationship();
    }

    public Observable<GetFriendInfoByIDResponse> getFriendInfoByID(String userid) {
        return mApi.getFriendInfoByID(userid);
    }

    public Observable<AgreeFriendsResponse> agreeFriends(String friendId) {
        return mApi.agreeFriends(getRequestBody(new AgreeFriendsRequest(friendId)));
    }

    public Observable<DeleteFriendResponse> deleteFriend(String friendId) {
        return mApi.deleteFriend(getRequestBody(new DeleteFriendRequest(friendId)));
    }

    public Observable<SetFriendDisplayNameResponse> setFriendDisplayName(String friendId, String displayName) {
        return mApi.setFriendDisplayName(getRequestBody(new SetFriendDisplayNameRequest(friendId, displayName)));
    }

    public Observable<GetBlackListResponse> getBlackList() {
        return mApi.getBlackList();
    }

    public Observable<AddToBlackListResponse> addToBlackList(String friendId) {
        return mApi.addToBlackList(getRequestBody(new AddToBlackListRequest(friendId)));
    }

    public Observable<RemoveFromBlackListResponse> removeFromBlackList(String friendId) {
        return mApi.removeFromBlackList(getRequestBody(new RemoveFromBlacklistRequest(friendId)));
    }


    //群组
    public Observable<CreateGroupResponse> createGroup(String name, List<String> memberIds) {
        return mApi.createGroup(getRequestBody(new CreateGroupRequest(name, memberIds)));
    }

    public Observable<SetGroupPortraitResponse> setGroupPortrait(String groupId, String portraitUri) {
        return mApi.setGroupPortrait(getRequestBody(new SetGroupPortraitRequest(groupId, portraitUri)));
    }

    public Observable<GetGroupResponse> getGroups() {
        return mApi.getGroups();
    }

    public Observable<GetGroupInfoResponse> getGroupInfo(String groupId) {
        return mApi.getGroupInfo(groupId);
    }

    public Observable<GetGroupMemberResponse> getGroupMember(String groupId) {
        return mApi.getGroupMember(groupId);
    }

    public Observable<AddGroupMemberResponse> addGroupMember(String groupId, List<String> memberIds) {
        return mApi.addGroupMember(getRequestBody(new AddGroupMemberRequest(groupId, memberIds)));
    }

    public Observable<DeleteGroupMemberResponse> deleGroupMember(String groupId, List<String> memberIds) {
        return mApi.deleGroupMember(getRequestBody(new DeleteGroupMemberRequest(groupId, memberIds)));
    }

    public Observable<SetGroupNameResponse> setGroupName(String groupId, String name) {
        return mApi.setGroupName(getRequestBody(new SetGroupNameRequest(groupId, name)));
    }

    public Observable<QuitGroupResponse> quitGroup(String groupId) {
        return mApi.quitGroup(getRequestBody(new QuitGroupRequest(groupId)));
    }

    public Observable<QuitGroupResponse> dissmissGroup(String groupId) {
        return mApi.dissmissGroup(getRequestBody(new DismissGroupRequest(groupId)));
    }
//    public Observable<DismissGroupResponse> dissmissGroup(String groupId) {
//        return mApi.dissmissGroup(getRequestBody(new DismissGroupRequest(groupId)));
//    }

    public Observable<SetGroupDisplayNameResponse> setGroupDisplayName(String groupId, String displayName) {
        return mApi.setGroupDisplayName(getRequestBody(new SetGroupDisplayNameRequest(groupId, displayName)));
    }

    public Observable<JoinGroupResponse> JoinGroup(String groupId) {
        return mApi.JoinGroup(getRequestBody(new JoinGroupRequest(groupId)));
    }

    public Observable<DefaultConversationResponse> getDefaultConversation() {
        return mApi.getDefaultConversation();
    }

    public Observable<GetUserInfosResponse> getUserInfos(List<String> ids) {
        StringBuilder sb = new StringBuilder();
        for (String s : ids) {
            sb.append("id=");
            sb.append(s);
            sb.append("&");
        }
        String stringRequest = sb.substring(0, sb.length() - 1);
        return mApi.getUserInfos(stringRequest);
    }

    //其他
    public Observable<QiNiuTokenResponse> getQiNiuToken() {
        return mApi.getQiNiuToken();
    }

    public Observable<VersionResponse> getClientVersion() {
        return mApi.getClientVersion();
    }

    public Observable<SyncTotalDataResponse> syncTotalData(String version) {
        return mApi.syncTotalData(version);
    }
}
