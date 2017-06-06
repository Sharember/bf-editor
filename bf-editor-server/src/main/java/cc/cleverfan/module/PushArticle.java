package cc.cleverfan.module;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengfan
 * @create 2017-06-06 下午2:54
 */
public class PushArticle {
    @JsonProperty
    private int userId;
    @JsonProperty
    private String title;
    @JsonProperty
    private String[] categories;
    @JsonProperty
    private String description;
    @JsonProperty
    private String content;
    @JsonProperty
    private List<Site> postSite;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostSite(List<Site> postSite) {
        this.postSite = postSite;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String[] getCategories() {
        return categories;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public List<Site> getPostSite() {
        return postSite;
    }
}
