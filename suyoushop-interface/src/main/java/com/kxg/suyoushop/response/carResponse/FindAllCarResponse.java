package com.kxg.suyoushop.response.carResponse;

import com.kxg.suyoushop.dto.CarDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindAllCarResponse implements Serializable {
    private static final long serialVersionUID = -891096052346961816L;

    private List<CarDto> carDtoList;

    private Integer total;
}
