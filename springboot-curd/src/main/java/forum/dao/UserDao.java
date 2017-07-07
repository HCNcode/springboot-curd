/*
 * 文件名：UserDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月6日
 */

package forum.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import forum.entity.User;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年7月6日
 * @see UserDao
 * @since
 */
@Repository //持久层
public class UserDao
{
    private JdbcTemplate jdbcTemplate;
    @Autowired       //自动注入
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getMatchCount(String userName,String password){
        String sqlStr = " select * from t_user "
                +" where user_name = ? and password = ? ";
        //这里queryForInt（sqlStr,new Object[]{ userName,passwor}）;方法用不了，改为如下

        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(sqlStr,rowMapper,userName,password);
        if(users.size() == 0)
            return null;
        else
            return users.get(0);
    }

    //使用静态变量使类更具可读性，注意引号前后加空格防错
    private final static String MATCH_COUNT_SQL = " select count(*) from " +
            " t_user where user_name = ? and password = ?";
    private final static String UPDATE_LOGIN_INFO_SQL = " update t_user set "+
            " last_visit = ? ,last_ip = ? ,credits = ? where user_id = ?";

    public User findUserByUserName(final String userName){
       // final User user = new User();

        /*jdbcTemplate.query(MATCH_COUNT_SQL, new Object[]{userName},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(resultSet.getInt("credits"));
                    }
                });*/
        String sql = " select * from t_user where user_name = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql,rowMapper,userName);
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[]{ user.getLastVisit(),
        user.getLastIp(),user.getCredits(),user.getUserId()});
    }

    
}
