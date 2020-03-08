package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class InvestMoneyRequest implements Serializable {

    private static final long serialVersionUID = -3689309063966843655L;

    @NotNull
    private Long id;

    @NotNull
    private Double money;
}
