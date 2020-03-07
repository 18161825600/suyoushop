package com.kxg.suyoushop.consumer.controller;


import com.kxg.suyoushop.consumer.common.ShopJsonResult;
import com.kxg.suyoushop.request.TokenRequest;
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

    @PostMapping("register")
    public ShopJsonResult<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ShopJsonResult.ok(userDubboService.register(request));
    }

    @PostMapping("login")
    public ShopJsonResult<LoginUserResponse> login(@RequestBody LoginUserRequest request){
        return ShopJsonResult.ok(userDubboService.login(request));
    }

    @PostMapping("login/sms")
    public ShopJsonResult<LoginUserResponse> loginBySms(@RequestBody LoginUserBySmsRequest request){
        return ShopJsonResult.ok(userDubboService.loginBySms(request));
    }

    @PostMapping("update/user/img")
    public ShopJsonResult<UpdateUserImgResponse> updateUserImg(@RequestBody UpdateUserImgRequest request){
        return ShopJsonResult.ok(userDubboService.updateUserImg(request));
    }

    @PostMapping("update/user/password/by/phone")
    public ShopJsonResult<UpdateUserPasswordByPhoneResponse> updateUserPasswordByPhone(@RequestBody UpdateUserPasswordByPhoneRequest request){
        return ShopJsonResult.ok(userDubboService.updateUserPasswordByPhone(request));
    }

    @PostMapping("update/user/password/by/id")
    public ShopJsonResult<UpdateUserPasswordByIdResponse> updateUserPasswordById(@RequestBody UpdateUserPasswordByIdRequest request){
        return ShopJsonResult.ok(userDubboService.updateUserPasswordById(request));
    }

    @PostMapping("update/user/nickName")
    public ShopJsonResult<UpdateUserNickNameResponse> updateUserNickName(@RequestBody UpdateUserNickNameRequest request){
        return ShopJsonResult.ok(userDubboService.updateUserNickName(request));
    }

    @PostMapping("invest/money")
    public ShopJsonResult<InvestMoneyResponse> investMoney(@RequestBody InvestMoneyRequest request){
        return ShopJsonResult.ok(userDubboService.investMoney(request));
    }

    @PostMapping("find/user/by/id")
    public ShopJsonResult<FindUserByIdResponse> findUserById(@RequestBody FindUserByIdRequest request){
        return ShopJsonResult.ok(userDubboService.findUserById(request));
    }

    @PostMapping("delete/user")
    public ShopJsonResult<DeleteUserResponse> deleteUser(@RequestBody DeleteUserRequest request){
        return ShopJsonResult.ok(userDubboService.deleteUser(request));
    }

    @PostMapping("find/all/user")
    public ShopJsonResult<FindAllUserResponse> findAllUser(@RequestBody FindAllUserRequest request){
        return ShopJsonResult.ok(userDubboService.findAllUser(request));
    }

    @PostMapping(value = "code")
    public ShopJsonResult<TokenResponse> code(@RequestBody TokenRequest request){
        return ShopJsonResult.ok(userDubboService.code(request));
    }

}
