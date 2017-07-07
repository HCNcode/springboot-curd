/*
 * 文件名：LoginController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月6日
 */

package forum.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import forum.entity.User;
import forum.service.UserService;

/**
 * 登录的控制器
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年7月6日
 * @see LoginController
 * @since
 */
@RestController
public class LoginController
{
    /**
     * UserService接口
     */
    @Autowired
    private UserService userService;

    //负责处理/index.html的请求
    @RequestMapping(value = "/index")
    public String LoginPage(){
        return "index";
    }

    //负责处理/loginCheck.html的请求
    @RequestMapping(value = "/loginCheck.html")
//    LoginCommand loginCommand = new LoginCommand(@RequestParam("userName") String userName,@RequestParam("password") String password);

    public String loginCheck(@RequestParam("userName") String userName,
                                   @RequestParam("password") String password,
                                   HttpServletRequest request){
        boolean isValidUser =
                userService.hasMatchUser(userName,password);
        if(!isValidUser){
            //return new ModelAndView("login","error","用户名或密码错误");
            return "login";
        }
        else {
            User user = userService.findUserByUserName(userName);
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user); //主要两步 1.更新t_user表 2.登录信息插入t_login_log表
            request.getSession().setAttribute("user",user);
           // return new ModelAndView("main");  //进入登录主界面
            return "main";
        }
    }
}
