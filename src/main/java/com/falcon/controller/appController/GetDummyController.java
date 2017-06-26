package com.falcon.controller.appController;

import com.falcon.controller.dataController.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.falcon.entities.Dummy;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by bagasas on 25/6/2017.
 */
@Controller
public class GetDummyController {

    @Autowired
    private EntityDao entityDao;

    @RequestMapping(value = "")
    @ResponseBody
    public String index(){

        if (entityDao.findAll() == null ){
            return "Hello There";
        }

        return entityDao.findAll().toString();
    }


    @RequestMapping(value = "add")
    @ResponseBody
    public Dummy saveToDb (
            @RequestParam(value = "name", required=false, defaultValue="Falcon Dev") String name,
            @RequestParam(value = "content",  required=false, defaultValue="Hello there") String content
    ){
        Dummy dummy = new Dummy();
        dummy.setContent(content + name);
        dummy.setName(name);

       entityDao.save(dummy);

        return dummy;
    }


}
