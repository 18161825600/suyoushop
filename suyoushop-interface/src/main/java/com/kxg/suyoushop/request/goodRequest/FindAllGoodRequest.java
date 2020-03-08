package com.kxg.suyoushop.request.goodRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindAllGoodRequest implements Serializable {
    private static final long serialVersionUID = 374425377226280935L;

    private Integer pageNum = 1;
}
