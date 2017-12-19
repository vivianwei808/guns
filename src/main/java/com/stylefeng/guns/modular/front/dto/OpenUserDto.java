package com.stylefeng.guns.modular.front.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author wangwei
 * @date 2017/12/18
 */
@Data
@ToString
@ApiModel(value="user对象",description="用户对象user")
public class OpenUserDto implements Serializable{

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    /**
     * 地址
     */
    private String address;

    /**
     * 电子邮件
     */
    @Email
    private String  email;
    /**
     * 电话
     */
    @NotEmpty(message = "用户手机号不能为空")
    private String  phone;

    /**************************************************************8
     *
     */
    /**
     * 身份证照片背面
     */
    @NotEmpty(message = "身份证背面不能为空")
    private String idCardBack;
    /**
     * 身份证照片正面
     */
    @NotEmpty(message = "身份证正面不能为空")
    private String idCardFront;
    /**
     * 身份证号码
     */
    @NotEmpty(message = "身份证号码不能为空")
    private String idCardNo;

    /**************************************************************8
    /**
     * 运营平台地址
     */
    private String platformUrl;
    /**
     * 交易记录
     */
    private String orderRecord;
    /**
     * 运营平台
     */
    private String platform;
    /**
     * 贸易类型
     */
    private String operationType;

}
