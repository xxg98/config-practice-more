package com.yyh.outandinconfig.service;

import com.yyh.outandinconfig.dao.UserRepository;
import com.yyh.outandinconfig.pojo.User;
import com.yyh.outandinconfig.service.request.UserQueryRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public List<User> getUserList(UserQueryRequest request){
        List<User> userList = userRepository.findAll(request.getWhereCriteria());
        return userList;
    }

    public User add(){
        User user = new User();
        user.setName("天羽");
        user.setStr("选择");
        User userSave = userRepository.save(user);
        return userSave;
    }
}
