package com.kxg.suyoushop.request.UserRequest;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
public class UpdateUserPasswordByPhoneRequest implements Serializable {

    private String phoneNum;

    private String code;

    private String password;
}
