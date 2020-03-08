package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateCarRequest implements Serializable {

    private static final long serialVersionUID = 1290002572121265515L;

    @NotNull
    private Long id;

    @NotNull
    private Long numbers;

    @NotNull
    private Double totalPrice;
}
