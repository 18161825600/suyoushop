package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindCarByUserIdRequest implements Serializable {
    private static final long serialVersionUID = 9091608176617105944L;

    @NotNull
    private Long userId;

    private Integer pageNum = 1;
}
