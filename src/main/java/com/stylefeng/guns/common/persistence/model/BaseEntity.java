package com.stylefeng.guns.common.persistence.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuzh
 * @since 2017/7/26.
 */
@Data
@ToString
public class BaseEntity extends Base {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    protected Integer id;

    protected Date createTime;
    protected Date updateTime = new Date();
}
