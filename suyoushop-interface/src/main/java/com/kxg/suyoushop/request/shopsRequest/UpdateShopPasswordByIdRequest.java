package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateShopPasswordByIdRequest implements Serializable {
    private static final long serialVersionUID = 8279536501554264331L;

    @NotNull
    private Long id;

    @NotEmpty
    private String password;
}
