package com.rincon.taco_cloud.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// http://localhost:8080/taco-cloud/login
@Controller
public class HolaMundo {
	@GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
