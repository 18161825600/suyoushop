package com.kxg.suyoushop.consumer.controller;


import com.kxg.suyoushop.consumer.common.ShopJsonResult;
import com.kxg.suyoushop.request.UserRequest.*;
import com.kxg.suyoushop.response.TokenResponse;
import com.kxg.suyoushop.response.UserResponse.*;
import com.kxg.suyoushop.service.UserDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference(version = "1.0.0")
    private UserDubboService userDubboService;

    @PostMapping("login")
    public ShopJsonResult<LoginUserResponse> login(@RequestBody LoginUserRequest request){
        return ShopJsonResult.ok(userDubboService.login(request));
    }

    @PostMapping("login/sms")
    public ShopJsonResult<LoginUserResponse> loginBySms(@RequestBody LoginUserBySmsRequest request){
        return ShopJsonResult.ok(userDubboService.loginBySms(request));
    }

//    UpdateUserImgResponse updateUserImg(UpdateUserImgRequest request);
//
//    UpdateUserPasswordByPhoneResponse updateUserPasswordByPhone(UpdateUserPasswordByPhoneRequest request);
//
//    UpdateUserPasswordByIdResponse updateUserPasswordById(UpdateUserPasswordByIdRequest request);
//
//    UpdateUserNickNameResponse updateUserNickName(UpdateUserNickNameRequest request);
//
//    InvestMoneyResponse investMoney(InvestMoneyRequest request);
//
//    FindUserByIdResponse findUserById(FindUserByIdRequest request);
//
//    DeleteUserResponse deleteUser(DeleteUserRequest request);
//
//    FindAllUserResponse findAllUser(FindAllUserRequest request);

}
