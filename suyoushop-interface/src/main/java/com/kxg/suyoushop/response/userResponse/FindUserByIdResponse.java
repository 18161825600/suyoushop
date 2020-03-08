package com.kxg.suyoushop.response.userResponse;

import com.kxg.suyoushop.dto.UserDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class FindUserByIdResponse implements Serializable {

    private static final long serialVersionUID = -1363702330414272149L;
    private UserDto userDto;
}
