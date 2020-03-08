package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class LoginUserBySmsRequest implements Serializable {
    private static final long serialVersionUID = 7663649141510706340L;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String code;
}
