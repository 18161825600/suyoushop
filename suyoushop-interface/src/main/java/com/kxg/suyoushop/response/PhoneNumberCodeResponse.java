package com.kxg.suyoushop.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class PhoneNumberCodeResponse implements Serializable {

    private static final long serialVersionUID = -1567781492527770555L;
    private String code;
}
