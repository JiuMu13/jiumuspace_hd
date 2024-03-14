package org.example.jiumuspace.common;

import jakarta.servlet.ServletContext;
import org.example.jiumuspace.service.impl.QtJcDhServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class ReloadResource {
    @Autowired
    private WebApplicationContext applicationContext;
    @Autowired
    private QtJcDhServiceImpl qtJcDhService;

    public void jcIndex(){
        ServletContext servletContext = applicationContext.getServletContext();
        servletContext.setAttribute("index",qtJcDhService.getIndex());
    }
}
