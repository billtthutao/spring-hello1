package tk.billhu.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        String name = System.getProperty("MY_NAME");
        return "Hello World From Spring-Hello1,MY_NAME="+name;
    }
}
