package com.hornetdevelopment.sample.controller;

import com.hornetdevelopment.sample.domain.Greeting;
import com.hornetdevelopment.sample.service.GreetingService;
import com.hornetdevelopment.sample.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by steve on 4/21/17.
 */
@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Greeting> listGreetings() {
        return greetingService.listGreetings();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Greeting getGreetingById(@PathVariable(value = "id") String id) {
        // normally we would let Spring handle the conversion to UUID
        // but for sample app purposes, we'll do it ourselves to provide something
        // unit testable in the controller
        return greetingService.getGreetingById(UUIDUtil.uuidFromString(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return greetingService.createGreeting(greeting);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Greeting updateGreeting(@RequestBody Greeting greeting, @PathVariable(value = "id") String id) {
        return greetingService.updateGreeting(greeting, UUIDUtil.uuidFromString(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteGreeting(@PathVariable(value = "id") String id) {
        greetingService.deleteGreeting(UUIDUtil.uuidFromString(id));
    }
}
