package com.kxg.suyoushop.response.UserResponse;

import com.kxg.suyoushop.dto.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindAllUserResponse implements Serializable {

    private List<UserDto> userDtoList;

    private Integer total;
}
