package com.kxg.suyoushop.request.UserRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindAllUserRequest implements Serializable {

    private Integer pageNum;
}
