package com.kxg.suyoushop.response.orderResponse;

import com.kxg.suyoushop.dto.OrderDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindOrderByShopIdResponse implements Serializable {
    private static final long serialVersionUID = 1377777842854194408L;

    private List<OrderDto> orderDtoList;

    private Integer total;
}
