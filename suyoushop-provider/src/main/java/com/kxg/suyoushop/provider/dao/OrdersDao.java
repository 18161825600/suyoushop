package com.kxg.suyoushop.provider.dao;

import com.kxg.suyoushop.provider.mapper.OrdersMapper;
import com.kxg.suyoushop.provider.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class OrdersDao {

    @Autowired
    private OrdersMapper ordersMapper;

    public Integer addOrder(Orders orders){
        return ordersMapper.insert(orders);
    }

    public Integer deleteOrder(List<Long> ids){
        Example example = new Example(Orders.class);
        example.createCriteria().andIn("id",ids);
        return ordersMapper.deleteByExample(example);
    }

    public Integer updateOrder(Orders orders){
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }

    public Orders findOrderById(Long id){
        return ordersMapper.selectByPrimaryKey(id);
    }

    public List<Orders> findOrderByUserId(Long userId){
        Example example = new Example(Orders.class);
        example.createCriteria().andEqualTo("userId",userId);
        return ordersMapper.selectByExample(example);
    }

    public List<Orders> findOrderByUserIdAndStatus(Long userId,Short status){
        Example example = new Example(Orders.class);
        example.createCriteria().andEqualTo("userId",userId)
                .andEqualTo("status",status);
        return ordersMapper.selectByExample(example);
    }

    public List<Orders> findOrderByShopId(Long shopId){
        Example example = new Example(Orders.class);
        example.createCriteria().andEqualTo("shopId",shopId);
        return ordersMapper.selectByExample(example);
    }

    public List<Orders> findAllOrder(){
        return ordersMapper.selectAll();
    }

    public Integer countOrderByUserId(Long userId) {
        Example example = new Example(Orders.class);
        example.createCriteria().andEqualTo("userId", userId);
        return ordersMapper.selectCountByExample(example);
    }

    public Integer countOrderByUserIdAndStatus(Long userId,Short status) {
        Example example = new Example(Orders.class);
        example.createCriteria().andEqualTo("userId", userId)
                .andEqualTo("status", status);
        return ordersMapper.selectCountByExample(example);
    }

    public Integer countOrderByShopId(Long shopId) {
        Example example = new Example(Orders.class);
        example.createCriteria().andEqualTo("shopId", shopId);
        return ordersMapper.selectCountByExample(example);
    }

    public Integer countAllOrder(){
        Example example = new Example(Orders.class);
        return ordersMapper.selectCountByExample(example);
    }
}
