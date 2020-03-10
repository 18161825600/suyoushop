package com.kxg.suyoushop.request.orderRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindAllOrderRequest implements Serializable {
    private static final long serialVersionUID = 991235057762844432L;

    private Integer pageNum = 1;
}
