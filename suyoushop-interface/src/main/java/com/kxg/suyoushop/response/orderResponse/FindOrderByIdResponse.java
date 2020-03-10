package com.kxg.suyoushop.response.orderResponse;

import com.kxg.suyoushop.dto.OrderDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class FindOrderByIdResponse implements Serializable {
    private static final long serialVersionUID = 4276924397298810176L;

    private OrderDto orderDto;
}
