package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindOrderByUserIdAndStatusRequest implements Serializable {
    private static final long serialVersionUID = -2472725636973865446L;

    @NotNull
    private Long userId;

    @NotNull
    private Short status;

    private Integer pageNum = 1;
}
