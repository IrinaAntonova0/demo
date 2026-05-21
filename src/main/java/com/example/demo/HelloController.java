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

    @GetMapping("/{greeting}")//local:8080/api/hello/2?q=test
    public String sayHello2(@PathVariable String greeting,
                            @RequestParam(required = false) String name)
    {
        return greeting + " " + name;
    }

/*    @GetMapping("/student")//local:8080/api/hello/2?q=test
    public String getStudent()
    {
        return student;
    }

    @PostMapping("/student")
    public String getStudent(@RequestBody Student student)
    {
        this.student = student;
        return this.student;
    }*/
}

