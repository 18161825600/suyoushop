package com.kxg.suyoushop.response.orderResponse;

import com.kxg.suyoushop.dto.OrderDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindAllOrderResponse implements Serializable {
    private static final long serialVersionUID = 6792875624713280300L;

    private List<OrderDto> orderDtoList;

    private Integer total;
}
