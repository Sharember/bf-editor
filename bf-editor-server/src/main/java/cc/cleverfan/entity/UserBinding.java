package cc.cleverfan.entity;

import javax.persistence.*;

/**
 * @author chengfan
 * @create 2017-06-03 下午8:56
 */
@Entity
@Table(name = "user_binding", schema = "editor", catalog = "")
public class UserBinding {
    private int id;
    private int fkUserId;
    private int fkPlatformId;
    private String accountName;
    private String accountPassword;
    private String accountUrl;
    private String accountPhone;
    private String accountEmail;
    private Users usersByFkUserId;
    private Platform platformByFkPlatformId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fk_user_id", nullable = false)
    public int getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(int fkUserId) {
        this.fkUserId = fkUserId;
    }

    @Basic
    @Column(name = "fk_platform_id", nullable = false)
    public int getFkPlatformId() {
        return fkPlatformId;
    }

    public void setFkPlatformId(int fkPlatformId) {
        this.fkPlatformId = fkPlatformId;
    }

    @Basic
    @Column(name = "account_name", nullable = false, length = 64)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "account_password", nullable = false, length = 64)
    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    @Basic
    @Column(name = "account_url", nullable = true, length = 128)
    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    @Basic
    @Column(name = "account_phone", nullable = true, length = 32)
    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    @Basic
    @Column(name = "account_email", nullable = true, length = 32)
    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBinding that = (UserBinding) o;

        if (id != that.id) return false;
        if (fkUserId != that.fkUserId) return false;
        if (fkPlatformId != that.fkPlatformId) return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (accountPassword != null ? !accountPassword.equals(that.accountPassword) : that.accountPassword != null)
            return false;
        if (accountUrl != null ? !accountUrl.equals(that.accountUrl) : that.accountUrl != null) return false;
        if (accountPhone != null ? !accountPhone.equals(that.accountPhone) : that.accountPhone != null) return false;
        if (accountEmail != null ? !accountEmail.equals(that.accountEmail) : that.accountEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkUserId;
        result = 31 * result + fkPlatformId;
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (accountPassword != null ? accountPassword.hashCode() : 0);
        result = 31 * result + (accountUrl != null ? accountUrl.hashCode() : 0);
        result = 31 * result + (accountPhone != null ? accountPhone.hashCode() : 0);
        result = 31 * result + (accountEmail != null ? accountEmail.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Users getUsersByFkUserId() {
        return usersByFkUserId;
    }

    public void setUsersByFkUserId(Users usersByFkUserId) {
        this.usersByFkUserId = usersByFkUserId;
    }

    @ManyToOne
    @JoinColumn(name = "fk_platform_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Platform getPlatformByFkPlatformId() {
        return platformByFkPlatformId;
    }

    public void setPlatformByFkPlatformId(Platform platformByFkPlatformId) {
        this.platformByFkPlatformId = platformByFkPlatformId;
    }
}
