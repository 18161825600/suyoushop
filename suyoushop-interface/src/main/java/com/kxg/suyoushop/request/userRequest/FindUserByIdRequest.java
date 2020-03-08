package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindUserByIdRequest implements Serializable {

    private static final long serialVersionUID = 6691778669661258020L;

    @NotNull
    private Long id;
}
