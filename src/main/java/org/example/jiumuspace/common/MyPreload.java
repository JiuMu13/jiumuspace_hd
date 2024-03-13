package org.example.jiumuspace.common;


import jakarta.servlet.ServletContext;
import org.example.jiumuspace.service.impl.QtJcDhServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * 实现CommandLineRunner接口的类会在Spring IOC容器加载完毕后执行
 * 用于预加载所需资源
 */
@Component
@Order(1)
public class MyPreload implements CommandLineRunner {

    @Autowired
    private WebApplicationContext applicationContext;
    @Autowired
    private QtJcDhServiceImpl qtJcDhService;
    @Override
    public void run(String... args) throws Exception {
        ServletContext servletContext = applicationContext.getServletContext();
        servletContext.setAttribute("index",qtJcDhService.getIndex());
    }
}
