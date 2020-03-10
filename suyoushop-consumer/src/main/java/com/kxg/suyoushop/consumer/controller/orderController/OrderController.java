package com.kxg.suyoushop.consumer.controller.orderController;

import com.kxg.suyoushop.common.ShopJsonResult;
import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.consumer.hander.CheckHandler;
import com.kxg.suyoushop.request.orderRequest.*;
import com.kxg.suyoushop.response.orderResponse.*;
import com.kxg.suyoushop.service.OrderDubboService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "订单")
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderDubboService orderDubboService;
    @Autowired
    private CheckHandler checkHandler;

    @ApiOperation(value ="添加订单")
    @PostMapping("add")
    public ShopJsonResult<AddOrderResponse> addOrder(@RequestHeader("Token")String token, @RequestBody @Validated AddOrderRequest request){
        if(checkHandler.checkSsoToken(token)){
            request.setStatus(SuYouShopConstants.NOT_PAY_STATUS);
            return ShopJsonResult.ok(orderDubboService.addOrder(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="批量删除订单")
    @PostMapping("delete")
    public ShopJsonResult<DeleteOrdersResponse> deleteOrder(@RequestHeader("Token")String token, @RequestBody @Validated DeleteOrdersRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(orderDubboService.deleteOrder(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="修改订单状态")
    @PostMapping("update/status")
    public ShopJsonResult<UpdateOrderStatusResponse> updateOrderStatus( @RequestBody @Validated UpdateOrderStatusRequest request){
        return ShopJsonResult.ok(orderDubboService.updateOrderStatus(request));
    }

    @ApiOperation(value ="通过支付码修改订单状态")
    @PostMapping("update/paycode")
    public ShopJsonResult<UpdateOrderPayCodeResponse> updateOrderPayCode(@RequestHeader("payToken")String payToken, @RequestBody @Validated UpdateOrderPayCodeRequest request){
        if(checkHandler.checkPayToken(payToken,request.getOrderId())){
            request.setPayCode(payToken);
            request.setStatus(SuYouShopConstants.PAY_SUCCESS);
            return ShopJsonResult.ok(orderDubboService.updateOrderPayCode(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.PAY_TOKEN_NOT_RIGHT);
    }

    @ApiOperation(value ="通过id查找订单")
    @PostMapping("find/by/id")
    public ShopJsonResult<FindOrderByIdResponse> findOrderById(@RequestHeader("Token")String token, @RequestBody @Validated FindOrderByIdRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(orderDubboService.findOrderById(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="通过用户id查找该用户订单")
    @PostMapping("find/by/userId")
    public ShopJsonResult<FindOrderByUserIdResponse> findOrderByUserId(@RequestHeader("Token")String token, @RequestBody @Validated FindOrderByUserIdRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(orderDubboService.findOrderByUserId(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="通过用户id和订单状态查找订单")
    @PostMapping("find/by/userId/status")
    public ShopJsonResult<FindOrderByUserIdAndStatusResponse> findOrderByUserIdAndStatus(@RequestHeader("Token")String token, @RequestBody @Validated FindOrderByUserIdAndStatusRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(orderDubboService.findOrderByUserIdAndStatus(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="通过店铺id查找订单")
    @PostMapping("find/by/shopId")
    public ShopJsonResult<FindOrderByShopIdResponse> findOrderByShopId(@RequestHeader("Token")String token, @RequestBody @Validated FindOrderByShopIdRequest request){
        if(checkHandler.checkSsoToken(token)){
            return ShopJsonResult.ok(orderDubboService.findOrderByShopId(request));
        }else return ShopJsonResult.errorMsg(SuYouShopConstants.TOKEN_IS_NOT_RIGHT);
    }

    @ApiOperation(value ="查找所有订单")
    @PostMapping("find/all")
    public ShopJsonResult<FindAllOrderResponse> findAllOrder(FindAllOrderRequest request){
        return ShopJsonResult.ok(orderDubboService.findAllOrder(request));
    }
}
