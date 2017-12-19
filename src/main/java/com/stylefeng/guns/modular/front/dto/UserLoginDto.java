package com.stylefeng.guns.modular.front.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangwei
 * @date 2017/12/17
 */
@Data
public class UserLoginDto implements Serializable {

    private String username;
    private String password;
}
