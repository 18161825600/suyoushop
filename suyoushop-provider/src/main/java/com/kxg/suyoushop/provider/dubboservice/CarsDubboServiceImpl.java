package com.kxg.suyoushop.provider.dubboservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.dto.CarDto;
import com.kxg.suyoushop.provider.pojo.Cars;
import com.kxg.suyoushop.provider.service.CarsService;
import com.kxg.suyoushop.request.carRequest.*;
import com.kxg.suyoushop.response.carResponse.*;
import com.kxg.suyoushop.service.CarsDubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(version = "1.0.0")
public class CarsDubboServiceImpl implements CarsDubboService {

    @Autowired
    private CarsService carsService;

    @Override
    public AddCarResponse addCars(AddCarRequest request) {
        AddCarResponse response = new AddCarResponse();
        Cars cars = new Cars();
        BeanUtils.copyProperties(request,cars);
        cars.setCreateTime(new Date());
        cars.setUpdateTime(new Date());
        response.setInteger(carsService.addCars(cars));
        return response;
    }

    @Override
    public DeleteCarResponse deleteCar(DeleteCarRequest request) {
        DeleteCarResponse response = new DeleteCarResponse();
        response.setInteger(carsService.deleteCar(request.getIds()));
        return response;
    }

    @Override
    public UpdateCarResponse updateCar(UpdateCarRequest request) {
        UpdateCarResponse response = new UpdateCarResponse();
        Cars car = carsService.findCarById(request.getId());
        BeanUtils.copyProperties(request,car);
        car.setUpdateTime(new Date());
        response.setInteger(carsService.updateCar(car));
        return response;
    }

    @Override
    public FindCarByIdResponse findCarById(FindCarByIdRequest request) {
        FindCarByIdResponse response = new FindCarByIdResponse();
        Cars car = carsService.findCarById(request.getId());
        CarDto carDto = new CarDto();
        BeanUtils.copyProperties(car,carDto);
        response.setCarDto(carDto);
        return response;
    }

    @Override
    public FindCarByUserIdResponse findCarsByUserId(FindCarByUserIdRequest request) {
        FindCarByUserIdResponse response = new FindCarByUserIdResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Cars> carsByUserId = carsService.findCarsByUserId(request.getUserId());
        PageInfo<Cars> pageInfo = new PageInfo<>(carsByUserId);

        response.setCarDtoList(changeCarDto(pageInfo.getList()));
        response.setTotal(carsService.countCarsByUserId(request.getUserId()));
        return response;
    }

    @Override
    public FindCarByShopIdResponse findCarByShopId(FindCarByShopIdRequest request) {
        FindCarByShopIdResponse response = new FindCarByShopIdResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Cars> carByShopId = carsService.findCarByShopId(request.getShopId());
        PageInfo<Cars> pageInfo = new PageInfo<>(carByShopId);

        response.setCarDtoList(changeCarDto(pageInfo.getList()));
        response.setTotal(carsService.countCarByShopId(request.getShopId()));
        return response;
    }

    @Override
    public FindCarByGoodIdResponse findCarsByGoodId(FindCarByGoodIdRequest request) {
        FindCarByGoodIdResponse response = new FindCarByGoodIdResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Cars> carsByGoodId = carsService.findCarsByGoodId(request.getGoodId());
        PageInfo<Cars> pageInfo = new PageInfo<>(carsByGoodId);

        response.setCarDtoList(changeCarDto(pageInfo.getList()));
        response.setTotal(carsService.countCarsByGoodId(request.getGoodId()));
        return response;
    }

    @Override
    public FindCarByShopIdAndGoodIdResponse findCarsByShopIdAndGoodId(FindCarByShopIdAndGoodIdRequest request) {
        FindCarByShopIdAndGoodIdResponse response = new FindCarByShopIdAndGoodIdResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Cars> carsByShopIdAndGoodId = carsService.findCarsByShopIdAndGoodId(request.getShopId(), request.getGoodId());
        PageInfo<Cars> pageInfo = new PageInfo<>(carsByShopIdAndGoodId);

        response.setCarDtoList(changeCarDto(pageInfo.getList()));
        response.setTotal(carsService.countCarsByShopIdAndGoodId(request.getShopId(),request.getGoodId()));
        return response;
    }

    @Override
    public FindAllCarResponse findAllCars(FindAllCarRequest request) {
        FindAllCarResponse response = new FindAllCarResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Cars> allCars = carsService.findAllCars();
        PageInfo<Cars> pageInfo = new PageInfo<>(allCars);

        response.setCarDtoList(changeCarDto(pageInfo.getList()));
        response.setTotal(carsService.countAllCars());
        return response;
    }

    private List<CarDto> changeCarDto(List<Cars> carsList){
        List<CarDto> list = new ArrayList<>();
        for (Cars cars : carsList) {
            CarDto carDto = new CarDto();
            BeanUtils.copyProperties(cars,carDto);
            list.add(carDto);
        }
        return list;
    }
}
