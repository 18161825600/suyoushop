package com.kxg.suyoushop.response.shopResponse;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateShopPasswordByPhoneResponse implements Serializable {
    private static final long serialVersionUID = 1457549345719280523L;

    private Integer integer;

    private String msg;
}
