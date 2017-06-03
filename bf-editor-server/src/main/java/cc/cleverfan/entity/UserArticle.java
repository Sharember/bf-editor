package cc.cleverfan.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chengfan
 * @create 2017-06-03 下午8:56
 */
@Entity
@Table(name = "user_article", schema = "editor", catalog = "")
public class UserArticle {
    private int id;
    private int fkDirId;
    private String articleTitle;
    private String articleShortContent;
    private String articleComments;
    private Integer postStatus;
    private String postLists;
    private Integer modifyStatus;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private UserDir userDirByFkDirId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fk_dir_id", nullable = false)
    public int getFkDirId() {
        return fkDirId;
    }

    public void setFkDirId(int fkDirId) {
        this.fkDirId = fkDirId;
    }

    @Basic
    @Column(name = "article_title", nullable = false, length = 100)
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "article_short_content", nullable = false, length = 100)
    public String getArticleShortContent() {
        return articleShortContent;
    }

    public void setArticleShortContent(String articleShortContent) {
        this.articleShortContent = articleShortContent;
    }

    @Basic
    @Column(name = "article_comments", nullable = false, length = 100)
    public String getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(String articleComments) {
        this.articleComments = articleComments;
    }

    @Basic
    @Column(name = "post_status", nullable = true)
    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    @Basic
    @Column(name = "post_lists", nullable = true, length = 32)
    public String getPostLists() {
        return postLists;
    }

    public void setPostLists(String postLists) {
        this.postLists = postLists;
    }

    @Basic
    @Column(name = "modify_status", nullable = true)
    public Integer getModifyStatus() {
        return modifyStatus;
    }

    public void setModifyStatus(Integer modifyStatus) {
        this.modifyStatus = modifyStatus;
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

        UserArticle that = (UserArticle) o;

        if (id != that.id) return false;
        if (fkDirId != that.fkDirId) return false;
        if (articleTitle != null ? !articleTitle.equals(that.articleTitle) : that.articleTitle != null) return false;
        if (articleShortContent != null ? !articleShortContent.equals(that.articleShortContent) : that.articleShortContent != null)
            return false;
        if (articleComments != null ? !articleComments.equals(that.articleComments) : that.articleComments != null)
            return false;
        if (postStatus != null ? !postStatus.equals(that.postStatus) : that.postStatus != null) return false;
        if (postLists != null ? !postLists.equals(that.postLists) : that.postLists != null) return false;
        if (modifyStatus != null ? !modifyStatus.equals(that.modifyStatus) : that.modifyStatus != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (modifyTime != null ? !modifyTime.equals(that.modifyTime) : that.modifyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkDirId;
        result = 31 * result + (articleTitle != null ? articleTitle.hashCode() : 0);
        result = 31 * result + (articleShortContent != null ? articleShortContent.hashCode() : 0);
        result = 31 * result + (articleComments != null ? articleComments.hashCode() : 0);
        result = 31 * result + (postStatus != null ? postStatus.hashCode() : 0);
        result = 31 * result + (postLists != null ? postLists.hashCode() : 0);
        result = 31 * result + (modifyStatus != null ? modifyStatus.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_dir_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public UserDir getUserDirByFkDirId() {
        return userDirByFkDirId;
    }

    public void setUserDirByFkDirId(UserDir userDirByFkDirId) {
        this.userDirByFkDirId = userDirByFkDirId;
    }
}
