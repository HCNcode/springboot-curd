/*
 * 文件名：User.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月6日
 */

package forum.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年7月6日
 * @see User
 * @since
 */
@Entity
public class User
{
   @Id
    private int userId;
    private  String userName;
    private String password;
    private  int credits;
    private String lastIp;
    private Date lastVisit;
    
    public User(){
        
    }
    public int getUserId()
    {
        return userId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public int getCredits()
    {
        return credits;
    }
    public void setCredits(int credits)
    {
        this.credits = credits;
    }
    public String getLastIp()
    {
        return lastIp;
    }
    public void setLastIp(String lastIp)
    {
        this.lastIp = lastIp;
    }
    public Date getLastVisit()
    {
        return lastVisit;
    }
    public void setLastVisit(Date lastVisit)
    {
        this.lastVisit = lastVisit;
    }
    

}
