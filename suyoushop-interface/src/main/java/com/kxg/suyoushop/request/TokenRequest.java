package com.kxg.suyoushop.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenRequest implements Serializable {

    private String phoneNum;
}
