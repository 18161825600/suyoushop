package com.kxg.suyoushop.service;



import com.kxg.suyoushop.request.goodRequest.*;
import com.kxg.suyoushop.response.goodResponse.*;

import java.util.List;

public interface GoodDubboService {

    AddGoodResponse addGood(AddGoodRequest request);

    DeleteGoodResponse deleteGood(DeleteGoodRequest request);

    UpdateGoodResponse updateGood(UpdateGoodRequest request);

    FindGoodByIdResponse findGoodById(FindGoodByIdRequest request);

    FindGoodByNameResponse findGoodByName(FindGoodByNameRequest request);

    FindGoodByPriceResponse findGoodByPrice(FindGoodByPriceRequest request);

    FindAllGoodResponse findAllGoods(FindAllGoodRequest request);
}
