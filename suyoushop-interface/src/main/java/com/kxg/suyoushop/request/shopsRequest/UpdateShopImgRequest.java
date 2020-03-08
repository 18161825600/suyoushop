package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateShopImgRequest implements Serializable {
    private static final long serialVersionUID = 4436751481965298902L;

    @NotNull
    private Long id;

    @NotEmpty
    private String img;
}
