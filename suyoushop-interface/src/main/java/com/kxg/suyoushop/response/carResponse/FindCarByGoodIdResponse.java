package com.kxg.suyoushop.response.carResponse;

import com.kxg.suyoushop.dto.CarDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindCarByGoodIdResponse implements Serializable {
    private static final long serialVersionUID = 6112256487558706798L;

    private List<CarDto> carDtoList;

    private Integer total;
}
