package com.kxg.suyoushop.response.shopResponse;

import com.kxg.suyoushop.dto.ShopsDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginShopsResponse implements Serializable {

    private static final long serialVersionUID = 6586556517941422029L;

    private ShopsDto shopsDto;

    private String token;

    private String msg;
}
