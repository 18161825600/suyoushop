package com.kxg.suyoushop.request.userRequest;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DeleteUserRequest implements Serializable {
    private static final long serialVersionUID = 2770827071633295594L;

    @NotNull
    private Long id;
}
