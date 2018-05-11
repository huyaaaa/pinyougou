package com.huyaaaaaa.html.util;

import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;

public class MyFM {
    public void test01() throws IOException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDirectoryForTemplateLoading(new File("I:\\IDEA_WORKSPACE\\pinyougou\\pyg_html_util\\src\\main\\demo.ftl"));
        configuration.setDefaultEncoding("utf-8");
        configuration.getTemplate("demo.ftl");
        configuration.
    }
}
