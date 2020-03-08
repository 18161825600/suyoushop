package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UpdateUserPasswordByPhoneRequest implements Serializable {

    private static final long serialVersionUID = -4334883160800729740L;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String code;

    @NotEmpty
    private String password;
}
