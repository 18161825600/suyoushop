package com.kxg.suyoushop.provider.dao;

import com.kxg.suyoushop.provider.mapper.GoodsMapper;
import com.kxg.suyoushop.provider.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;

    public Integer addGood(Goods goods){
        return goodsMapper.insert(goods);
    }

    public Integer deleteGood(List<Long> ids){
        Example example = new Example(Goods.class);
        example.createCriteria().andIn("id",ids);
        return goodsMapper.deleteByExample(example);
    }

    public Integer updateGood(Goods goods){
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public Goods findGoodById(Long id){
        return goodsMapper.selectByPrimaryKey(id);
    }

    public List<Goods> findGoodByName(String name){
        Example example = new Example(Goods.class);
        example.createCriteria().andLike("name",name);
        return goodsMapper.selectByExample(example);
    }

    public List<Goods> findGoodByPrice(Double mixPrice,Double maxPrice){
        Example example = new Example(Goods.class);
        example.createCriteria().andBetween("price",mixPrice,maxPrice);
        return goodsMapper.selectByExample(example);
    }

    public List<Goods> findAllGoods(){
        return goodsMapper.selectAll();
    }

    public Integer countGoodByName(String name) {
        Example example = new Example(Goods.class);
        example.createCriteria().andLike("name", name);
        return goodsMapper.selectCountByExample(example);
    }

    public Integer countGoodByPrice(Double mixPrice,Double maxPrice) {
        Example example = new Example(Goods.class);
        example.createCriteria().andBetween("price", mixPrice, maxPrice);
        return goodsMapper.selectCountByExample(example);
    }

    public Integer countAllGoods(){
        Example example = new Example(Goods.class);
        return goodsMapper.selectCountByExample(example);
    }
}
