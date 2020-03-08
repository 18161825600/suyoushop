package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.shopsRequest.*;
import com.kxg.suyoushop.response.shopResponse.*;


public interface ShopsDubboService {

    RegisterShopsResponse registerShop(RegisterShopRequest request);

    LoginShopsResponse loginShop(LoginShopRequest request);

    LoginShopBySmsResponse loginShopBySms(LoginShopBySmsRequest request);

    DeleteShopsResponse delete(DeleteShopsRequest request);

    UpdateShopNameResponse updateShopName(UpdateShopNameRequest request);

    UpdateShopImgResponse updateShopImg(UpdateShopImgRequest request);

    UpdateShopPasswordByIdResponse updateShopPasswordById(UpdateShopPasswordByIdRequest request);

    UpdateShopPasswordByPhoneResponse updateShopPasswordByPhone(UpdateShopPasswordByPhoneRequest request);

    UpdateShopResponse updateShop(UpdateShopRequest request);

    FindShopsByIdResponse findShopsById(FindShopsByIdRequest request);

    FindShopByNameResponse findShopsByName(FindShopByNameRequest request);

    FindAllShopResponse findAllShops(FindAllShopRequest request);

}
