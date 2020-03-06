package com.kxg.suyoushop.request.UserRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindUserByIdRequest implements Serializable {

    private Long id;
}
