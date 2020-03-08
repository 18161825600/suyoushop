package com.kxg.suyoushop.request.goodRequest;

import lombok.Data;


import java.io.Serializable;

@Data
public class FindGoodByPriceRequest implements Serializable {

    private Double minPrice = 0.0;

    private Double maxPrice = Double.MAX_VALUE;

    private Integer pageNum = 1;
}
