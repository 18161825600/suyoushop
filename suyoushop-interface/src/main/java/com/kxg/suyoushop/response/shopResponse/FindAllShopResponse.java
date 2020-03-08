package com.kxg.suyoushop.response.shopResponse;

import com.kxg.suyoushop.dto.ShopsDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FindAllShopResponse implements Serializable {
    private static final long serialVersionUID = -5701279731930794825L;

    private List<ShopsDto> shopsDtoList;

    private Integer total;
}
