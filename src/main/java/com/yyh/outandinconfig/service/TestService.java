package com.yyh.outandinconfig.service;

import com.yyh.outandinconfig.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    public String test(){
        System.out.println("风儿方法执行");
        return "我是原来的风儿";
    }

    public List<Long> test2(){
        List<Long> arrayList= new ArrayList<>();
        arrayList.add(1L);
        arrayList.add(1L);
        return arrayList;
    }

    public void test3(Integer i,Long l){
    }

    public User test4(User user){
        return user;
    }

}
