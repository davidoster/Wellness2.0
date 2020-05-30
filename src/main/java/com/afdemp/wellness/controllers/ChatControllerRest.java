
package com.afdemp.wellness.controllers;

import java.util.List;
import java.util.Map;
import com.afdemp.wellness.entities.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/chat/api")
public class ChatControllerRest {
    
    @RequestMapping(value = {"/getMessages"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getMessages(){
        Map<String, Object> response = new HashMap();
        List<Message> messages = Message.getMessages();
         if(messages.isEmpty()){
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }else{
             response.put("messages", messages);
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
         }
    }
    @CrossOrigin
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public ResponseEntity<Void> addMessage(@RequestBody Message message) {
        System.out.println("Adding message " + message);
        Message.addMessage(message);
        return new ResponseEntity<Void>(setHeaders(),HttpStatus.OK);
    }
    
    private HttpHeaders setHeaders(){
        HttpHeaders headers = new HttpHeaders();
        Set<HttpMethod> methods = new HashSet<>();
        methods.add(HttpMethod.GET);
        methods.add(HttpMethod.POST);
        methods.add(HttpMethod.PUT);
        methods.add(HttpMethod.DELETE);
        methods.add(HttpMethod.OPTIONS);
        headers.setAllow(methods);
        return headers;
    }
}
