package com.cxl.dbcp.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
/**
 * @Author chenxiaolei3
 * @Mail chenxiaolei3@jd.com
 * @Description
 * @DATE Created in 10:57 2017/11/17
 * @Modify by
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpringContextHelper {
    private static final Logger log = LoggerFactory.getLogger(TestSpringContextHelper.class);
    @Autowired // 对应 applicationContext bean 的名字
    SpringContextHelper springContextHelper;
    @Autowired // 对应 applicationContext bean 的名字
    BasicDataSource dataSource;
    //两种方式 获取dataSource

    /**
     * 1 通过 实现ApplicationContextAware 获取当前上下文 通过getBean 获取 类型自己判断
     * 2 通过 注解方式 获取
     */
    @Test
    public void getMes(){
        System.out.println(springContextHelper.toString());
        springContextHelper.getHello("陈三石");
        BasicDataSource dataSource = (BasicDataSource)springContextHelper.getBean("dataSource");
        System.out.println(dataSource.getInitialSize());
    }
    @Test
    public void getBean(){
        springContextHelper.getHello("陈晓磊");
        System.out.println(dataSource.getUrl());
    }
}
