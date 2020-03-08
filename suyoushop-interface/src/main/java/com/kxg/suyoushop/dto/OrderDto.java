package com.kxg.suyoushop.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderDto implements Serializable {
    private static final long serialVersionUID = -266258647757556766L;

    private Long id;

    private Long carId;

    private Short status;

    private String payCode;

    private Date createTime;

    private Date updateTime;

    private Double totalPriece;

    private Long userId;

    private Long shopId;
}
