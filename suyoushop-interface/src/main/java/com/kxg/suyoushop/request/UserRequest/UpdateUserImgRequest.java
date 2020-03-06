package com.kxg.suyoushop.request.UserRequest;

import lombok.Data;

import java.io.Serializable;
@Data
public class UpdateUserImgRequest implements Serializable {

    private Long id;

    private String imgUrl;
}
