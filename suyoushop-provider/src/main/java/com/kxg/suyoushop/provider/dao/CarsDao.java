package com.kxg.suyoushop.provider.dao;

import com.kxg.suyoushop.provider.mapper.CarsMapper;
import com.kxg.suyoushop.provider.pojo.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class CarsDao {

    @Autowired
    private CarsMapper carsMapper;

    public Integer addCars(Cars cars){
        return carsMapper.insert(cars);
    }

    public Integer deleteCar(List<Long> ids){
        Example example = new Example(Cars.class);
        example.createCriteria().andIn("id",ids);
        return carsMapper.deleteByExample(example);
    }

    public Integer updateCar(Cars cars){
        return carsMapper.updateByPrimaryKeySelective(cars);
    }

    public Cars findCarById(Long id){
        return carsMapper.selectByPrimaryKey(id);
    }

    public List<Cars> findCarsByUserId(Long userId){
        Example example = new Example(Cars.class);
        example.createCriteria().andEqualTo("userId",userId);
        return carsMapper.selectByExample(userId);
    }

    public List<Cars> findCarByShopId(Long shopId){
        Example example = new Example(Cars.class);
        example.createCriteria().andEqualTo("shopId",shopId);
        return carsMapper.selectByExample(example);
    }

    public List<Cars> findCarsByGoodId(Long goodId){
        Example example = new Example(Cars.class);
        example.createCriteria().andEqualTo("goodId",goodId);
        return carsMapper.selectByExample(example);
    }

    public List<Cars> findCarsByShopIdAndGoodId(Long shopId,Long goodId){
        Example example = new Example(Cars.class);
        example.createCriteria().andEqualTo("shopId",shopId)
                .andEqualTo("goodId",goodId);
        return carsMapper.selectByExample(example);
    }

    public List<Cars> findAllCars(){
        return carsMapper.selectAll();
    }

    public Integer countCarsByUserId(Long userId) {
        Example example = new Example(Cars.class);
        example.createCriteria().andEqualTo("userId", userId);
        return carsMapper.selectCountByExample(example);
    }

    public Integer countCarByShopId(Long shopId) {
        Example example = new Example(Cars.class);
        example.createCriteria().andEqualTo("shopId", shopId);
        return carsMapper.selectCountByExample(example);
    }

    public Integer countCarsByGoodId(Long goodId) {
        Example example = new Example(Cars.class);
        example.createCriteria().andEqualTo("goodId", goodId);
        return carsMapper.selectCountByExample(example);
    }

    public Integer countCarsByShopIdAndGoodId(Long shopId,Long goodId) {
        Example example = new Example(Cars.class);
        example.createCriteria().andEqualTo("shopId", shopId)
                .andEqualTo("goodId", goodId);
        return carsMapper.selectCountByExample(example);
    }

    public Integer countAllCars(){
        Example example = new Example(Cars.class);
        return carsMapper.selectCountByExample(example);
    }
}
