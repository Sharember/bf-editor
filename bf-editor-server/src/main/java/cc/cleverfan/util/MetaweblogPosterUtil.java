package cc.cleverfan.util;

import cc.cleverfan.module.Blog;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chengfan
 * @create 2017-06-06 下午2:47
 */
public class MetaweblogPosterUtil {

    public String postBlog(String name, String password, Blog blog, String urls) throws MalformedURLException {
        return new MetaweblogPoster(new URL(urls)).post(name,password,blog);
    }
}
