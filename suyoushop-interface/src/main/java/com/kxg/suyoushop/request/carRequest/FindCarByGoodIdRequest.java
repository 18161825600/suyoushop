package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindCarByGoodIdRequest implements Serializable {
    private static final long serialVersionUID = 3827276101045163847L;

    @NotNull
    private Long goodId;

    private Integer pageNum = 1;
}
