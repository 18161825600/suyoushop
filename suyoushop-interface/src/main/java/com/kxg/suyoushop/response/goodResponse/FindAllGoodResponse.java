package com.kxg.suyoushop.response.goodResponse;

import com.kxg.suyoushop.dto.GoodsDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindAllGoodResponse implements Serializable {
    private static final long serialVersionUID = -1221675510106380308L;

    private List<GoodsDto> goodsDtoList;

    private Integer total;
}
