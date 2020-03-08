package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
public class UpdateUserImgRequest implements Serializable {

    private static final long serialVersionUID = 2250672540197514310L;

    @NotNull
    private Long id;

    @NotEmpty
    private String imgUrl;
}
