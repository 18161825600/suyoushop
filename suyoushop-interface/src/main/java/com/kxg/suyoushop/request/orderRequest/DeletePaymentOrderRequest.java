package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DeletePaymentOrderRequest implements Serializable {
    private static final long serialVersionUID = 5412517406768808918L;

    @NotNull
    private Long orderId;

}
