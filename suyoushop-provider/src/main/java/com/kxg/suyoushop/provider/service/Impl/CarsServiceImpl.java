package com.kxg.suyoushop.provider.service.Impl;

import com.kxg.suyoushop.provider.dao.CarsDao;
import com.kxg.suyoushop.provider.pojo.Cars;
import com.kxg.suyoushop.provider.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsDao carsDao;

    @Override
    public Integer addCars(Cars cars) {
        return carsDao.addCars(cars);
    }

    @Override
    public Integer deleteCar(List<Long> ids) {
        return carsDao.deleteCar(ids);
    }

    @Override
    public Integer updateCar(Cars cars) {
        return carsDao.updateCar(cars);
    }

    @Override
    public Cars findCarById(Long id) {
        return carsDao.findCarById(id);
    }

    @Override
    public List<Cars> findCarsByUserId(Long userId) {
        return carsDao.findCarsByUserId(userId);
    }

    @Override
    public List<Cars> findCarByShopId(Long shopId) {
        return carsDao.findCarByShopId(shopId);
    }

    @Override
    public List<Cars> findCarsByGoodId(Long goodId) {
        return carsDao.findCarsByGoodId(goodId);
    }

    @Override
    public List<Cars> findCarsByShopIdAndGoodId(Long shopId, Long goodId) {
        return carsDao.findCarsByShopIdAndGoodId(shopId, goodId);
    }

    @Override
    public List<Cars> findAllCars() {
        return carsDao.findAllCars();
    }

    @Override
    public Integer countCarsByUserId(Long userId) {
        return carsDao.countCarsByUserId(userId);
    }

    @Override
    public Integer countCarByShopId(Long shopId) {
        return carsDao.countCarByShopId(shopId);
    }

    @Override
    public Integer countCarsByGoodId(Long goodId) {
        return carsDao.countCarsByGoodId(goodId);
    }

    @Override
    public Integer countCarsByShopIdAndGoodId(Long shopId, Long goodId) {
        return carsDao.countCarsByShopIdAndGoodId(shopId, goodId);
    }

    @Override
    public Integer countAllCars() {
        return carsDao.countAllCars();
    }
}
