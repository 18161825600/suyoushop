package com.kxg.suyoushop.consumer.controller;

import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.request.PhoneNumberCodeRequest;
import com.kxg.suyoushop.response.PhoneNumberCodeResponse;
import com.kxg.suyoushop.service.PhoneCodeDubboService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneCodeController {

    @Autowired
    private PhoneCodeDubboService phoneCodeDubboService;

    @ApiOperation(value = "获取手机验证码")
    @PostMapping(value = "phone/code")
    public ShopJsonResult<PhoneNumberCodeResponse> code(@RequestBody @Validated PhoneNumberCodeRequest request){
        return ShopJsonResult.ok(phoneCodeDubboService.code(request));
    }
}
