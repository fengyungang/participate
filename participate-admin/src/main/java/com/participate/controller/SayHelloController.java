package com.participate.controller;


import com.participate.SayHello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
    @RequestMapping("/sayHello")
    public String sayHello(){
        String aa = SayHello.fyg();
        System.out.println(aa);
       return null;
   }


}
