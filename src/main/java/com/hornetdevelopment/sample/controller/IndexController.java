package com.hornetdevelopment.sample.controller;

import com.hornetdevelopment.sample.domain.ApplicationStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by steve on 4/21/17.
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public ApplicationStatus index() {
        // could check some state, such as whether the application was ready, dependent remote services are available, etc.
        return new ApplicationStatus("Sample Application", ApplicationStatus.STATUS.OK);
    }
}
