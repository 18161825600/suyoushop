package com.kxg.suyoushop.provider.dubboservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kxg.suyoushop.dto.OrderDto;
import com.kxg.suyoushop.provider.pojo.Orders;
import com.kxg.suyoushop.provider.service.OrdersService;
import com.kxg.suyoushop.request.orderRequest.*;
import com.kxg.suyoushop.response.orderResponse.*;
import com.kxg.suyoushop.service.OrderDubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderDubboServiceImpl implements OrderDubboService {

    @Autowired
    private OrdersService ordersService;

    @Override
    public AddOrderResponse addOrder(AddOrderRequest request) {
        Orders orders = new Orders();
        AddOrderResponse response = new AddOrderResponse();
        BeanUtils.copyProperties(request,orders);
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        response.setInteger(ordersService.addOrder(orders));
        return response;
    }

    @Override
    public DeleteOrdersResponse deleteOrder(DeleteOrdersRequest request) {
        DeleteOrdersResponse response = new DeleteOrdersResponse();
        response.setInteger(ordersService.deleteOrder(request.getIds()));
        return response;
    }

    @Override
    public UpdateOrderStatusResponse updateOrderStatus(UpdateOrderStatusRequest request) {
        UpdateOrderStatusResponse response = new UpdateOrderStatusResponse();
        Orders orderById = ordersService.findOrderById(request.getId());
        orderById.setStatus(request.getStatus());
        orderById.setUpdateTime(new Date());
        response.setInteger(ordersService.updateOrder(orderById));
        return response;
    }

    @Override
    public UpdateOrderPayCodeResponse updateOrderPayCode(UpdateOrderPayCodeRequest request) {
        UpdateOrderPayCodeResponse response = new UpdateOrderPayCodeResponse();
        Orders orderById = ordersService.findOrderById(request.getId());
        orderById.setPayCode(request.getPayCode());
        orderById.setUpdateTime(new Date());
        response.setInteger(ordersService.updateOrder(orderById));
        return response;
    }

    @Override
    public FindOrderByIdResponse findOrderById(FindOrderByIdRequest request) {
        FindOrderByIdResponse response = new FindOrderByIdResponse();
        OrderDto orderDto = new OrderDto();
        Orders orderById = ordersService.findOrderById(request.getId());
        BeanUtils.copyProperties(orderById,orderDto);
        response.setOrderDto(orderDto);
        return response;
    }

    @Override
    public FindOrderByUserIdResponse findOrderByUserId(FindOrderByUserIdRequest request) {
        FindOrderByUserIdResponse response = new FindOrderByUserIdResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Orders> orderByUserId = ordersService.findOrderByUserId(request.getUserId());
        PageInfo<Orders> pageInfo = new PageInfo<>(orderByUserId);
        response.setOrderDtoList(changeOrderDto(pageInfo.getList()));
        response.setTotal(ordersService.countOrderByUserId(request.getUserId()));
        return response;
    }

    @Override
    public FindOrderByUserIdAndStatusResponse findOrderByUserIdAndStatus(FindOrderByUserIdAndStatusRequest request) {
        FindOrderByUserIdAndStatusResponse response = new FindOrderByUserIdAndStatusResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Orders> orderByUserIdAndStatus = ordersService.findOrderByUserIdAndStatus(request.getUserId(), request.getStatus());
        PageInfo<Orders> pageInfo = new PageInfo<>(orderByUserIdAndStatus);
        response.setOrderDtoList(changeOrderDto(pageInfo.getList()));
        response.setTotal(ordersService.countOrderByUserIdAndStatus(request.getUserId(),request.getStatus()));
        return response;
    }

    @Override
    public FindOrderByShopIdResponse findOrderByShopId(FindOrderByShopIdRequest request) {
        FindOrderByShopIdResponse response = new FindOrderByShopIdResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Orders> orderByShopId = ordersService.findOrderByShopId(request.getShopId());
        PageInfo<Orders> pageInfo = new PageInfo<>(orderByShopId);
        response.setOrderDtoList(changeOrderDto(pageInfo.getList()));
        response.setTotal(ordersService.countOrderByShopId(request.getShopId()));
        return response;
    }

    @Override
    public FindAllOrderResponse findAllOrder(FindAllOrderRequest request) {
        FindAllOrderResponse response = new FindAllOrderResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Orders> allOrder = ordersService.findAllOrder();
        PageInfo<Orders> pageInfo = new PageInfo<>(allOrder);
        response.setOrderDtoList(changeOrderDto(pageInfo.getList()));
        response.setTotal(ordersService.countAllOrder());
        return response;
    }

    private List<OrderDto> changeOrderDto(List<Orders> orderList){
        List<OrderDto> list = new ArrayList<>();
        for (Orders orders : orderList) {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(orders,orderDto);
            list.add(orderDto);
        }
        return list;
    }
}
