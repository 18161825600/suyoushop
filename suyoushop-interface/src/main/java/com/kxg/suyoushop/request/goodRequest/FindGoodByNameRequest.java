package com.kxg.suyoushop.request.goodRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class FindGoodByNameRequest implements Serializable {
    private static final long serialVersionUID = 7311575269937695401L;

    @NotEmpty
    private String name;

    private Integer pageNum = 1;
}
