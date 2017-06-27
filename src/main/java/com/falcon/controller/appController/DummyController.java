package com.falcon.controller.appController;

import com.falcon.controller.dataController.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.falcon.entities.Dummy;

/**
 * Created by bagasas on 25/6/2017.
 */
@Controller
@RequestMapping("dummy")
public class DummyController {

    @Autowired
    private EntityDao entityDao;

    //index welcome form
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Falcon test");
        model.addAttribute("wlc", "Welcome, lets start");

        return "dummy/index";
    }

    //add item form, sends post request to the page
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addDummyform(Model model){
        model.addAttribute("title", "Falcon test");
        model.addAttribute("wlc", "Add a user");

        return "dummy/add";
    }

    //receives the post request and saves to db
    @RequestMapping(value = "add",  method = RequestMethod.POST)
    public String saveToDb (
            @RequestParam(value = "name", required=false, defaultValue="Default Dev") String name,
            @RequestParam(value = "content",  required=false, defaultValue="Default Hello world") String content
    ){
        Dummy dummy = new Dummy();
        dummy.setContent(content + name);
        dummy.setName(name);
        entityDao.save(dummy);

        return "redirect:add";
    }

    //form to show the items into the db
    @RequestMapping(value = "show")
    public String showDummies(Model model){

        model.addAttribute("title", "Falcon test");
        model.addAttribute("wlc", "Show users");
        model.addAttribute("dummies", entityDao.findAll());

        return "dummy/show";
    }


    //form to show the jsonlist
    @RequestMapping(value = "/jsonlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Dummy> jsonlist(){

        return entityDao.findAll();
    }


}
