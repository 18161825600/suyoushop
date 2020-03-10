package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindOrderByShopIdRequest implements Serializable {
    private static final long serialVersionUID = -3001764126309561871L;

    @NotNull
    private Long shopId;

    private Integer pageNum = 1;
}
