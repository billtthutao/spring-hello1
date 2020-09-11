package tk.billhu.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
    @Autowired
    private Environment env;

    private static Random random = new Random();
    private HttpStatus[] httpStatuses = new HttpStatus[]{HttpStatus.OK,HttpStatus.INTERNAL_SERVER_ERROR};
    private HttpStatus httpStatus = httpStatuses[random.nextInt(2)];

    @RequestMapping("/")
    public String hello(){
        String name = env.getProperty("MY_NAME");
        return "Hello World From Spring-Hello1,MY_NAME="+name;
    }

    @RequestMapping("/healthy")
    public ResponseEntity healthy(){

        return new ResponseEntity<>("Health Check...", httpStatus);
    }

    @RequestMapping("/ready")
    public String ready(){

        return hello();
    }
}

