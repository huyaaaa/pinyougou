package com.huyaaaaaa.html.util.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class MyFM {
    @Test
    public void test01() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        //设置模板所在文件夹路径
        configuration.setDirectoryForTemplateLoading(new File("I:\\IDEA_WORKSPACE\\pinyougou\\pyg_html_util\\src\\main\\"));
        //设置模板编码格式
        configuration.setDefaultEncoding("utf-8");
        //设置模板名称（和上面的路径进行拼接）
        Template template = configuration.getTemplate("demo.ftl");
        //设置输出
        HashMap<String, String> map = new HashMap<>();
        map.put("name","狗儿子");
        //创建输出流
        FileWriter writer = new FileWriter(new File("D:\\hello.html"));
        template.process(map,writer);
        writer.close();
        
    }
}
