package com.stylefeng.guns.modular.system.wrapper;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.warpper.BaseControllerWrapper;
import com.stylefeng.guns.core.util.ToolUtil;

import java.util.Map;

/**
 * 部门列表的包装
 *
 * @author wangwei
 * @date 2017年4月25日 18:10:31
 */
public class DeptWrapper extends BaseControllerWrapper {

    public DeptWrapper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {

        Integer pid = (Integer) map.get("pid");

        if (ToolUtil.isEmpty(pid) || pid.equals(0)) {
            map.put("pName", "--");
        } else {
            map.put("pName", ConstantFactory.me().getDeptName(pid));
        }
    }

}
