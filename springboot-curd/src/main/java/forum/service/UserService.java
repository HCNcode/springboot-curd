/*
 * 文件名：UserService.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月6日
 */

package forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import forum.dao.LoginLogDao;
import forum.dao.UserDao;
import forum.entity.LoginLog;
import forum.entity.User;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年7月6日
 * @see UserService
 * @since
 */
@Service     //业务层
public class UserService
{
    private UserDao userDao;
    private LoginLogDao loginLogDao;


    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao){
        this.loginLogDao = loginLogDao;
    }


    public boolean hasMatchUser(String userName,String password){
        User isUser = userDao.getMatchCount(userName, password);

        if(isUser != null)
            return true;
        else
            return false;
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    @Transactional  //用事务管理
    public void loginSuccess(User user){
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
