package com.kxg.suyoushop.provider.dao;

import com.kxg.suyoushop.provider.mapper.UserMapper;
import com.kxg.suyoushop.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public Integer register(User user){
        return userMapper.insert(user);
    }

    public Integer deleteUser(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public Integer updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User login(String phoneNum,String password){
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("phoneNum",phoneNum)
                .andEqualTo("password",password);
        return userMapper.selectOneByExample(example);
    }

    public User findUserByPhone(String phoneNum){
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("phoneNum",phoneNum);
        return userMapper.selectOneByExample(example);
    }

    public User selectUserById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectAllUser(){
        return userMapper.selectAll();
    }

    public Integer countAllUser(){
        Example example = new Example(User.class);
        return userMapper.selectCountByExample(example);
    }
}
