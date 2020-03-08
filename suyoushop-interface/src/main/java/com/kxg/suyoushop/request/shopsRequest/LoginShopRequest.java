package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class LoginShopRequest implements Serializable {

    private static final long serialVersionUID = 7846754154551541306L;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String password;
}
