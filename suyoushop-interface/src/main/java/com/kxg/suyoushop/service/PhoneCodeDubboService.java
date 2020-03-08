package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.PhoneNumberCodeRequest;
import com.kxg.suyoushop.response.PhoneNumberCodeResponse;

public interface PhoneCodeDubboService {

    PhoneNumberCodeResponse code(PhoneNumberCodeRequest request);
}
