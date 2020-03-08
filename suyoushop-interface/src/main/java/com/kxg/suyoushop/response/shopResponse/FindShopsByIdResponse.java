package com.kxg.suyoushop.response.shopResponse;

import com.kxg.suyoushop.dto.ShopsDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class FindShopsByIdResponse implements Serializable {
    private static final long serialVersionUID = -546110481028814349L;

    private ShopsDto shopsDto;
}
