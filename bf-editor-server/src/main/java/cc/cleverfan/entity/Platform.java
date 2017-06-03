package cc.cleverfan.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author chengfan
 * @create 2017-06-03 下午8:56
 */
@Entity
public class Platform {
    private int id;
    private String platformName;
    private String platformHome;
    private int platformId;
    private int platformSupport;
    private Collection<UserBinding> userBindingsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "platform_name", nullable = false, length = 32)
    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Basic
    @Column(name = "platform_home", nullable = false, length = 64)
    public String getPlatformHome() {
        return platformHome;
    }

    public void setPlatformHome(String platformHome) {
        this.platformHome = platformHome;
    }

    @Basic
    @Column(name = "platform_id", nullable = false)
    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "platform_support", nullable = false)
    public int getPlatformSupport() {
        return platformSupport;
    }

    public void setPlatformSupport(int platformSupport) {
        this.platformSupport = platformSupport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Platform platform = (Platform) o;

        if (id != platform.id) return false;
        if (platformId != platform.platformId) return false;
        if (platformSupport != platform.platformSupport) return false;
        if (platformName != null ? !platformName.equals(platform.platformName) : platform.platformName != null)
            return false;
        if (platformHome != null ? !platformHome.equals(platform.platformHome) : platform.platformHome != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (platformName != null ? platformName.hashCode() : 0);
        result = 31 * result + (platformHome != null ? platformHome.hashCode() : 0);
        result = 31 * result + platformId;
        result = 31 * result + platformSupport;
        return result;
    }

    @OneToMany(mappedBy = "platformByFkPlatformId")
    public Collection<UserBinding> getUserBindingsById() {
        return userBindingsById;
    }

    public void setUserBindingsById(Collection<UserBinding> userBindingsById) {
        this.userBindingsById = userBindingsById;
    }
}
