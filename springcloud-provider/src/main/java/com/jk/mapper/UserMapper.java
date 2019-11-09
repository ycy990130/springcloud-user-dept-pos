package com.jk.mapper;

import com.jk.model.TreeBean;
import com.jk.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {


    @Select("select id,url as path,pid,text from t_power where pid = #{value}")
    List<TreeBean> findTreeNodeList(Integer id);

    @Select("select * from t_userdeptpos where userName = #{userName} and password = #{password}")
    User queryUser(User usemyr);

    int findCount(User user);

    List<User> findUserList(HashMap<String, Object> params);

    @Insert("insert into t_userdeptpos (userName,password,userPosId,userDeptId,userPay,userMotto,userPosName,userDeptName) values(#{userName},#{password},#{userPosId},#{userDeptId},#{userPay},#{userMotto},#{userPosName},#{userDeptName})")
    User saveUser(User user);
}
