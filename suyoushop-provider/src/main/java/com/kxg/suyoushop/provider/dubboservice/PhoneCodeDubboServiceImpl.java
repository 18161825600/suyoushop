package com.kxg.suyoushop.provider.dubboservice;

import com.kxg.suyoushop.request.PhoneNumberCodeRequest;
import com.kxg.suyoushop.response.PhoneNumberCodeResponse;
import com.kxg.suyoushop.service.PhoneCodeDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Random;

@Slf4j
@Service(version = "1.0.0")
public class PhoneCodeDubboServiceImpl implements PhoneCodeDubboService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public PhoneNumberCodeResponse code(PhoneNumberCodeRequest request) {
        PhoneNumberCodeResponse response = new PhoneNumberCodeResponse();
        String code = getCode(request.getPhoneNumber());
        response.setCode(code);
        return response;
    }

    private String getCode(String phoneNum){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(new Random().nextInt(10));
        }
        log.info(stringBuilder.toString());
        stringRedisTemplate.opsForValue().set(phoneNum,stringBuilder.toString());
        return stringBuilder.toString();
    }
}
