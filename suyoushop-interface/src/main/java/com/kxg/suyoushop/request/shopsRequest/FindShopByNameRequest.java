package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class FindShopByNameRequest implements Serializable {
    private static final long serialVersionUID = -8373745104418051690L;

    @NotEmpty
    private String name;

    private Integer pageNum;
}
