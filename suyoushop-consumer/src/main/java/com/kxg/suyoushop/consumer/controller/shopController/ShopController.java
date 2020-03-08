package com.kxg.suyoushop.consumer.controller.shopController;


import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.request.shopsRequest.*;
import com.kxg.suyoushop.response.shopResponse.*;
import com.kxg.suyoushop.service.ShopsDubboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "商家")
@RequestMapping("shop")
public class ShopController {

    @Reference(version = "1.0.0")
    private ShopsDubboService shopsDubboService;

    @ApiOperation(value = "注册商家")
    @PostMapping("register")
    public ShopJsonResult<RegisterShopsResponse> registerShop(RegisterShopRequest request){
        return ShopJsonResult.ok(shopsDubboService.registerShop(request));
    }

    @ApiOperation(value = "注销商家")
    @PostMapping("delete")
    public ShopJsonResult<DeleteShopsResponse> delete(DeleteShopsRequest request){
        return ShopJsonResult.ok(shopsDubboService.delete(request));
    }

    @ApiOperation(value = "修改店铺名称")
    @PostMapping("update/name")
    public ShopJsonResult<UpdateShopNameResponse> updateShopName(UpdateShopNameRequest request){
        return ShopJsonResult.ok(shopsDubboService.updateShopName(request));
    }

    @ApiOperation(value = "修改店铺图片")
    @PostMapping("update/img")
    public ShopJsonResult<UpdateShopImgResponse> updateShopImg(UpdateShopImgRequest request){
        return ShopJsonResult.ok(shopsDubboService.updateShopImg(request));
    }

    @ApiOperation(value = "通过商家id修改登录密码")
    @PostMapping("update/password/by/id")
    public ShopJsonResult<UpdateShopPasswordByIdResponse> updateShopPasswordById(UpdateShopPasswordByIdRequest request){
        return ShopJsonResult.ok(shopsDubboService.updateShopPasswordById(request));
    }

    @ApiOperation(value = "通过手机验证码修改登录密码")
    @PostMapping("update/password/by/phone")
    public ShopJsonResult<UpdateShopPasswordByPhoneResponse> updateShopPasswordByPhone(UpdateShopPasswordByPhoneRequest request){
        return ShopJsonResult.ok(shopsDubboService.updateShopPasswordByPhone(request));
    }

    @ApiOperation(value = "修改商家店铺信息")
    @PostMapping("update")
    public ShopJsonResult<UpdateShopResponse> updateShop(UpdateShopRequest request){
        return ShopJsonResult.ok(shopsDubboService.updateShop(request));
    }

    @ApiOperation(value = "通过id查找商家")
    @PostMapping("find/by/id")
    public ShopJsonResult<FindShopsByIdResponse> findShopsById(FindShopsByIdRequest request){
        return ShopJsonResult.ok(shopsDubboService.findShopsById(request));
    }

    @ApiOperation(value = "通过店铺名称查找店铺")
    @PostMapping("find/by/name")
    public ShopJsonResult<FindShopByNameResponse> findShopsByName(FindShopByNameRequest request){
        return ShopJsonResult.ok(shopsDubboService.findShopsByName(request));
    }

    @ApiOperation(value = "查找全部店铺")
    @PostMapping("find/all")
    public ShopJsonResult<FindAllShopResponse> findAllShops(FindAllShopRequest request){
        return ShopJsonResult.ok(shopsDubboService.findAllShops(request));
    }
}
