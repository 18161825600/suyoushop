package com.kxg.suyoushop.provider.dao;

import com.kxg.suyoushop.provider.mapper.ShopsMapper;
import com.kxg.suyoushop.provider.pojo.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class ShopsDao {

    @Autowired
    private ShopsMapper shopsMapper;

    public Integer register(Shops shops){
        return shopsMapper.insert(shops);
    }

    public Integer delete(Long id){
        return shopsMapper.deleteByPrimaryKey(id);
    }

    public Shops login(String phoneNumber,String password){
        Example example = new Example(Shops.class);
        example.createCriteria().andEqualTo("phoneNumber",phoneNumber)
                .andEqualTo("password",password);
        return shopsMapper.selectOneByExample(example);
    }

    public Shops findShopsByPhone(String phoneNumber){
        Example example = new Example(Shops.class);
        example.createCriteria().andEqualTo("phoneNumber",phoneNumber);
        return shopsMapper.selectOneByExample(example);
    }

    public Integer update(Shops shops){
        return shopsMapper.updateByPrimaryKeySelective(shops);
    }

    public Shops findShopById(Long id){
        return shopsMapper.selectByPrimaryKey(id);
    }

    public List<Shops> findShopByName(String name){
        Example example = new Example(Shops.class);
        example.createCriteria().andLike("name","%"+name+"%");
        return shopsMapper.selectByExample(example);
    }

    public List<Shops> findAllShops(){
        return shopsMapper.selectAll();
    }

    public Integer countShopByName(String name){
        Example example = new Example(Shops.class);
        example.createCriteria().andLike("name","%"+name+"%");
        return shopsMapper.selectCountByExample(example);
    }

    public Integer countAllShops(){
        Example example = new Example(Shops.class);
        return shopsMapper.selectCountByExample(example);
    }
}
