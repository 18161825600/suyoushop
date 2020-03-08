package com.kxg.suyoushop.request.shopsRequest;

import com.kxg.suyoushop.dto.ShopsDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateShopRequest implements Serializable {
    private static final long serialVersionUID = -7351509953600614339L;

    private ShopsDto shopsDto;
}
