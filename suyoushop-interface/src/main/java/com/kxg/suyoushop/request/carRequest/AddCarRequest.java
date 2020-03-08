package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AddCarRequest implements Serializable {

    private static final long serialVersionUID = -5912699922518874258L;

    @NotNull
    private Long userId;

    @NotNull
    private Long goodsId;

    @NotNull
    private Long shopId;

    @NotEmpty
    private String goodName;

    @NotNull
    private Long numbers;

    @NotNull
    private Double totalPrice;

}
