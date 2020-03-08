package com.kxg.suyoushop.response.carResponse;

import com.kxg.suyoushop.dto.CarDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindCarByUserIdResponse implements Serializable {

    private static final long serialVersionUID = -6015774313133349550L;

    private List<CarDto> carDtoList;

    private Integer total;
}
