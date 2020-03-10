package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateOrderPayCodeRequest implements Serializable {
    private static final long serialVersionUID = -4554336634706387268L;

    @NotNull
    private Long id;

    @NotEmpty
    private String payCode;
}
