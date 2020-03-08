package com.kxg.suyoushop.provider.dubboservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kxg.suyoushop.dto.GoodsDto;
import com.kxg.suyoushop.provider.pojo.Goods;
import com.kxg.suyoushop.provider.service.GoodsService;
import com.kxg.suyoushop.request.goodRequest.*;
import com.kxg.suyoushop.response.goodResponse.*;
import com.kxg.suyoushop.service.GoodDubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(version = "1.0.0")
public class GoodDubboServiceImpl implements GoodDubboService {

    @Autowired
    private GoodsService goodsService;

    @Override
    public AddGoodResponse addGood(AddGoodRequest request) {
        AddGoodResponse response = new AddGoodResponse();
        Goods goods = new Goods();
        BeanUtils.copyProperties(request,goods);
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        response.setInteger(goodsService.addGood(goods));
        return response;
    }

    @Override
    public DeleteGoodResponse deleteGood(DeleteGoodRequest request) {
        DeleteGoodResponse response = new DeleteGoodResponse();
        response.setInteger(goodsService.deleteGood(request.getIds()));
        return response;
    }

    @Override
    public UpdateGoodResponse updateGood(UpdateGoodRequest request) {
        UpdateGoodResponse response = new UpdateGoodResponse();
        GoodsDto goodsDto = request.getGoodsDto();
        Goods goods = goodsService.findGoodById(goodsDto.getId());
        BeanUtils.copyProperties(goodsDto,goods);
        response.setInteger(goodsService.updateGood(goods));
        return response;
    }

    @Override
    public FindGoodByIdResponse findGoodById(FindGoodByIdRequest request) {
        FindGoodByIdResponse response = new FindGoodByIdResponse();
        Goods good = goodsService.findGoodById(request.getId());
        GoodsDto goodsDto = new GoodsDto();
        BeanUtils.copyProperties(good,goodsDto);
        response.setGoodsDto(goodsDto);
        return response;
    }

    @Override
    public FindGoodByNameResponse findGoodByName(FindGoodByNameRequest request) {
        FindGoodByNameResponse response = new FindGoodByNameResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Goods> goodByName = goodsService.findGoodByName(request.getName());
        PageInfo<Goods> pageInfo = new PageInfo<>(goodByName);

        List<Goods> goodsList = pageInfo.getList();
        response.setGoodsDtoList(changeGoodDto(goodsList));
        response.setTotal(goodsService.countGoodByName(request.getName()));
        return response;
    }

    @Override
    public FindGoodByPriceResponse findGoodByPrice(FindGoodByPriceRequest request) {
        FindGoodByPriceResponse response = new FindGoodByPriceResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Goods> goodByPrice = goodsService.findGoodByPrice(request.getMinPrice(), request.getMaxPrice());
        PageInfo<Goods> pageInfo = new PageInfo<>(goodByPrice);

        List<Goods> goodsList = pageInfo.getList();
        response.setGoodsDtoList(changeGoodDto(goodsList));
        response.setTotal(goodsService.countGoodByPrice(request.getMinPrice(),request.getMaxPrice()));
        return response;
    }

    @Override
    public FindAllGoodResponse findAllGoods(FindAllGoodRequest request) {
        FindAllGoodResponse response = new FindAllGoodResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Goods> allGoods = goodsService.findAllGoods();
        PageInfo<Goods> pageInfo = new PageInfo<>(allGoods);

        List<Goods> goodsList = pageInfo.getList();
        response.setGoodsDtoList(changeGoodDto(goodsList));
        response.setTotal(goodsService.countAllGoods());
        return response;
    }

    private List<GoodsDto> changeGoodDto(List<Goods> goodsList){
        List<GoodsDto> list = new ArrayList<>();
        for (Goods goods : goodsList) {
            GoodsDto goodsDto = new GoodsDto();
            BeanUtils.copyProperties(goods,goodsDto);
            list.add(goodsDto);
        }
        return list;
    }
}
