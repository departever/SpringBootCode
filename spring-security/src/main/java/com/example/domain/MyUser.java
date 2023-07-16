package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyUser implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * user_name
     */
    @NotBlank(message = "用户名不能为空")
    @Length(min = 2, max = 10, message = "用户名长度必须在2到10 之间")
    private String userName;

    /**
     * password
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码不能为空")
//    @Pattern(regexp = "[a-zA-Z]?")
    private String password;

    /**
     * nick_name
     */
    private String nickName;

    /**
     * phone
     */
    private String phone;

    /**
     * identity_num
     */
    private String identityNum;

    /**
     * 地址
     */
    private String address;

    /**
     * user普通用户，expert专家，admin管理员
     */
    private String role;

    /**
     * create_time
     */
    private String createTime;

    /**
     * update_time
     */
    private String updateTime;

    /**
     * 积分500
     */
    private Integer integral;

    /**
     * 信誉1，2，3，4，5
     */
    private Integer credit;

    /**
     * 头像
     */
    private String avatar;

    /**
     * real_name
     */
    private String realName;
}


