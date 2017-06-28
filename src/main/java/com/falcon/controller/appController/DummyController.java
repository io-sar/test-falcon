package com.falcon.controller.appController;

import com.falcon.controller.dataController.EntityDao;
import com.falcon.entities.InputDummy;
import com.falcon.entities.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by io-sar on 25/6/2017.
 */
@Controller
public class DummyController {

    @Autowired
    private EntityDao entityDao;

    //Index welcome form
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Falcon test");
        model.addAttribute("wlc", "Welcome, lets start");

        return "dummy/index";
    }

    //Add item form, sends post request to the page
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String chatForm(Model model){
        model.addAttribute("title", "Chat group");
        model.addAttribute("wlc", "Set user name and chat");

        return "dummy/add";
    }

    //Form to show the items in the db
    @RequestMapping(value = "show")
    public String showDB(Model model){

        model.addAttribute("title", "Message List");
        model.addAttribute("wlc", "Show messages");
        model.addAttribute("messages", entityDao.findAll());

        return "dummy/show";
    }

    //Endpoint that sends messages and saves to db the message
    @MessageMapping("/ws")
    @SendTo("/server/messages")
    public OutputMessage messageOutput(InputDummy dummy) throws Exception {
        Thread.sleep(1000); // simulated delay
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        OutputMessage message = new OutputMessage(dummy.getName(),dummy.getMessage(), time);
        entityDao.save(message);

        return message;
    }

    //Form that returns the db items as json
    @RequestMapping(value = "/jsonlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<OutputMessage> showJsonlist(){

        return entityDao.findAll();
    }


}
