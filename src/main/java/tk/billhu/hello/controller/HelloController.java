package tk.billhu.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String hello(){
        String name = env.getProperty("MY_NAME");
        return "Hello World From Spring-Hello1,MY_NAME="+name;
    }
}
