package com.kxg.suyoushop.request.goodRequest;

import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Data
public class DeleteGoodRequest implements Serializable {
    private static final long serialVersionUID = 1786637374028243321L;

    @Valid
    private List<Long> ids;
}
