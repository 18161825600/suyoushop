package com.kxg.suyoushop.consumer.controller.sso;


import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.request.userRequest.LoginUserBySmsRequest;
import com.kxg.suyoushop.request.userRequest.LoginUserRequest;
import com.kxg.suyoushop.response.userResponse.LoginUserResponse;
import com.kxg.suyoushop.service.UserDubboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "用户单点登录")
@RequestMapping("user")
public class UserSsoController {

    @Reference(version = "1.0.0")
    private UserDubboService userDubboService;

    @ApiOperation(value = "手机号密码登录")
    @PostMapping("login")
    public ShopJsonResult<LoginUserResponse> login(@RequestBody @Validated LoginUserRequest request){
        return ShopJsonResult.ok(userDubboService.login(request));
    }

    @ApiOperation(value = "短信验证码登录")
    @PostMapping("login/sms")
    public ShopJsonResult<LoginUserResponse> loginBySms(@RequestBody @Validated LoginUserBySmsRequest request){
        return ShopJsonResult.ok(userDubboService.loginBySms(request));
    }
}
