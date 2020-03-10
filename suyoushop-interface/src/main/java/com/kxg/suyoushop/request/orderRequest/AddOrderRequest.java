package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AddOrderRequest implements Serializable {
    private static final long serialVersionUID = 806112139386007553L;

    @NotNull
    private Long carId;

    @NotNull
    private Double totalPriece;

    private Short status;

    @NotNull
    private Long userId;

    @NotNull
    private Long shopId;
}
