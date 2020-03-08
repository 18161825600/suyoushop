package com.kxg.suyoushop.request.shopsRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DeleteShopsRequest implements Serializable {
    private static final long serialVersionUID = 4330912883105913438L;

    @NotNull
    private Long id;
}
