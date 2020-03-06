package com.kxg.suyoushop.request.UserRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateUserNickNameRequest implements Serializable {

    private Long id;

    private String nickName;
}
