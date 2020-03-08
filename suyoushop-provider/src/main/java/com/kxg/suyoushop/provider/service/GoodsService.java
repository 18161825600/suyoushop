package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.pojo.Goods;

import java.util.List;

public interface GoodsService {

    Integer addGood(Goods goods);

    Integer deleteGood(List<Long> ids);

    Integer updateGood(Goods goods);

    Goods findGoodById(Long id);

    List<Goods> findGoodByName(String name);

    List<Goods> findGoodByPrice(Double mixPrice,Double maxPrice);

    List<Goods> findAllGoods();

    Integer countGoodByName(String name);

    Integer countGoodByPrice(Double mixPrice,Double maxPrice);

    Integer countAllGoods();

}
