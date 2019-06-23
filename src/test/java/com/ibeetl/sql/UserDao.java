package com.ibeetl.sql;

import java.util.List;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

@SqlResource("user")
public interface UserDao extends BaseMapper<User> {
    List<User> select(String name);
    
    //可以直接写SQL 表是真实的表名
    @Sql("update user set age = ? where id = ?")
    public void updateAge(int age,int id);
}
