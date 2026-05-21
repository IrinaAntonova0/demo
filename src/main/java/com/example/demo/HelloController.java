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

    @GetMapping("/messages/all")//local:8080/api/hello/2?q=test
    public String getMessages()
    {
        return this.messageList.toString();
    }

    @PostMapping("/messages")
    public String postStudent(@RequestBody Message message)
    {
        this.messageList.add(message);
        return this.messageList.getLast().toString();
    }
}

