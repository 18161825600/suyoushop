package com.kxg.suyoushop.response.shopResponse;

import com.kxg.suyoushop.dto.ShopsDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginShopBySmsResponse implements Serializable {

    private static final long serialVersionUID = -8747574139763753595L;

    private ShopsDto shopsDto;

    private String token;

    private String msg;

}
