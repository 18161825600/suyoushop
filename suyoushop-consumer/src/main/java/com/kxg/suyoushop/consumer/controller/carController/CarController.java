package com.kxg.suyoushop.consumer.controller.carController;

import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.consumer.hander.CheckHandler;
import com.kxg.suyoushop.request.carRequest.*;
import com.kxg.suyoushop.response.carResponse.*;
import com.kxg.suyoushop.service.CarsDubboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "购物车")
@RequestMapping("car")
public class CarController {

    @Reference(version = "1.0.0")
    private CarsDubboService carsDubboService;
    @Autowired
    private CheckHandler checkHandler;

    @ApiOperation(value ="添加购物车")
    @PostMapping("add")
    public ShopJsonResult<AddCarResponse> addCars(@RequestHeader("token")String token, @RequestBody @Validated AddCarRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(carsDubboService.addCars(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="删除购物车")
    @PostMapping("delete")
    public ShopJsonResult<DeleteCarResponse> deleteCar(@RequestHeader("token")String token, @RequestBody @Validated DeleteCarRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(carsDubboService.deleteCar(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="修改购物车")
    @PostMapping("update")
    public ShopJsonResult<UpdateCarResponse> updateCar(@RequestHeader("token")String token, @RequestBody @Validated UpdateCarRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(carsDubboService.updateCar(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="通过id查找购物车")
    @PostMapping("find/by/id")
    public ShopJsonResult<FindCarByIdResponse> findCarById(@RequestHeader("token")String token, @RequestBody @Validated FindCarByIdRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(carsDubboService.findCarById(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="通过用户id查找购物车")
    @PostMapping("find/by/userId")
    public ShopJsonResult<FindCarByUserIdResponse> findCarsByUserId(@RequestHeader("token")String token, @RequestBody @Validated FindCarByUserIdRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(carsDubboService.findCarsByUserId(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="通过商家id查找购物车")
    @PostMapping("find/by/shopId")
    public ShopJsonResult<FindCarByShopIdResponse> findCarByShopId(@RequestBody @Validated FindCarByShopIdRequest request){
        return ShopJsonResult.ok(carsDubboService.findCarByShopId(request));
    }

    @ApiOperation(value ="通过商品id查找购物车")
    @PostMapping("find/by/goodId")
    public ShopJsonResult<FindCarByGoodIdResponse> findCarsByGoodId(@RequestBody @Validated FindCarByGoodIdRequest request){
        return ShopJsonResult.ok(carsDubboService.findCarsByGoodId(request));
    }

    @ApiOperation(value ="通过商家id和商品id查找购物车")
    @PostMapping("find/by/shopId/goodId")
    public ShopJsonResult<FindCarByShopIdAndGoodIdResponse> findCarsByShopIdAndGoodId(@RequestBody @Validated FindCarByShopIdAndGoodIdRequest request){
        return ShopJsonResult.ok(carsDubboService.findCarsByShopIdAndGoodId(request));
    }

    @ApiOperation(value ="查找所有的购物车")
    @PostMapping("find/all")
    public ShopJsonResult<FindAllCarResponse> findAllCars(@RequestBody @Validated FindAllCarRequest request){
        return ShopJsonResult.ok(carsDubboService.findAllCars(request));
    }
}
