package com.falcon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.falcon.representation.Dummy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by bagasas on 25/6/2017.
 */
@Controller
@RequestMapping("/")
public class GetDummyController {

    private static final String contentTemplate = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public  Dummy dummy (
            @RequestParam(value = "name", required=false, defaultValue="Falcon Dev") String name,
            @RequestParam(value = "content",  required=false, defaultValue="Hello, %s!") String content
    ){
        Dummy dummy  = new Dummy(name,content+" "+name);
        dummy.setId(counter.incrementAndGet());
        return dummy;
    }
//    public @ResponseBody Dummy dummyJSON(
//            @RequestParam(value="name", required=false, defaultValue="Falcon Dev") String name) {
//
//        //return new Dummy(counter.incrementAndGet(), String.format(contentTemplate, name));
//    }

}
