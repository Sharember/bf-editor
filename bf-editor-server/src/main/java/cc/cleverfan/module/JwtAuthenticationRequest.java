package cc.cleverfan.module;

/**
 * @author chengfan
 * @create 2017-05-03 上午10:32
 */
import java.io.Serializable;

public class  JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String userName;
    private String userPassword;

    public JwtAuthenticationRequest() {
    }

    public JwtAuthenticationRequest(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
