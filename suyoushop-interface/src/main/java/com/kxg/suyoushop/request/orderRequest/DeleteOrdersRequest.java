package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Data
public class DeleteOrdersRequest implements Serializable {
    private static final long serialVersionUID = 174645378349666407L;

    @Valid
    private List<Long> ids;
}
