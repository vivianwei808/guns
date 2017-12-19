package com.stylefeng.guns.modular.front.entity;

import com.stylefeng.guns.common.persistence.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

/**
 * @author wangweir
 * @date 17/12/17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ExchangeOrder extends BaseEntity {

    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 币种
     */
    private String currency;
    /**
     * 当前汇率
     */
    private BigDecimal rate;
    /**
     * 结汇金额
     */
    private BigDecimal exchangeAmt;
    /**
     * 预计结汇人民币
     */
    private BigDecimal expectAmt;
    /**
     * 实际结汇人民币
     */
    private BigDecimal actualAmt;
    /**
     * 结汇状态
     */
    private String status;
    /**
     * 交易记录
     */
    private String orderRecord;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 其他材料
     */
    private String other;
    /**
     * 用户手机号
     */
    @NotEmpty(message = "用户手机号不能为空")
    private String mobile;

}