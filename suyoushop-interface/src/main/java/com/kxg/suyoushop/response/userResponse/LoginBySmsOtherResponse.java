package com.kxg.suyoushop.response.userResponse;

import com.kxg.suyoushop.dto.UserDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginBySmsOtherResponse implements Serializable {

    private static final long serialVersionUID = 5325710290803945587L;
    private UserDto userDto;

    private String msg;

    private String token;
}
