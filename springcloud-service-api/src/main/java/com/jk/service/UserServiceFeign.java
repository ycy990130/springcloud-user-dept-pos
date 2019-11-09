package com.jk.service;

import com.jk.model.TreeBean;
import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "provider",fallback = UserServiceHystrix.class)
public interface UserServiceFeign {

    @GetMapping("findMyTree")
    List<TreeBean> findMyTree();

    @PostMapping("queryUser")
    int queryUser(@SpringQueryMap User user);

    @GetMapping("selectUserList")
    Map selectUserList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @SpringQueryMap User user);

    @PostMapping("saveUser")
    User saveUser(@SpringQueryMap User user);
}
