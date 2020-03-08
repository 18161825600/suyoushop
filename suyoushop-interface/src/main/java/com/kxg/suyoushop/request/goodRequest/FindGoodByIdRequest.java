package com.kxg.suyoushop.request.goodRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindGoodByIdRequest implements Serializable {
    private static final long serialVersionUID = 3392547754728364229L;

    @NotNull
    private Long id;
}
