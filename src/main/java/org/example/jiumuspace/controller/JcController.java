package org.example.jiumuspace.controller;


import jakarta.servlet.ServletContext;
import org.example.jiumuspace.common.ReloadResource;
import org.example.jiumuspace.entity.QtJc;
import org.example.jiumuspace.service.impl.QtJcDhServiceImpl;
import org.example.jiumuspace.service.impl.QtJcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/jc")
public class JcController {

    @Autowired
    QtJcServiceImpl jcService;
    @Autowired
    QtJcDhServiceImpl jcDhService;
    @Autowired
    ServletContext servletContext;
    @Autowired
    ReloadResource resource;

    @GetMapping("/document")
    public String getDocument(@RequestParam String path){
        QtJc jc = jcService.getById(path);
        return jc.getText();
    }
    @GetMapping("/index")
    public String getDh(){
        if (servletContext.getAttribute("index")==null
                || servletContext.getAttribute("index")==""){
            servletContext.setAttribute("index",jcDhService.getIndex());
        }
        return (String) servletContext.getAttribute("index");
    }
    @PostMapping("/index/first/add")
    public void addFirstIndex(@RequestBody Map<String,String> data){
        jcDhService.addFirstIndex(data.get("name"));
        resource.jcIndex();
    }
    @GetMapping("/index/first/get")
    public String getFirstIndex(){
        return jcDhService.getFirstIndex();
    }
    @PostMapping("/index/first/change")
    public void changeFirstIndex(@RequestBody Map<String,Object> data){
        System.out.println(data.get("id"));
        jcDhService.changeFirstIndex(Long.parseLong(data.get("id").toString()), (String) data.get("name"));
        resource.jcIndex();
    }
    @PostMapping("/index/first/delete")
    public void deleteFirstIndex(@RequestBody Map<String,Object> data){
        jcDhService.deleteFirstIndex(Long.parseLong(data.get("id").toString()));
        resource.jcIndex();
    }

    @PostMapping("/index/second/add")
    public void addSecondIndex(@RequestBody Map<String,String> data){
        jcDhService.addSecondIndex(Long.parseLong(data.get("parentId")),data.get("name"),data.get("url"));
    }
    @GetMapping("/index/second/get")
    public String getSecondIndex(String parentId){
        return jcDhService.getSecondIndex(Long.parseLong(parentId));
    }
    @PostMapping("/index/second/change")
    public void changeSecondIndex(@RequestBody Map<String,Object> data){
        jcDhService.changeSecondIndex(Long.parseLong(data.get("id").toString()),data.get("name").toString(),data.get("url").toString());
    }
    @PostMapping("/index/second/delete")
    public void deleteSecondIndex(@RequestBody Map<String,Object> data){
        jcDhService.deleteSecondIndex(Long.parseLong(data.get("parentId").toString()));
    }
}
