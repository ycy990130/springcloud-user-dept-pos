package com.jk.model;

import lombok.Data;

@Data
public class User {

    private Integer userId;

    private String  userName;

    private String  password;

    private Integer userPosId;

    private Integer userDeptId;

    private Double  userPay;

    private String  userMotto;

    private String userPosName;

    private String  userDeptName;

}
