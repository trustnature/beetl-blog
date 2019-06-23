package com.ibeetl.blog.service;

import com.ibeetl.blog.model.Blog;
import com.ibeetl.blog.model.Message;
import com.ibeetl.blog.model.User;
import org.beetl.sql.core.engine.PageQuery;

import java.util.List;

public interface BlogService {

    PageQuery<Blog> pageBlog(long pageNumber, long pageSize, String keyword,String category);

    /***
     * 查询留言内容
     * @param blogId
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageQuery<Message> pageMsg(Long blogId, long pageNumber, long pageSize);

    Blog getBlogById(Long blogId);

    void saveMessage(Message message);

    /***
     * 保存博客
     * @param blog
     */
    void saveBlog(Blog blog);

    List<String> listCategory();

    User login(String userName, String password);
}
