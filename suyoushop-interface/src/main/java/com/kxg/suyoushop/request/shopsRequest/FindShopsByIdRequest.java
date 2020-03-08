package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindShopsByIdRequest implements Serializable {
    private static final long serialVersionUID = 1568717999394137329L;

    @NotNull
    private Long id;
}
