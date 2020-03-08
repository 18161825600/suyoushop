package com.kxg.suyoushop.consumer.controller.goodController;


import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.consumer.hander.CheckHandler;
import com.kxg.suyoushop.request.goodRequest.*;
import com.kxg.suyoushop.response.goodResponse.*;
import com.kxg.suyoushop.service.GoodDubboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "商品")
@RequestMapping("good")
public class GoodsController {

    @Reference(version = "1.0.0")
    private GoodDubboService goodDubboService;
    @Autowired
    private CheckHandler checkHandler;

    @ApiOperation(value ="添加商品")
    @PostMapping("add")
    public ShopJsonResult<AddGoodResponse> addGood(@RequestHeader("token")String token, @RequestBody @Validated AddGoodRequest request){
        if(checkHandler.checkSsoToken(token)) {
            return ShopJsonResult.ok(goodDubboService.addGood(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value = "删除商品")
    @PostMapping("delete")
    public ShopJsonResult<DeleteGoodResponse> deleteGood(@RequestHeader("token")String token,@RequestBody @Validated DeleteGoodRequest request){
        if(checkHandler.checkSsoToken(token)) {
            return ShopJsonResult.ok(goodDubboService.deleteGood(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="修改商品信息" )
    @PostMapping("update")
    public ShopJsonResult<UpdateGoodResponse> updateGood(@RequestHeader("token")String token,@RequestBody @Validated UpdateGoodRequest request){
        if(checkHandler.checkSsoToken(token)) {
            return ShopJsonResult.ok(goodDubboService.updateGood(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="通过id查找商品" )
    @PostMapping("find/by/id")
    public ShopJsonResult<FindGoodByIdResponse> findGoodById(@RequestBody @Validated FindGoodByIdRequest request){
        return ShopJsonResult.ok(goodDubboService.findGoodById(request));
    }

    @ApiOperation(value ="通过商品名查找商品" )
    @PostMapping("find/by/name")
    public ShopJsonResult<FindGoodByNameResponse> findGoodByName(@RequestBody @Validated FindGoodByNameRequest request){
        return ShopJsonResult.ok(goodDubboService.findGoodByName(request));
    }

    @ApiOperation(value ="通过价格查找商品" )
    @PostMapping("find/by/price")
    public ShopJsonResult<FindGoodByPriceResponse> findGoodByPrice(@RequestBody @Validated FindGoodByPriceRequest request){
        return ShopJsonResult.ok(goodDubboService.findGoodByPrice(request));
    }

    @ApiOperation(value ="查找所有商品" )
    @PostMapping("find/all")
    public ShopJsonResult<FindAllGoodResponse> findAllGoods(@RequestBody @Validated FindAllGoodRequest request){
        return ShopJsonResult.ok(goodDubboService.findAllGoods(request));
    }
}
