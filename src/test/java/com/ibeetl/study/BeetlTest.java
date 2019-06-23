package com.ibeetl.study;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.junit.Test;

public class BeetlTest {

	@Test
	public void test1() throws IOException {
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("hello,${name}");
		t.binding("name", "beetl");
		String str = t.render();
		System.out.println(str);
	}

	@Test
	public void testBase() throws IOException {
		// new一个模板资源加载器
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		/*
		 * 使用Beetl默认的配置。 Beetl可以使用配置文件的方式去配置，但由于此处是直接上手的例子， 我们不去管配置的问题，只需要基本的默认配置就可以了。
		 */
		Configuration config = Configuration.defaultConfiguration();
		// Beetl的核心GroupTemplate
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, config);
		// 我们自定义的模板，其中${title}就Beetl默认的占位符
		String testTemplate = "<html>\n" + "<head>\n" + "\t<title>${title}</title>\n" + "</head>\n" + "<body>\n"
				+ "\t<h1>${name}</h1>\n" + "</body>\n" + "</html>";
		Template template = groupTemplate.getTemplate(testTemplate);
		template.binding("title", "This is a test template Email.");
		template.binding("name", "beetl");
		// 渲染字符串
		String str = template.render();
		System.out.println(str);
	}

	@Test
	public void testMap() throws IOException {
		// new一个模板资源加载器
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		/*
		 * 使用Beetl默认的配置。 Beetl可以使用配置文件的方式去配置，但由于此处是直接上手的例子， 我们不去管配置的问题，只需要基本的默认配置就可以了。
		 */
		Configuration config = Configuration.defaultConfiguration();
		// Beetl的核心GroupTemplate
		GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, config);
		String testTemplate = "<html>\n" + "<head>\n" + "\t<title>This is a test template Email.</title>\n"
				+ "</head>\n" + "<body>\n" + "\t<h1>beetl</h1>\n" + "<%" + " for(entry in map){"
				+ "   print(entry.key+\":\"+entry.value);}%>" + "</body>\n" + "</html>";
		Template t = groupTemplate.getTemplate(testTemplate);
		Map<String, String> data = new HashMap<String, String>();
		data.put("test", "213");
		data.put("aaa", "123");
		// 把map类型数据绑定到占位符map上，但在Beetl中使用循环时不需要用${}
		t.binding("map", data);
		String str = t.render();
		System.out.println(str);
	}
}
