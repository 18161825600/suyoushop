package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindAllCarRequest implements Serializable {
    private static final long serialVersionUID = -7701027506656564020L;

    private Integer pageNum = 1;
}
