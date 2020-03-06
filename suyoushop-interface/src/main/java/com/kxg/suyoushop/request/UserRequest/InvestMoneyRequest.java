package com.kxg.suyoushop.request.UserRequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvestMoneyRequest implements Serializable {

    private Long id;

    private Double money;
}
