package com.kxg.suyoushop.provider.service.Impl;

import com.kxg.suyoushop.provider.dao.ShopsDao;
import com.kxg.suyoushop.provider.pojo.Shops;
import com.kxg.suyoushop.provider.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopsServiceImpl implements ShopsService {

    @Autowired
    private ShopsDao shopsDao;

    @Override
    public Integer register(Shops shops) {
        return shopsDao.register(shops);
    }

    @Override
    public Shops login(String phoneNumber, String password) {
        return shopsDao.login(phoneNumber, password);
    }

    @Override
    public Integer delete(Long id) {
        return shopsDao.delete(id);
    }

    @Override
    public Integer update(Shops shops) {
        return shopsDao.update(shops);
    }

    @Override
    public Shops findShopsById(Long id) {
        return shopsDao.findShopById(id);
    }

    @Override
    public Shops findShopsByPhone(String phoneNumber) {
        return shopsDao.findShopsByPhone(phoneNumber);
    }

    @Override
    public List<Shops> findShopsByName(String name) {
        return shopsDao.findShopByName(name);
    }

    @Override
    public Integer countShopsByName(String name) {
        return shopsDao.countShopByName(name);
    }

    @Override
    public List<Shops> findAllShops() {
        return shopsDao.findAllShops();
    }

    @Override
    public Integer countAllShops() {
        return shopsDao.countAllShops();
    }
}
