package com.stylefeng.guns.common.persistence.dao;

import com.stylefeng.guns.modular.front.entity.Operation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 基本信息Dao
 *
 * @author wangwei
 * @Date 2017-12-17 12:02:50
 */
public interface OperationDao extends Mapper<Operation> {

    List<Map<String, Object>> list(@Param("condition") String condition);

}
