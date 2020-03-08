package com.kxg.suyoushop.response.carResponse;

import com.kxg.suyoushop.dto.CarDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindCarByShopIdResponse implements Serializable {
    private static final long serialVersionUID = -4758746079926863678L;

    private List<CarDto> carDtoList;

    private Integer total;
}
