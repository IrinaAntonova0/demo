package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    static Integer id = 1;
    List<Message> messageList = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello(){
        return "Hi there.";
    }

    @GetMapping("/hello/{greeting}")//localhost:8080/api/hello/Liebe?name=iri
    public String sayHello2(@PathVariable String greeting,
                            @RequestParam(required = false) String name)
    {
        return greeting + " " + name;
    }

    @GetMapping("/messages")//local:8080/api/hello/2?q=test
    public List<Message> getMessages()
    {
        return this.messageList;
    }

    @PostMapping("/messages")
    public Message postMessage(@RequestBody Message message)
    {
        message.setId(String.valueOf(this.id++));
        this.messageList.add(message);
        return this.messageList.getLast();
    }

    @DeleteMapping("/messages")
    public Message deleteMessage(@RequestBody Message message)
    {
        if (messageList.contains(message)) {
            messageList.remove(message);
            return message;
        }
        else {
            return null;
        }
    }

    @PutMapping("/messages/update/{id}")
    public Message updateMessage(@PathVariable String id,
                                 @RequestBody Message message)
    {
        for(int i = 0; i<messageList.size(); i++) {
            if(id.equals(message.getId()) && message.getId().equals(messageList.get(i).getId()) && message.getName().equals(messageList.get(i).getName())) {//Map wär besser ;)
                String oldMsg = messageList.get(i).getMessage();
                (messageList.get(i)).setMessage(oldMsg + " >> " + message.getMessage());
                return messageList.get(i);
            }
        }
        return null;
    }

    @DeleteMapping("/messages/{id}")
    public Message deleteMessage(@PathVariable String id,
                                 @RequestParam(required = false) String unusedname)
    {
        for( Message m : messageList) {
            if(id.equals(m.id)) {
                messageList.remove(m);
                return m;
            }
        }
        return null;
    }
}

