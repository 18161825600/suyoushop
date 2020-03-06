package com.kxg.suyoushop.provider.service.UserImpl;

import com.kxg.suyoushop.provider.dao.UserDao;
import com.kxg.suyoushop.provider.pojo.User;
import com.kxg.suyoushop.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(User user) {
        return userDao.register(user);
    }

    @Override
    public User selectUserById(Long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public User login(String phoneNumber, String password) {
        return userDao.login(phoneNumber, password);
    }

    @Override
    public Integer updateUserInfo(User user) {
        return userDao.updateUser(user);
    }


    @Override
    public Integer deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User findUserByPhone(String phoneNumber) {
        return userDao.findUserByPhone(phoneNumber);
    }


    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public Integer countAllUser() {
        return userDao.countAllUser();
    }

}
