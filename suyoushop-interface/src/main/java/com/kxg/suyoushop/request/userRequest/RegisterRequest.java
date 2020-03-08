package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {

    private static final long serialVersionUID = 4537985609429671000L;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String code;

    @NotEmpty
    private String nickName;

    @NotEmpty
    private String password;
}
