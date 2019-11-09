package com.jk.controller;

import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.service.UserServiceFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserServiceFeign userServiceFeign;


    @RequestMapping("findMyTree")
    @ResponseBody
    public List<TreeBean> findMyTree(HttpServletResponse response) throws IOException {

        List<TreeBean> treeBeanList = userServiceFeign.findMyTree();

        if (treeBeanList == null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！请稍后重试");
            printWriter.flush();
            printWriter.close();
        }

        return treeBeanList;
    }

    @RequestMapping("login")
    @ResponseBody
    public String  login(User user){

        System.out.println(user);
        int login =  userServiceFeign.queryUser(user);

        if(login == 2){
            return "登录成功";
        }else{
            return "账号或密码错误";
        }
    }

    @RequestMapping("selectUserList")
    @ResponseBody
    public Map selectUserList(Integer page, Integer rows, User user){
        return userServiceFeign.selectUserList(page,rows,user);
    }
    @RequestMapping("saveUser")
    @ResponseBody
    public User saveUser(User user){
        return userServiceFeign.saveUser(user);
    }
}
