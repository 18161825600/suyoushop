package com.kxg.suyoushop.provider.service;

import com.kxg.suyoushop.provider.pojo.User;

import java.util.List;

public interface UserService {

    User login(String phoneNumber, String password);

    Integer updateUserInfo(User user);

    Integer deleteUser(Long id);

    User findUserByPhone(String phoneNumber);

    Integer register(User user);

    User selectUserById(Long id);

    List<User> selectAllUser();

    Integer countAllUser();
}
