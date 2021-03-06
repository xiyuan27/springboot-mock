package com.dlh.yaml.test;

import com.dlh.yaml.config.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by wutao on 2018/10/25
 */
@RestController
@RequestMapping(value = "yaml")
@Slf4j
public class TestController {

    /**
     * 通过注解将属性直接映射
     */
    @Value("${com.dlh.name}")
    private String name;

    @Value("${com.dlh.dept}")
    private String dept;

    @Value("${com.dlh.project}")
    private String project;

    @Value("${com.dlh.packages}")
    private String packages;

    @RequestMapping(value = "test")
    public String test(){
        System.err.println(name +": " + dept);
        return "test";
    }

    @RequestMapping(value = "test1")
    public String test1(){
        System.err.println(project +": " + packages);
        return "test1";
    }

    @Autowired
    private TestBean testBean;

    @RequestMapping(value = "testbean")
    public String test2(){
        System.err.println(testBean.getProject()+": "+testBean.getPackages());
        return "testbean";
    }
}
