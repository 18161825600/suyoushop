package com.kxg.suyoushop.request.goodRequest;

import com.kxg.suyoushop.dto.GoodsDto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UpdateGoodRequest implements Serializable {

    private static final long serialVersionUID = 3188545271890773371L;

    @NotEmpty
    private GoodsDto goodsDto;
}
