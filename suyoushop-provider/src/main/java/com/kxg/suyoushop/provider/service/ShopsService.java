package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.pojo.Shops;

import java.util.List;

public interface ShopsService {

    Integer register(Shops shops);

    Shops login(String phoneNumber,String password);

    Integer delete(Long id);

    Integer update(Shops shops);

    Shops findShopsById(Long id);

    Shops findShopsByPhone(String phoneNumber);

    List<Shops> findShopsByName(String name);

    Integer countShopsByName(String name);

    List<Shops> findAllShops();

    Integer countAllShops();
}
