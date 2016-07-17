package rs.personaltrainer.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping(value="html", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

}
