package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.TreeBean;
import com.jk.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;



    @Override
    public int queryUser(User user) {
        user = userMapper.queryUser(user);

        if(user == null){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public Map selectUserList(Integer page, Integer rows, User user) {
        HashMap<String, Object> result = new HashMap<>();

        HashMap<String, Object> params = new HashMap<>();

        params.put("user",user);

        int count = userMapper.findCount(user);
        result.put("total",count);

        params.put("start",(page-1)*rows);
        params.put("end",rows);

        List<User> goods = userMapper.findUserList(params);
        result.put("rows",goods);
        return result;
    }

    @Override
    public User saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public List<TreeBean> findMyTree() {
        Integer id = 0;
        return treeNode(id);
    }

    private List<TreeBean> treeNode(Integer id) {
        List<TreeBean> trees = userMapper.findTreeNodeList(id);
        for (TreeBean treeBean: trees) {
            Integer id2 = treeBean.getId();
            List<TreeBean> treeBeans = treeNode(id2);
            if (treeBeans != null && treeBeans.size()>0){
                treeBean.setNodes(treeBeans);
            }else{
                treeBean.setSelectable(true);
            }
        }
        return trees;
    }
}
