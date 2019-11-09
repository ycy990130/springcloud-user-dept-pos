package com.jk.service;

import com.jk.model.TreeBean;
import com.jk.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserServiceHystrix implements UserServiceFeign {

    public List<TreeBean> findMyTree() {
        return null;
    }

    public int queryUser(User user) {
        return 0;
    }

    public Map selectUserList(Integer page, Integer rows, User user) {
        return null;
    }
}
