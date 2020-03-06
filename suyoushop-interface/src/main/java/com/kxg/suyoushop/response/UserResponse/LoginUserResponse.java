package com.kxg.suyoushop.response.UserResponse;

import com.kxg.suyoushop.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
@Data
public class LoginUserResponse implements Serializable {

    private UserDto userDto;

    private String msg;
}
