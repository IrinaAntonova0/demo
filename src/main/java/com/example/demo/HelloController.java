package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

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
}

