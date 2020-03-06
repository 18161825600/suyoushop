package com.kxg.suyoushop.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenResponse implements Serializable {

    private String token;
}
