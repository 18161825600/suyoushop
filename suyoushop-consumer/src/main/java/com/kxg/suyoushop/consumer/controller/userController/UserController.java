package com.kxg.suyoushop.consumer.controller.userController;


import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.request.userRequest.*;
import com.kxg.suyoushop.response.userResponse.*;
import com.kxg.suyoushop.service.UserDubboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api(description = "用户")
public class UserController {

    @Reference(version = "1.0.0")
    private UserDubboService userDubboService;

    @PostMapping("register")
    @ApiOperation(value = "注册")
    public ShopJsonResult<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ShopJsonResult.ok(userDubboService.register(request));
    }

    @ApiOperation(value = "修改头像")
    @PostMapping("update/img")
    public ShopJsonResult<UpdateUserImgResponse> updateUserImg(@RequestBody UpdateUserImgRequest request){
        return ShopJsonResult.ok(userDubboService.updateUserImg(request));
    }

    @ApiOperation(value = "通过密码修改手机号")
    @PostMapping("update/password/by/phone")
    public ShopJsonResult<UpdateUserPasswordByPhoneResponse> updateUserPasswordByPhone(@RequestBody UpdateUserPasswordByPhoneRequest request){
        return ShopJsonResult.ok(userDubboService.updateUserPasswordByPhone(request));
    }

    @ApiOperation(value = "通过id修改密码")
    @PostMapping("update/password/by/id")
    public ShopJsonResult<UpdateUserPasswordByIdResponse> updateUserPasswordById(@RequestBody UpdateUserPasswordByIdRequest request){
        return ShopJsonResult.ok(userDubboService.updateUserPasswordById(request));
    }

    @ApiOperation(value = "修改昵称")
    @PostMapping("update/nickName")
    public ShopJsonResult<UpdateUserNickNameResponse> updateUserNickName(@RequestBody UpdateUserNickNameRequest request){
        return ShopJsonResult.ok(userDubboService.updateUserNickName(request));
    }

    @ApiOperation(value = "充值")
    @PostMapping("invest/money")
    public ShopJsonResult<InvestMoneyResponse> investMoney(@RequestBody InvestMoneyRequest request){
        return ShopJsonResult.ok(userDubboService.investMoney(request));
    }

    @ApiOperation(value = "通过id查找用户")
    @PostMapping("find/by/id")
    public ShopJsonResult<FindUserByIdResponse> findUserById(@RequestBody FindUserByIdRequest request){
        return ShopJsonResult.ok(userDubboService.findUserById(request));
    }

    @ApiOperation(value = "删除用户")
    @PostMapping("delete")
    public ShopJsonResult<DeleteUserResponse> deleteUser(@RequestBody DeleteUserRequest request){
        return ShopJsonResult.ok(userDubboService.deleteUser(request));
    }

    @ApiOperation(value = "查找全部用户")
    @PostMapping("find/all")
    public ShopJsonResult<FindAllUserResponse> findAllUser(@RequestBody FindAllUserRequest request){
        return ShopJsonResult.ok(userDubboService.findAllUser(request));
    }


}
