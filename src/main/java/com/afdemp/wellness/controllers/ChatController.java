
package com.afdemp.wellness.controllers;

import com.afdemp.wellness.entities.Message;
import com.afdemp.wellness.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/chat")
public class ChatController {
    
    @Autowired
    AppService appService;
    
    @RequestMapping(value="",method=RequestMethod.GET)
    public String chatPage(ModelMap model){
        model.addAttribute("name",appService.getPrincipal());
        model.addAttribute("message", new Message());
        model.addAttribute("loggedinuser",appService.getPrincipal());
        model.addAttribute("pagetitle", "Chat");
        return "chat";
    }
    
    @RequestMapping(value="/addMessage",method=RequestMethod.POST)
    public String addMessage(ModelMap model,@ModelAttribute Message message){
        Message.addMessage(message);
        return "redirect:/chat";
    }
    
}
