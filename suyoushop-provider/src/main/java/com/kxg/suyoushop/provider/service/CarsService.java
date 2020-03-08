package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.pojo.Cars;

import java.util.List;

public interface CarsService {

    Integer addCars(Cars cars);

    Integer deleteCar(List<Long> ids);

    Integer updateCar(Cars cars);

    Cars findCarById(Long id);

    List<Cars> findCarsByUserId(Long userId);

    List<Cars> findCarByShopId(Long shopId);

    List<Cars> findCarsByGoodId(Long goodId);

    List<Cars> findCarsByShopIdAndGoodId(Long shopId,Long goodId);

    List<Cars> findAllCars();

    Integer countCarsByUserId(Long userId);

    Integer countCarByShopId(Long shopId);

    Integer countCarsByGoodId(Long goodId);

    Integer countCarsByShopIdAndGoodId(Long shopId,Long goodId);

    Integer countAllCars();
}
