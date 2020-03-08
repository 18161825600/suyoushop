package com.kxg.suyoushop.response.goodResponse;

import com.kxg.suyoushop.dto.GoodsDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindGoodByNameResponse implements Serializable {
    private static final long serialVersionUID = 5324152941349832190L;

    private List<GoodsDto> goodsDtoList;

    private Integer total;
}
