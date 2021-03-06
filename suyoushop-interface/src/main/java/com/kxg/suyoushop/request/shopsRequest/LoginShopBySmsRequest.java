package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LoginShopBySmsRequest implements Serializable {
    private static final long serialVersionUID = 405798184497181642L;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String code;
}
