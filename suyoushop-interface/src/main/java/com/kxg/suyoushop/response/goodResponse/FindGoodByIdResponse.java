package com.kxg.suyoushop.response.goodResponse;

import com.kxg.suyoushop.dto.GoodsDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class FindGoodByIdResponse implements Serializable {
    private static final long serialVersionUID = 6217936622141965262L;

    private GoodsDto goodsDto;
}
