package com.stylefeng.guns.front;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.core.util.AesUtils;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.modular.front.dto.TokenDto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author wangwei
 * @date 2017/12/18
 */
public class LoginTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        TokenDto tokenDto = new TokenDto();
        tokenDto.setAccount("17738898274");
        tokenDto.setNowDate(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        String json = JSON.toJSONString(tokenDto);
        System.out.println("json="+json);
        String jsonEncode = AesUtils.encrypt(json, Const.TOKEN_PWD,"utf-8");
        String signrature = MD5Util.encrypt(MD5Util.encrypt(jsonEncode));
        String token = URLEncoder.encode(jsonEncode+"."+signrature);
        System.out.println(token);
    }
}
