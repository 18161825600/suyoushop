package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddOrderRequest implements Serializable {
    private static final long serialVersionUID = 806112139386007553L;

    private Long carId;

    private Double totalPriece;

    private Long userId;

    private Long shopId;
}
