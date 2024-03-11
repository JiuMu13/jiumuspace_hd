package org.example.jiumuspace.controller;

import org.example.jiumuspace.entity.QtJc;
import org.example.jiumuspace.service.impl.QtJcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/jc")
public class JcController {

    @Autowired
    QtJcServiceImpl jcService;

    @GetMapping("/document")
    public String getDocument(@RequestParam String path){
        QtJc jc = jcService.getById(path);
        return jc.getText();
    }
}
