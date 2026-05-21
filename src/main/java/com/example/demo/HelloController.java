package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

/*    Student student = new Student("x", 0);*/

    @GetMapping
    public String sayHello(){
        return "Hi there.";
    }

    @GetMapping("/{greeting}")//localhost:8080/api/hello/liebe?name=iri
    public String sayHello2(@PathVariable String greeting,
                            @RequestParam(required = false) String name)
    {
        return greeting + " " + name;
    }


}

