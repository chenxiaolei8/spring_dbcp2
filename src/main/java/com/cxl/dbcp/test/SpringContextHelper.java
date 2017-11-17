package com.cxl.dbcp.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author chenxiaolei3
 * @Mail chenxiaolei3@jd.com
 * @Description
 * @DATE Created in 10:53 2017/11/17
 * @Modify by
 */
public class SpringContextHelper implements ApplicationContextAware {
    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    public Object getBean(String name) {
        return context.getBean(name);
    }

    public void getHello(String mes) {
        System.out.println("Hello, " + mes);
    }

}
