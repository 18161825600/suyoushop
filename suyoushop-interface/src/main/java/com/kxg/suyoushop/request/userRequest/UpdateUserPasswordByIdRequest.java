package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateUserPasswordByIdRequest implements Serializable {

    private static final long serialVersionUID = -4978370440382963087L;

    @NotNull
    private Long id;

    @NotEmpty
    private String password;
}
