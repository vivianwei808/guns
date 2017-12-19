package com.stylefeng.guns.modular.front.entity;

import com.stylefeng.guns.common.persistence.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author wangweir
 * @date 17/12/17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OpenCard extends BaseEntity {

    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户手机号
     */
    @NotEmpty(message = "用户手机号不能为空")
    private String mobile;
}