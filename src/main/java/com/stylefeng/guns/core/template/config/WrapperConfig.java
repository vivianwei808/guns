package com.stylefeng.guns.core.template.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao模板生成的配置
 *
 * @author wangwei
 * @date 2017-05-07 22:12
 */
@Data
public class WrapperConfig {

    private ContextConfig contextConfig;

    private String wrapperPathTemplate;
    private String packageName;//包名称
    private List<String> imports;//所引入的包

    public void init() {
        ArrayList<String> imports = new ArrayList<>();
        imports.add("com.stylefeng.guns.common.constant.factory.ConstantFactory");
        imports.add("com.stylefeng.guns.common.warpper.BaseControllerWrapper");
        imports.add("java.util.Map");

        imports.add("com.stylefeng.guns.modular."+contextConfig.getModuleName()+".warpper."+contextConfig.getBizEnBigName()+"Wrapper");

        this.imports = imports;
        this.packageName = "com.stylefeng.guns.modular." + contextConfig.getModuleName() + ".wrapper";
        this.wrapperPathTemplate = "\\src\\main\\java\\com\\stylefeng\\guns\\modular\\" + contextConfig.getModuleName() + "\\wrapper\\{}Wrapper.java";
    }

}
