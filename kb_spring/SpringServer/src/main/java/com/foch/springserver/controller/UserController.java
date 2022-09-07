package com.foch.springserver.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foch.springserver.model.user.User;
import com.foch.springserver.model.user.UserDao;

@RestController
public class UserController {

    //user Service 의존성 주입
    @Autowired
    private UserDao userDao;

    //유저 정보 확인 url
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable("userId") String userId){
        User user = userDao.findUser(userId);
        return user;
    }

    //user가 qr코드를 찍었을때 호출되는 함수
    //필요 정보 : userId, business_number, pay
    @RequestMapping(value = "/user/{userId}")
    public boolean payPoint(@PathVariable("business_number") String business_number, @PathVariable("pay") int pay, @PathVariable("userId") String userId) {
        return userDao.payPoint(business_number, pay, userId);
    }

    asdfasdf
    //유저의 비밀번호를 변경하는 url
    @RequestMapping(value = "/user/{userId}/repassword")
    public boolean changePassword(@PathVariable("userId") String userId, @RequestBody String password){
        return userDao.ChangePassword(userId, password);
    }

    //유저 등록 url
    @RequestMapping("/user/sign-up")
    public User userSignUp(@RequestBody User user){
        User finder = userDao.findUser(user.getId());
        if(finder == null){
            userDao.addUser(user);
            return user;
        }
        else
            return null;
    }

    
}
