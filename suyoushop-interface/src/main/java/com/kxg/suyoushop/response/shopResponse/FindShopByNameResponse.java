package com.kxg.suyoushop.response.shopResponse;

import com.kxg.suyoushop.dto.ShopsDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindShopByNameResponse implements Serializable {
    private static final long serialVersionUID = -2461786073985540741L;

    private List<ShopsDto> shopsDtoList;

    private Integer total;
}
