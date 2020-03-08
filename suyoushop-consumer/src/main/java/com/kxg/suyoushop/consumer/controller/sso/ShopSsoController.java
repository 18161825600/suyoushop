package com.kxg.suyoushop.consumer.controller.sso;


import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.request.shopsRequest.LoginShopBySmsRequest;
import com.kxg.suyoushop.request.shopsRequest.LoginShopRequest;
import com.kxg.suyoushop.response.shopResponse.LoginShopBySmsResponse;
import com.kxg.suyoushop.response.shopResponse.LoginShopsResponse;
import com.kxg.suyoushop.service.ShopsDubboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "商家单点登录")
@RequestMapping("shop")
public class ShopSsoController {

    @Reference(version = "1.0.0")
    private ShopsDubboService shopsDubboService;

    @ApiOperation(value = "商家使用手机号和密码登录")
    @PostMapping("login/shop")
    public ShopJsonResult<LoginShopsResponse> loginShop(@RequestBody @Validated LoginShopRequest request){
        return ShopJsonResult.ok(shopsDubboService.loginShop(request));
    }

    @ApiOperation(value = "商家通过手机验证码登录")
    @PostMapping("login/sms")
    public ShopJsonResult<LoginShopBySmsResponse> loginShopBySms(@RequestBody @Validated LoginShopBySmsRequest request){
        return ShopJsonResult.ok(shopsDubboService.loginShopBySms(request));
    }
}
