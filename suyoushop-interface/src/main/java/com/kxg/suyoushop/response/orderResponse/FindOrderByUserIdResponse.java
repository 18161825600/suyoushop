package com.kxg.suyoushop.response.orderResponse;

import com.kxg.suyoushop.dto.OrderDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindOrderByUserIdResponse implements Serializable {
    private static final long serialVersionUID = 5309525006048005975L;

    private List<OrderDto> orderDtoList;

    private Integer total;
}
