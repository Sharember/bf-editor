package cc.cleverfan.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author chengfan
 * @create 2017-06-03 下午8:56
 */
@Entity
public class Users {
    private int id;
    private String userName;
    private String userPassword;
    private String userRole;
    private String userPhone;
    private String userEmail;
    private String userIdCard;
    private Timestamp lastPasswordResetDate;
    private Collection<UserBinding> userBindingsById;
    private Collection<UserDir> userDirsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 128)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 256)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_role", nullable = true, length = 32)
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "user_phone", nullable = true, length = 32)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_email", nullable = true, length = 64)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_id_card", nullable = true, length = 32)
    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    @Basic
    @Column(name = "last_password_resetDate", nullable = true)
    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Users users = (Users) o;

        if (id != users.id) {
            return false;
        }
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) {
            return false;
        }
        if (userPassword != null ? !userPassword.equals(users.userPassword) : users.userPassword != null) {
            return false;
        }
        if (userRole != null ? !userRole.equals(users.userRole) : users.userRole != null) {
            return false;
        }
        if (userPhone != null ? !userPhone.equals(users.userPhone) : users.userPhone != null) {
            return false;
        }
        if (userEmail != null ? !userEmail.equals(users.userEmail) : users.userEmail != null) {
            return false;
        }
        if (userIdCard != null ? !userIdCard.equals(users.userIdCard) : users.userIdCard != null) {
            return false;
        }
        if (lastPasswordResetDate != null ? !lastPasswordResetDate.equals(users.lastPasswordResetDate) : users.lastPasswordResetDate != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userIdCard != null ? userIdCard.hashCode() : 0);
        result = 31 * result + (lastPasswordResetDate != null ? lastPasswordResetDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByFkUserId")
    public Collection<UserBinding> getUserBindingsById() {
        return userBindingsById;
    }

    public void setUserBindingsById(Collection<UserBinding> userBindingsById) {
        this.userBindingsById = userBindingsById;
    }

    @OneToMany(mappedBy = "usersByFkUserId")
    public Collection<UserDir> getUserDirsById() {
        return userDirsById;
    }

    public void setUserDirsById(Collection<UserDir> userDirsById) {
        this.userDirsById = userDirsById;
    }
}
