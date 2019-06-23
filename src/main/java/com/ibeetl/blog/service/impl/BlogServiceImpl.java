package com.ibeetl.blog.service.impl;

import com.ibeetl.blog.dao.BlogDao;
import com.ibeetl.blog.dao.MessageDao;
import com.ibeetl.blog.dao.UserDao;
import com.ibeetl.blog.model.Blog;
import com.ibeetl.blog.model.Message;
import com.ibeetl.blog.model.User;
import com.ibeetl.blog.service.BlogService;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.LambdaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;


    @Override
    public PageQuery<Blog> pageBlog(long pageNumber, long pageSize, String keyword, String category) {
        LambdaQuery<Blog> query = blogDao.createLambdaQuery()
                .andEq(Blog::getDeleteFlag, false);
        if (!StringUtils.isEmpty(keyword)) {
            query.andLike(Blog::getTitle, "%" + keyword.trim() + "%");
        }
        if (!StringUtils.isEmpty(category)) {
            query.andEq(Blog::getCategory, category);
        }
        if (pageNumber > 0 && pageSize > 0) {
            return query.desc(Blog::getCreateTime).page(pageNumber, pageSize);
        }
        return null;
    }

    @Override
    public PageQuery<Message> pageMsg(Long blogId, long pageNumber, long pageSize) {
        if (pageNumber < 1 || pageSize < 1 || blogId == null) {
            return null;
        }
        return messageDao.createLambdaQuery()
                .andEq(Message::getBlogId, blogId)
                .andEq(Message::getDeleteFlag, false)
                .desc(Message::getCreateTime)
                .page(pageNumber, pageSize);
    }

    @Override
    public Blog getBlogById(Long blogId) {
        return blogDao.createLambdaQuery().andEq(Blog::getId, blogId).single();
    }

    @Override
    public void saveMessage(Message message) {
        Date now = new Date();
        message.setCreateTime(now);
        message.setUpdateTime(now);
        message.setDeleteFlag(false);
        messageDao.createLambdaQuery().insert(message);
    }

    @Override
    public void saveBlog(Blog blog) {
        Date now = new Date();
        blog.setCreateTime(now);
        blog.setUpdateTime(now);
        blog.setDeleteFlag(false);
        blogDao.createLambdaQuery().insertSelective(blog);
    }

    @Override
    public List<String> listCategory() {
        List<Blog> blogList = blogDao.createLambdaQuery().groupBy("category").select();
        return blogList.stream().map(Blog::getCategory).filter(o -> o != null).collect(Collectors.toList());
    }

    @Override
    public User login(String userName, String password) {
        return userDao.createLambdaQuery()
                .andEq(User::getUserName, userName)
                .andEq(User::getPassword, password)
                .andEq(User::getDeleteFlag, false)
                .single();
    }

}
