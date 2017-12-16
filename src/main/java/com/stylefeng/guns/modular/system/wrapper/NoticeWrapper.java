package com.stylefeng.guns.modular.system.wrapper;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.warpper.BaseControllerWrapper;

import java.util.Map;

/**
 * 部门列表的包装
 *
 * @author wangwei
 * @date 2017年4月25日 18:10:31
 */
public class NoticeWrapper extends BaseControllerWrapper {

    public NoticeWrapper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Integer creater = (Integer) map.get("creater");
        map.put("createrName", ConstantFactory.me().getUserNameById(creater));
    }

}
