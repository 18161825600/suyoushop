package com.kxg.suyoushop.request.goodRequest;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AddGoodRequest implements Serializable {
    private static final long serialVersionUID = 8707463550674308910L;

    @NotNull
    private Long shopId;

    @NotEmpty
    private String name;

    @NotNull
    private Double price;

    @NotEmpty
    private String goodImg;

    @NotNull
    private Long existNumber;

    @NotNull
    private Short status;
}
