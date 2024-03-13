package org.example.jiumuspace.controller;


import jakarta.servlet.ServletContext;
import org.example.jiumuspace.entity.QtJc;
import org.example.jiumuspace.service.impl.QtJcDhServiceImpl;
import org.example.jiumuspace.service.impl.QtJcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jc")
public class JcController {

    @Autowired
    QtJcServiceImpl jcService;
    @Autowired
    QtJcDhServiceImpl jcDhService;
    @Autowired
    ServletContext servletContext;

    @GetMapping("/document")
    public String getDocument(@RequestParam String path){
        QtJc jc = jcService.getById(path);
        return jc.getText();
    }

    @GetMapping("/Index")
    public String getDh(){
        if (servletContext.getAttribute("index")==null
                || servletContext.getAttribute("index")==""){
            servletContext.setAttribute("index",jcDhService.getIndex());
        }
        return (String) servletContext.getAttribute("index");
    }


}
