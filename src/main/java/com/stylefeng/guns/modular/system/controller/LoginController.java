package com.stylefeng.guns.modular.system.controller;

import com.google.code.kaptcha.Constants;
import com.stylefeng.guns.common.constant.tips.Tip;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.exception.InvalidKaptchaException;
import com.stylefeng.guns.common.node.MenuNode;
import com.stylefeng.guns.common.persistence.dao.MenuMapper;
import com.stylefeng.guns.common.persistence.dao.UserMapper;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.core.log.LogManager;
import com.stylefeng.guns.core.log.factory.LogTaskFactory;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.shiro.ShiroUser;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.front.dto.UserLoginDto;
import com.stylefeng.guns.modular.front.exception.TokenException;
import com.stylefeng.guns.modular.front.service.IUserBasicService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.util.List;

import static com.stylefeng.guns.core.support.HttpKit.getIp;

/**
 * 登录控制器
 *
 * @author wangwei
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    IUserBasicService userBasicService;

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        //获取菜单列表
        List<Integer> roleList = ShiroKit.getUser().getRoleList();
        if(roleList == null || roleList.size() == 0){
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/login.html";
        }
        List<MenuNode> menus = menuMapper.getMenusByRoleIds(roleList);
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        model.addAttribute("titles", titles);

        //获取用户头像
        Integer id = ShiroKit.getUser().getId();
        User user = userMapper.selectByPrimaryKey(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);

        return "/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            return "/login.html";
        }
    }


    /**
     * 点击登录执行的动作
     */
    @ApiOperation("手机登录")
    @RequestMapping(value = "/loginXJH", method = RequestMethod.POST)
    @ResponseBody
    public Tip loginXJH(@ApiParam(value = "验证登录token",required = true) @RequestParam String token) {
        try {
            UserLoginDto dto = userBasicService.login(URLDecoder.decode(token));
            loginShiro(dto.getUsername(),dto.getPassword());
        }catch (TokenException te){
            throw new BussinessException(BizExceptionEnum.TOKEN_ERROR);
        } catch (Exception e){
            e.printStackTrace();
            throw new BussinessException(BizExceptionEnum.SYSTEM_ERROR);
        }

        return SUCCESS_TIP;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali() {

        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();

        //验证验证码是否正确
        if(ToolUtil.getKaptchaOnOff()){
            String kaptcha = super.getPara("kaptcha").trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(ToolUtil.isEmpty(kaptcha) || !kaptcha.equals(code)){
                throw new InvalidKaptchaException();
            }
        }

        loginShiro(username,password);

        return REDIRECT + "/";
    }

    private void loginShiro(String username,String password){
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        token.setRememberMe(true);

        currentUser.login(token);

        ShiroUser shiroUser = ShiroKit.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
        super.getSession().setAttribute("username", shiroUser.getAccount());

        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

        ShiroKit.getSession().setAttribute("sessionFlag",true);
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), getIp()));
        ShiroKit.getSubject().logout();
        return REDIRECT + "/login";
    }
}
