package com.kxg.suyoushop.response.carResponse;

import com.kxg.suyoushop.dto.CarDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindCarByShopIdAndGoodIdResponse implements Serializable {
    private static final long serialVersionUID = -3338435403604274106L;

    private List<CarDto> carDtoList;

    private Integer total;
}
