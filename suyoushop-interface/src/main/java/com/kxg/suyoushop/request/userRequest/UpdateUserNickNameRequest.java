package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateUserNickNameRequest implements Serializable {

    private static final long serialVersionUID = 2000296705512776679L;

    @NotNull
    private Long id;

    @NotEmpty
    private String nickName;
}
