package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.orderRequest.*;
import com.kxg.suyoushop.response.orderResponse.*;

import java.util.List;

public interface OrderDubboService {

    AddOrderResponse addOrder(AddOrderRequest request);

    DeleteOrdersResponse deleteOrder(DeleteOrdersRequest request);

    DeletePaymentOrderResponse deletePaymentOrder(DeletePaymentOrderRequest request);

    UpdateOrderStatusResponse updateOrderStatus(UpdateOrderStatusRequest request);

    UpdateOrderPayCodeResponse updateOrderPayCode(UpdateOrderPayCodeRequest request);

    FindOrderByIdResponse findOrderById(FindOrderByIdRequest request);

    FindOrderByUserIdResponse findOrderByUserId(FindOrderByUserIdRequest request);

    FindOrderByUserIdAndStatusResponse findOrderByUserIdAndStatus(FindOrderByUserIdAndStatusRequest request);

    FindOrderByShopIdResponse findOrderByShopId(FindOrderByShopIdRequest request);

    FindAllOrderResponse findAllOrder(FindAllOrderRequest request);
}
