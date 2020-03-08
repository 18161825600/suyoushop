package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindCarByIdRequest implements Serializable {
    private static final long serialVersionUID = -9186873260898330806L;

    @NotNull
    private Long id;
}
