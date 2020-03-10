package com.kxg.suyoushop.response.orderResponse;

import com.kxg.suyoushop.dto.OrderDto;
import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindOrderByUserIdAndStatusResponse implements Serializable {
    private static final long serialVersionUID = 2213361040271419102L;

    private List<OrderDto> orderDtoList;

    private Integer total;
}
