package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindAllUserRequest implements Serializable {

    private static final long serialVersionUID = 2480054107953938424L;

    private Integer pageNum = 1;
}
