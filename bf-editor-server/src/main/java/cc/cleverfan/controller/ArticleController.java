package cc.cleverfan.controller;

import cc.cleverfan.entity.UserBinding;
import cc.cleverfan.module.Blog;
import cc.cleverfan.module.PushArticle;
import cc.cleverfan.module.Site;
import cc.cleverfan.service.UserBindingService;
import cc.cleverfan.util.MetaweblogPosterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengfan
 * @create 2017-06-06 下午2:19
 */
@RestController
public class ArticleController {
    @Autowired
    private UserBindingService userBindingService;

    @RequestMapping(value = "/auth/article",method = RequestMethod.POST)
    public String post(@RequestBody PushArticle pushArticle){
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> siteNum = new ArrayList<>();
        for (Site site : pushArticle.getPostSite()) {
            switch (site.getName()) {
                case "网易博客" :
                    siteNum.add(2);
                    break;
                case "博客园" :
                    siteNum.add(3);
                    break;
                default:
            }
        }
        //查找url
        List<UserBinding> userBindingList = userBindingService.getUserBindingsByUserId(pushArticle.getUserId());
        //拼接blog数据 发送
        for (UserBinding userBinding : userBindingList) {
            if ( ! siteNum.contains(userBinding.getFkPlatformId())){
                break;
            }
            Blog blog = new Blog();
            blog.setTitle(pushArticle.getTitle());
            blog.setContent(pushArticle.getContent());
            blog.setDescription(pushArticle.getDescription());

            try {
                new MetaweblogPosterUtil().postBlog(userBinding.getAccountName(), userBinding.getAccountPassword(), blog, userBinding.getAccountUrl());
                stringBuilder.append("success :").append(userBinding.getAccountUrl()).append("=> 发送成功").append("\n");

            } catch (MalformedURLException e) {
                stringBuilder.append("error :").append(userBinding.getAccountUrl()).append("=> 发送失败").append("\n");
            }
        }
        //拼接article数据  存入数据库
        return stringBuilder.toString();
    }
}
