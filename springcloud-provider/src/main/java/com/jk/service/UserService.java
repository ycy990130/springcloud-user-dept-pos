package com.jk.service;

import com.jk.model.TreeBean;
import com.jk.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<TreeBean> findMyTree();

    int queryUser(User user);

    Map selectUserList(Integer page, Integer rows, User user);

    User saveUser(User user);
}
