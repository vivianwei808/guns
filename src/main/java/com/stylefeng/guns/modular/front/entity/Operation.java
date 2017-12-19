package com.stylefeng.guns.modular.front.entity;

import com.stylefeng.guns.common.persistence.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangweir
 * @date 17/12/17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Operation extends BaseEntity {

    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户名
     */
    private String userName;
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