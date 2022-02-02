package com.yyh.outandinconfig.controller;


import com.alibaba.fastjson.JSON;
import com.yyh.outandinconfig.pojo.User;
import com.yyh.outandinconfig.service.TestService;
import com.yyh.outandinconfig.service.UserService;
import com.yyh.outandinconfig.service.request.UserQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Resource
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/str")
    public String test() {
        System.out.println(testService.test());
        System.out.println(port);
        return port;
    }

    @GetMapping("/get/list")
    public String test2() {
        List<Long> longList = testService.test2();
        System.out.println(longList);
        return null;
    }

    @GetMapping("/get/args")
    public String test3() {
        testService.test3(12,34L);
        return null;
    }

    @GetMapping("/get/exception")
    public String test4() {
        String date  = "2021-10-07 10:23:21";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            //程序员必须处理的异常，非运行时异常，不处理就会在编译时报错
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("结果是："+d);
        return null;
    }

    @GetMapping("/get/newGet")
    public String test5() {
        User user = new User(1L,"风耀");
        System.out.println(testService.test4(user));
        User user2 = JSON.parseObject(JSON.toJSONString(user),User.class);
        return user2.toString();
    }

    @GetMapping("/jpa/test")
    public String jpaTest() {
        UserQueryRequest request = UserQueryRequest.builder().name("羽").build();
        List<User> userList = userService.getUserList(request);
        return userList.toString();
    }

    @GetMapping("/jpa/test2")
    public String jpaTest2() {
        User user = userService.add();
        return user.toString();
    }
}
