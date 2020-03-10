package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindOrderByIdRequest implements Serializable {
    private static final long serialVersionUID = 5339768217545171645L;

    @NotNull
    private Long id;
}
