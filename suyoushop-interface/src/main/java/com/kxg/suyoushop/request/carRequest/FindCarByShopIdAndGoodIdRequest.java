package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindCarByShopIdAndGoodIdRequest implements Serializable {
    private static final long serialVersionUID = -3244761387273649495L;

    @NotNull
    private Long shopId;

    @NotNull
    private Long goodId;

    private Integer pageNum = 1;
}
