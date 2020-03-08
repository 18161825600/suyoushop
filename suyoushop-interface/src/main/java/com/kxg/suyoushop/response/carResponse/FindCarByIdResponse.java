package com.kxg.suyoushop.response.carResponse;

import com.kxg.suyoushop.dto.CarDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class FindCarByIdResponse implements Serializable {
    private static final long serialVersionUID = -6420097965682671477L;

    private CarDto carDto;
}
