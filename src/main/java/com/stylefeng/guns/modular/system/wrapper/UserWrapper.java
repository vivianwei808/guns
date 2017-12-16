package com.stylefeng.guns.modular.system.wrapper;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.warpper.BaseControllerWrapper;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的包装类
 *
 * @author wangwei
 * @date 2017年2月13日 下午10:47:03
 */
public class UserWrapper extends BaseControllerWrapper {

    public UserWrapper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("sexName", ConstantFactory.me().getSexName((Integer) map.get("sex")));
        map.put("roleName", ConstantFactory.me().getRoleName((String) map.get("roleid")));
        map.put("deptName", ConstantFactory.me().getDeptName((Integer) map.get("deptid")));
        map.put("statusName", ConstantFactory.me().getStatusName((Integer) map.get("status")));
    }

}
