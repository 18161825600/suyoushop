package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindAllShopRequest implements Serializable {
    private static final long serialVersionUID = -6770909544269733231L;

    private Integer pageNum = 1;
}
