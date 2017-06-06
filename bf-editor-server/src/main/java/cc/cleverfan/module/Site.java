package cc.cleverfan.module;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengfan
 * @create 2017-06-06 下午8:06
 */
public class Site {
    @JsonProperty
    private String name;
    @JsonProperty
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
