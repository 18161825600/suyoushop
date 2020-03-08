package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateShopNameRequest implements Serializable {
    private static final long serialVersionUID = -1125973470324977452L;

    @NotNull
    private Long id;

    @NotEmpty
    private String name;
}
