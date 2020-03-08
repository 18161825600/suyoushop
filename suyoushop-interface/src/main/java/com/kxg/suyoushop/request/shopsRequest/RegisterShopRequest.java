package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class RegisterShopRequest implements Serializable {

    private static final long serialVersionUID = 3877563310771221036L;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String password;

    @NotEmpty
    private String code;

    @NotEmpty
    private String name;
}
