package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class LoginUserRequest implements Serializable {
    private static final long serialVersionUID = -5269751038439721974L;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String password;
}
