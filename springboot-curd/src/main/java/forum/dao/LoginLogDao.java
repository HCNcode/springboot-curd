/*
 * 文件名：LoginLogDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月6日
 */

package forum.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import forum.entity.LoginLog;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年7月6日
 * @see LoginLogDao
 * @since
 */
@Repository
public class LoginLogDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired       //自动注入
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    //插入登录日志 SQL
    private final static String INSERT_LOGIN_LOG_SQL = " insert into t_login_log(user_id,ip,login_datetime)" +
            " values(?,?,?)";
    public void insertLoginLog (LoginLog loginLog){
        Object[] args = new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL,args);
    }
}
