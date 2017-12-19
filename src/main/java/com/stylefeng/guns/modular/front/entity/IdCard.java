package com.stylefeng.guns.modular.front.entity;

import com.stylefeng.guns.common.persistence.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author wangweir
 * @date 17/12/17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class IdCard extends BaseEntity {
    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 身份证照片背面
     */
    private String idCardBack;
    /**
     * 身份证照片正面
     */
    private String idCardFront;
    /**
     * 身份证号码
     */
    private String idCardNo;
}