package com.kxg.suyoushop.provider.service.Impl;

import com.kxg.suyoushop.provider.dao.OrdersDao;
import com.kxg.suyoushop.provider.pojo.Orders;
import com.kxg.suyoushop.provider.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public Integer addOrder(Orders orders) {
        return ordersDao.addOrder(orders);
    }

    @Override
    public Integer deleteOrder(List<Long> ids) {
        return ordersDao.deleteOrder(ids);
    }

    @Override
    public Integer updateOrder(Orders orders) {
        return ordersDao.updateOrder(orders);
    }

    @Override
    public Orders findOrderById(Long id) {
        return ordersDao.findOrderById(id);
    }

    @Override
    public List<Orders> findOrderByUserId(Long userId) {
        return ordersDao.findOrderByUserId(userId);
    }

    @Override
    public List<Orders> findOrderByUserIdAndStatus(Long userId, Short status) {
        return ordersDao.findOrderByUserIdAndStatus(userId, status);
    }

    @Override
    public List<Orders> findOrderByShopId(Long shopId) {
        return ordersDao.findOrderByShopId(shopId);
    }

    @Override
    public List<Orders> findAllOrder() {
        return ordersDao.findAllOrder();
    }

    @Override
    public Integer countOrderByUserId(Long userId) {
        return ordersDao.countOrderByUserId(userId);
    }

    @Override
    public Integer countOrderByUserIdAndStatus(Long userId, Short status) {
        return ordersDao.countOrderByUserIdAndStatus(userId, status);
    }

    @Override
    public Integer countOrderByShopId(Long shopId) {
        return ordersDao.countOrderByShopId(shopId);
    }

    @Override
    public Integer countAllOrder() {
        return ordersDao.countAllOrder();
    }
}
