package com.eurekaservercentre.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${server.port}")
    private int serverPort;

    @ResponseBody
    @GetMapping("queryPort")
    public String queryPort(){
        return "hei, my server port is:"+serverPort;
    }


}
