package cc.cleverfan.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author chengfan
 * @create 2017-06-03 下午8:56
 */
@Entity
@Table(name = "user_dir", schema = "editor", catalog = "")
public class UserDir {
    private int id;
    private int fkUserId;
    private String dirName;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private Collection<UserArticle> userArticlesById;
    private Users usersByFkUserId;

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
    @Column(name = "dir_name", nullable = false, length = 64)
    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "modify_time", nullable = true)
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDir userDir = (UserDir) o;

        if (id != userDir.id) return false;
        if (fkUserId != userDir.fkUserId) return false;
        if (dirName != null ? !dirName.equals(userDir.dirName) : userDir.dirName != null) return false;
        if (createTime != null ? !createTime.equals(userDir.createTime) : userDir.createTime != null) return false;
        if (modifyTime != null ? !modifyTime.equals(userDir.modifyTime) : userDir.modifyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkUserId;
        result = 31 * result + (dirName != null ? dirName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userDirByFkDirId")
    public Collection<UserArticle> getUserArticlesById() {
        return userArticlesById;
    }

    public void setUserArticlesById(Collection<UserArticle> userArticlesById) {
        this.userArticlesById = userArticlesById;
    }

    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Users getUsersByFkUserId() {
        return usersByFkUserId;
    }

    public void setUsersByFkUserId(Users usersByFkUserId) {
        this.usersByFkUserId = usersByFkUserId;
    }
}
