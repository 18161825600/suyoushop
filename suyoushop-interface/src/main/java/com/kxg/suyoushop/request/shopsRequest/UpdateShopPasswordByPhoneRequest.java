package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UpdateShopPasswordByPhoneRequest implements Serializable {
    private static final long serialVersionUID = 5951653170297204745L;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String code;

    @NotEmpty
    private String password;
}
