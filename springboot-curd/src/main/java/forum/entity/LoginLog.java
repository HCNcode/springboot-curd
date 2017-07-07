/*
 * 文件名：LoginLog.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月6日
 */

package forum.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年7月6日
 * @see LoginLog
 * @since
 */
@Entity
public class LoginLog implements Serializable
{
    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 13L;
    @Id
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public LoginLog(){

    }
    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
