package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UpdateOrderStatusRequest implements Serializable {
    private static final long serialVersionUID = -617750578705559678L;

    @NotNull
    private Long id;

    private Short status;
}
