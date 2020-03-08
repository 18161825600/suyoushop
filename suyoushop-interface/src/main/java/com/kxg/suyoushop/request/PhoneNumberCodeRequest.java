package com.kxg.suyoushop.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class PhoneNumberCodeRequest implements Serializable {

    private static final long serialVersionUID = -5838367779784241418L;

    @NotEmpty
    private String phoneNumber;
}
