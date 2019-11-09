package com.jk.controller;

import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.service.UserServiceFeign;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserControllerProvider implements UserServiceFeign {


    @Resource
    private UserService userService;

    @Override
    public List<TreeBean> findMyTree() {
        return userService.findMyTree();
    }

    @Override
    public int queryUser(@SpringQueryMap User user) {
        return userService.queryUser(user);
    }

    @Override
    public Map selectUserList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @SpringQueryMap User user) {
        return userService.selectUserList(page,rows,user);
    }

    @Override
    public User saveUser(User user) {
        return userService.saveUser(user);
    }
}
