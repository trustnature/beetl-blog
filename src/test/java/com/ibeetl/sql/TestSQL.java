package com.ibeetl.sql;

import java.util.List;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.JPA2NameConversion;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.LambdaQuery;
import org.beetl.sql.core.query.Query;
import org.beetl.sql.ext.DebugInterceptor;
import org.junit.Before;
import org.junit.Test;

public class TestSQL {
	public static  SQLManager sqlManager = null;
	
	@Before
	public void before(){
		String mysqlDriver = "com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/beetlsql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false";
        String userName = "root";
        String password = "root";
        ConnectionSource source = ConnectionSourceHelper.getSimple(mysqlDriver, url, userName, password);
        DBStyle mysql = new MySqlStyle();
        //sql语句放在classpath的/sql目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        //数据库命名跟java命名一样，所以采用DefalutNameConversion，还有一个是UnderlinedNameConversion，下划线风格的
        //UnderlinedNameConversion nc = new  UnderlinedNameConversion();
        //DefaultNameConversion  dc = new DefaultNameConversion();
        JPA2NameConversion jc = new JPA2NameConversion();
        sqlManager = new SQLManager(mysql,loader,source,jc,new Interceptor[]{new DebugInterceptor()});
	}
	
	@Test
	public void test() {
		User user = new User();
		user.setAge(11);
		user.setName("xiao");
		sqlManager.insert(user);
	}
	
	@Test
	public void testQ() {
		int id=1;
		User user = new User();
        System.out.println("开始使用内置sql进行用户查询...");
        user=sqlManager.unique(User.class, id);
        System.out.println("使用内置sql进行用户查询完毕！！");
	}
	
	@Test
	public void testQ2() {
		//Query查询
		Query<User> userQuery = sqlManager.query(User.class);
		List<User> list1  = sqlManager.lambdaQuery(User.class).andEq(User::getName, "xian").orderBy(User::getCreateDate).select();
		List<User> users = userQuery.andLike("name", "xian").orderBy("id desc").select();
		for(User user: users ) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testQueryMd() {
		//使用user.md 文件里的select语句，文件中sql是真实的要执行的sql，表名是真实表名。
		User user = new User();
		user.setName("xian");
		List<User> users = sqlManager.select("user.select",User.class,user);
		for(User userT: users ) {
			System.out.println(userT);
		}
	}
	
	@Test
	public void testMapperQuery() {
		UserDao userDao = sqlManager.getMapper(UserDao.class);
		List<User> users = userDao.select("xian");
		for(User userT: users ) {
			System.out.println(userT);
		}
		userDao.updateAge(10, 1);
	}
	
	@Test
	public void testPage() {
		UserDao userDao = sqlManager.getMapper(UserDao.class);
		userDao.createLambdaQuery();
		LambdaQuery<User> query = userDao.createLambdaQuery()
	                .andEq(User::getRoleId, 1);
	    PageQuery<User> page = query.desc(User::getCreateDate).page(1, 2);
	    System.out.println(page.getTotalPage() + ":" + page.getTotalRow());
	}
}
