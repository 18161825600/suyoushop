package com.kxg.suyoushop.consumer.controller.goodController;


import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.request.goodRequest.*;
import com.kxg.suyoushop.response.goodResponse.*;
import com.kxg.suyoushop.service.GoodDubboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "商品")
@RequestMapping("good")
public class GoodsController {

    @Reference(version = "1.0.0")
    private GoodDubboService goodDubboService;

    @ApiOperation(value ="添加商品")
    @PostMapping("add")
    public ShopJsonResult<AddGoodResponse> addGood(@RequestBody AddGoodRequest request){
        return ShopJsonResult.ok(goodDubboService.addGood(request));
    }

    @ApiOperation(value = "删除商品")
    @PostMapping("delete")
    public ShopJsonResult<DeleteGoodResponse> deleteGood(@RequestBody DeleteGoodRequest request){
        return ShopJsonResult.ok(goodDubboService.deleteGood(request));
    }

    @ApiOperation(value ="修改商品信息" )
    @PostMapping("update")
    public ShopJsonResult<UpdateGoodResponse> updateGood(@RequestBody UpdateGoodRequest request){
        return ShopJsonResult.ok(goodDubboService.updateGood(request));
    }

    @ApiOperation(value ="通过id查找商品" )
    @PostMapping("find/by/id")
    public ShopJsonResult<FindGoodByIdResponse> findGoodById(@RequestBody FindGoodByIdRequest request){
        return ShopJsonResult.ok(goodDubboService.findGoodById(request));
    }

    @ApiOperation(value ="通过商品名查找商品" )
    @PostMapping("find/by/name")
    public ShopJsonResult<FindGoodByNameResponse> findGoodByName(@RequestBody FindGoodByNameRequest request){
        return ShopJsonResult.ok(goodDubboService.findGoodByName(request));
    }

    @ApiOperation(value ="通过价格查找商品" )
    @PostMapping("find/by/price")
    public ShopJsonResult<FindGoodByPriceResponse> findGoodByPrice(@RequestBody FindGoodByPriceRequest request){
        return ShopJsonResult.ok(goodDubboService.findGoodByPrice(request));
    }

    @ApiOperation(value ="查找所有商品" )
    @PostMapping("find/all")
    public ShopJsonResult<FindAllGoodResponse> findAllGoods(@RequestBody FindAllGoodRequest request){
        return ShopJsonResult.ok(goodDubboService.findAllGoods(request));
    }
}
