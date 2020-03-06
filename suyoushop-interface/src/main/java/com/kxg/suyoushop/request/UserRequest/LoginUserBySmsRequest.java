package com.kxg.suyoushop.request.UserRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserBySmsRequest implements Serializable {
    private String phoneNumber;
    private String code;
}
