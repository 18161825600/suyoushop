package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.carRequest.*;
import com.kxg.suyoushop.response.carResponse.*;

import java.util.List;

public interface CarsDubboService  {

    AddCarResponse addCars(AddCarRequest request);

    DeleteCarResponse deleteCar(DeleteCarRequest request);

    UpdateCarResponse updateCar(UpdateCarRequest request);

    FindCarByIdResponse findCarById(FindCarByIdRequest request);

    FindCarByUserIdResponse findCarsByUserId(FindCarByUserIdRequest request);

    FindCarByShopIdResponse findCarByShopId(FindCarByShopIdRequest request);

    FindCarByGoodIdResponse findCarsByGoodId(FindCarByGoodIdRequest request);

    FindCarByShopIdAndGoodIdResponse findCarsByShopIdAndGoodId(FindCarByShopIdAndGoodIdRequest request);

    FindAllCarResponse findAllCars(FindAllCarRequest request);
}
