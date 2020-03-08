package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindCarByShopIdRequest implements Serializable {
    private static final long serialVersionUID = -2525261930441275380L;

    @NotNull
    private Long shopId;

    private Integer pageNum = 1;
}
