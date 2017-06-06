package cc.cleverfan.util;

import cc.cleverfan.module.Blog;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengfan
 * @create 2017-04-22 上午10:14
 */
class MetaweblogPoster {
    private URL blogUrl;
    private XmlRpcClient blogClient;

    public MetaweblogPoster(URL blogUrl) {
        this.blogUrl = blogUrl;
        this.initBlogClient();
    }

    public URL getBlogUrl() {
        return blogUrl;
    }

    /*
    * 初始化博客发送客户端
    */
    private void initBlogClient() {
        if (this.blogUrl != null) {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(this.blogUrl);
            config.setEncoding("UTF-8");
            config.setBasicEncoding("UTF-8");

            this.blogClient = new XmlRpcClient();

            blogClient.setConfig(config);

        }
    }

    /*
      * @name 发博文时需要的用户名
      *
      * @password 发博文时需要的密码
      *
      * @blogUrl 发博文时对应的metaweblog url
      *
      * @blog 要发送的博文对象,它存储了博文的标题,分类,标签,内容等信息
      */
    public String post(String name, String password, Blog blog) {
        try {
            Map<String, Object> post = new HashMap<>();
            post.put("title", blog.getTitle());// 标题
            post.put("categories", blog.getCategories());// 分类
            post.put("description", blog.getContent());// 内容
            //post.put("blogid" , "895030");
            Object[] params = new Object[]{"default", name, password, post, Boolean.TRUE};
            // 发布新博文
            return this.blogClient.execute("metaWeblog.newPost", params).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "failed_post";
        }
    }

//    public static void main(String[] args) throws MalformedURLException {
//        Blog blog = new Blog("111aaaa" , new String[]{"11","22"} , "123","123");
//        //System.out.println(new MetaweblogPoster(new URL("http://cleverfan.blog.51cto.com/xmlrpc.php")).post("377109151@qq.com", "cf958181127", blog));
//
//
//        //new MetaweblogPoster(new URL("http://write.blog.csdn.net/xmlrpc/index")).post("chengfan818@gmail.com","cf958181127",blog);
//        //new MetaweblogPoster(new URL("http://os.blog.163.com/word/")).post("m17706446847@163.com","cf958181127",blog);
//        new MetaweblogPoster(new URL("http://www.cnblogs.com/cleverfan/services/metaweblog.aspx")).post("cleverfan","cf958181127;",blog);
//    }
}
