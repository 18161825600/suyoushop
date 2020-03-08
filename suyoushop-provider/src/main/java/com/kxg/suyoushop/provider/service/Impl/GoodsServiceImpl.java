package com.kxg.suyoushop.provider.service.Impl;

import com.kxg.suyoushop.provider.dao.GoodsDao;
import com.kxg.suyoushop.provider.pojo.Goods;
import com.kxg.suyoushop.provider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Integer addGood(Goods goods) {
        return goodsDao.addGood(goods);
    }

    @Override
    public Integer deleteGood(List<Long> ids) {
        return goodsDao.deleteGood(ids);
    }

    @Override
    public Integer updateGood(Goods goods) {
        return goodsDao.updateGood(goods);
    }

    @Override
    public Goods findGoodById(Long id) {
        return goodsDao.findGoodById(id);
    }

    @Override
    public List<Goods> findGoodByName(String name) {
        return goodsDao.findGoodByName(name);
    }

    @Override
    public List<Goods> findGoodByPrice(Double mixPrice, Double maxPrice) {
        return goodsDao.findGoodByPrice(mixPrice, maxPrice);
    }

    @Override
    public List<Goods> findAllGoods() {
        return goodsDao.findAllGoods();
    }

    @Override
    public Integer countGoodByName(String name) {
        return goodsDao.countGoodByName(name);
    }

    @Override
    public Integer countGoodByPrice(Double mixPrice, Double maxPrice) {
        return goodsDao.countGoodByPrice(mixPrice, maxPrice);
    }

    @Override
    public Integer countAllGoods() {
        return goodsDao.countAllGoods();
    }
}
