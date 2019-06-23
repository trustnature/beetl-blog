package com.ibeetl.blog.web;

import com.ibeetl.blog.model.Blog;
import com.ibeetl.blog.model.Message;
import com.ibeetl.blog.model.User;
import com.ibeetl.blog.service.BlogService;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GavinKing
 * @ClassName: IndexController
 * @Description:
 * @date 2018/11/17
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                        @RequestParam(required = false, defaultValue = "8") Integer pageSize,
                        @RequestParam(required = false) String keyword,
                        @RequestParam(required = false) String category,
                        HttpServletRequest request) {
        PageQuery<Blog> pageQuery = blogService.pageBlog(pageNumber, pageSize, keyword, category);
        request.setAttribute("page", pageQuery);
        request.setAttribute("category", category);
        request.setAttribute("keyword", keyword);
        return "index.html";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Long id,
                         @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                         @RequestParam(required = false, defaultValue = "8") Integer pageSize,
                         HttpServletRequest request) {
        request.setAttribute("blog", blogService.getBlogById(id));
        request.setAttribute("msgPage", blogService.pageMsg(id, pageNumber, pageSize));
        return "single.html";
    }

    @GetMapping("/tags")
    public String tags(HttpServletRequest request) {
        request.setAttribute("categorys", blogService.listCategory());
        return "common/layout.html#tags";
    }

    @GetMapping("/createBlog")
    public String createBlog(HttpServletRequest request) {
        return "create.html";
    }

    @PostMapping("/saveBlog")
    public String saveBlog(
            Blog blog,
            HttpServletRequest request) {
        blogService.saveBlog(blog);
        return "redirect:/";
    }

    @PostMapping("/saveMessage")
    public String saveMessage(
            Message message,
            HttpServletRequest request) {
        blogService.saveMessage(message);
        return "redirect:/detail?id=" + message.getBlogId();
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String userName,
                        @RequestParam(required = false) String password,
                        HttpServletRequest request) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return "login.html";
        }

        //进行登录业务
        //根据用户名密码查询用户
        User user = blogService.login(userName, password);

        if (user == null) {
            return "login.html";
        }
        //用户信息放入session
        request.getSession().setAttribute("user", user);
        //跳转到首页
        return "redirect:/";

    }

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        return "test/test.html";
    }
}
