package com.kxg.suyoushop.response.userResponse;

import com.kxg.suyoushop.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
@Data
public class LoginUserResponse implements Serializable {

    private static final long serialVersionUID = 1254341110598664390L;
    private UserDto userDto;

    private String msg;

    private String token;
}
