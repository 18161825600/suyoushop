package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.pojo.Orders;

import java.util.List;

public interface OrdersService {

    Integer addOrder(Orders orders);

    Integer deleteOrder(List<Long> ids);

    Integer updateOrder(Orders orders);

    Orders findOrderById(Long id);

    List<Orders> findOrderByUserId(Long userId);

    List<Orders> findOrderByUserIdAndStatus(Long userId,Short status);

    List<Orders> findOrderByShopId(Long shopId);

    List<Orders> findAllOrder();

    Integer countOrderByUserId(Long userId);

    Integer countOrderByUserIdAndStatus(Long userId,Short status);

    Integer countOrderByShopId(Long shopId);

    Integer countAllOrder();
}
