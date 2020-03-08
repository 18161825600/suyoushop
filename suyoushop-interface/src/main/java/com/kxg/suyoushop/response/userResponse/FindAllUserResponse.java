package com.kxg.suyoushop.response.userResponse;

import com.kxg.suyoushop.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindAllUserResponse implements Serializable {

    private static final long serialVersionUID = 658834755280642165L;
    private List<UserDto> userDtoList;

    private Integer total;
}
