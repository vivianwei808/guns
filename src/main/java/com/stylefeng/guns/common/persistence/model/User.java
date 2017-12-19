package com.stylefeng.guns.common.persistence.model;

import com.stylefeng.guns.common.constant.Const;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */
@Data
@ToString
public class User extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 地址
     */
    private String address;
    /**
     * 头像
     */
    private String  avatar;
    /**
     * 账号
     */
    private String  account;
    /**
     * 密码
     */
    private String  password;
    /**
     * md5密码盐
     */
    private String  salt;
    /**
     * 名字
     */
    private String  name;
    /**
     * 生日
     */
    private Date    birthday;
    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;
    /**
     * 电子邮件
     */
    private String  email;
    /**
     * 电话
     */
    private String  phone;
    /**
     * 角色id
     */
    private String  roleid;
    /**
     * 部门id
     */
    private Integer deptid;
    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date    createtime;
    /**
     * 保留字段
     */
    private Integer version;

}
