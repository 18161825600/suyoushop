package com.kxg.suyoushop.request.UserRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {

    private String phoneNumber;

    private String code;

    private String nickName;

    private String password;
}
