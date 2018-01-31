package com.booking.booking;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by suren on 30/01/2018.
 */

@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }



}
