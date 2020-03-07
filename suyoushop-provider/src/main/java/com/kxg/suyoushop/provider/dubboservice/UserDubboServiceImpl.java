package com.kxg.suyoushop.provider.dubboservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kxg.suyoushop.dto.UserDto;
import com.kxg.suyoushop.request.TokenRequest;
import com.kxg.suyoushop.request.UserRequest.*;
import com.kxg.suyoushop.response.TokenResponse;
import com.kxg.suyoushop.response.UserResponse.*;
import com.kxg.suyoushop.service.UserDubboService;
import com.kxg.suyoushop.provider.pojo.User;
import com.kxg.suyoushop.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Service(version = "1.0.0")
public class UserDubboServiceImpl implements UserDubboService {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        RegisterResponse response = new RegisterResponse();
        if(request.getCode().equals(stringRedisTemplate.opsForValue().get(request.getPhoneNumber()))){
            BeanUtils.copyProperties(request,user);
            user.setExistMoney(0.0);
            user.setImgUrl("zzz");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userService.register(user);
            response.setInteger(1);
            return response;
        }else {
            response.setInteger(0);
            return response;
        }
    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) {
        User login = userService.login(request.getPhoneNumber(), request.getPassword());
        if(login != null){
            LoginUserResponse response = new LoginUserResponse();
            BeanUtils.copyProperties(login,response);
            response.setMsg("ok");
            return response;
        }
        return null;
    }

    @Override
    public LoginUserResponse loginBySms(LoginUserBySmsRequest request) {
        User login = userService.findUserByPhone(request.getPhoneNumber());
        LoginUserResponse response = new LoginUserResponse();
        if(request.getCode().equals(stringRedisTemplate.opsForValue().get(request.getPhoneNumber()))) {
            if (login != null) {
                BeanUtils.copyProperties(login, response);
                response.setMsg("ok");
                return response;
            }else {
                User user = new User();
                user.setPhoneNumber(request.getPhoneNumber());
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                userService.register(user);

                BeanUtils.copyProperties(user, response);
                response.setMsg("ok");
                return response;
            }
        }else {
            response.setMsg("验证码错误");
            return response;
        }
    }

    @Override
    public UpdateUserImgResponse updateUserImg(UpdateUserImgRequest request) {
        User user = userService.selectUserById(request.getId());
        user.setImgUrl(request.getImgUrl());
        user.setUpdateTime(new Date());

        UpdateUserImgResponse response = new UpdateUserImgResponse();
        response.setInteger(userService.updateUserInfo(user));
        return response;
    }

    @Override
    public UpdateUserPasswordByPhoneResponse updateUserPasswordByPhone(UpdateUserPasswordByPhoneRequest request) {
        User user = userService.findUserByPhone(request.getPhoneNumber());
        UpdateUserPasswordByPhoneResponse response = new UpdateUserPasswordByPhoneResponse();

        if(user != null) {
            if (request.getCode().equals(stringRedisTemplate.opsForValue().get(request.getPhoneNumber()))) {
                user.setPassword(request.getPassword());
                user.setUpdateTime(new Date());

                response.setInteger(userService.updateUserInfo(user));
                return response;
            } else {
                response.setInteger(-1);//验证码错误
                return response;
            }
        }else {
            response.setInteger(-2);//电话号错误
            return response;
        }
    }

    @Override
    public UpdateUserPasswordByIdResponse updateUserPasswordById(UpdateUserPasswordByIdRequest request) {
        User user = userService.selectUserById(request.getId());
        user.setPassword(request.getPassword());
        user.setUpdateTime(new Date());

        UpdateUserPasswordByIdResponse response = new UpdateUserPasswordByIdResponse();
        response.setInteger(userService.updateUserInfo(user));
        return response;
    }

    @Override
    public UpdateUserNickNameResponse updateUserNickName(UpdateUserNickNameRequest request) {
        User user = userService.selectUserById(request.getId());
        user.setNickName(request.getNickName());
        user.setUpdateTime(new Date());

        UpdateUserNickNameResponse response = new UpdateUserNickNameResponse();
        response.setInteger(userService.updateUserInfo(user));
        return response;
    }

    @Override
    public InvestMoneyResponse investMoney(InvestMoneyRequest request) {
        User user = userService.selectUserById(request.getId());
        user.setExistMoney(user.getExistMoney()+request.getMoney());
        user.setUpdateTime(new Date());

        InvestMoneyResponse response = new InvestMoneyResponse();
        response.setInteger(userService.updateUserInfo(user));
        return response;
    }

    @Override
    public FindUserByIdResponse findUserById(FindUserByIdRequest request) {
        User user = userService.selectUserById(request.getId());
        FindUserByIdResponse response = new FindUserByIdResponse();
        BeanUtils.copyProperties(user,response);
        return response;
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        response.setInteger(userService.deleteUser(request.getId()));
        return response;
    }

    @Override
    public FindAllUserResponse findAllUser(FindAllUserRequest request) {
        PageHelper.startPage(request.getPageNum(),10);
        List<User> users = userService.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(users);

        List<User> userList = pageInfo.getList();
        FindAllUserResponse response = new FindAllUserResponse();
        List<UserDto> list = new ArrayList<>();
        for (User user : userList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user,userDto);
            list.add(userDto);
        }
        response.setUserDtoList(list);
        response.setTotal(userService.countAllUser());
        return response;
    }

    @Override
    public TokenResponse code(TokenRequest request) {
        TokenResponse response = new TokenResponse();
        String code = getCode(request.getPhoneNumber());
        response.setToken(code);
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
