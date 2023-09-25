package com.yx.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class logController {

    private Logger logger = LoggerFactory.getLogger(logController.class);

    @RequestMapping(value="/test")
    @ResponseBody
    public String test(){
        String msg = "fucking good";
        logger.info("slf4j print info msg:{}",msg);
        logger.debug("slf4j print debug msg:{}",msg);
        return msg;
    }

}
