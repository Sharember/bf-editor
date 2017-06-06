package cc.cleverfan.module;

/**
 * @author chengfan
 * @create 2017-04-22 上午10:18
 */
public class Blog {
    private String title;
    private String[] categories = new String[]{"默认"};
    private String description;
    private String content;

    public Blog(String title, String[] categories, String description, String content) {
        this.title = title;
        this.categories = categories;
        this.description = description;
        this.content = content;
    }

    public Blog() {
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
}
