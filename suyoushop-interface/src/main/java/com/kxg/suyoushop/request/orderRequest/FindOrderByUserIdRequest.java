package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindOrderByUserIdRequest implements Serializable {
    private static final long serialVersionUID = -8268949667849011185L;

    @NotNull
    private Long userId;

    private Integer pageNum = 1;
}
