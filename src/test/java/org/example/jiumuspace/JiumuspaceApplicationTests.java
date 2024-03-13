package org.example.jiumuspace;

import org.example.jiumuspace.service.impl.QtJcDhServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JiumuspaceApplicationTests {

    @Autowired
    QtJcDhServiceImpl service;
    @Test
    void contextLoads() {
    }

}
