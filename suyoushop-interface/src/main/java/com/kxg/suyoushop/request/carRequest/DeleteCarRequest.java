package com.kxg.suyoushop.request.carRequest;

import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Data
public class DeleteCarRequest implements Serializable {
    private static final long serialVersionUID = -313025665195517731L;

    @Valid
    private List<Long> ids;
}
