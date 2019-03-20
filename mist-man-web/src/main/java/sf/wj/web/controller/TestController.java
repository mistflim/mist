package sf.wj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sf.wj.service.PersonService;

/**
 * Created by wangjun32 on 2019/2/13.
 */
@Controller
@RequestMapping("/wjtest")
public class TestController {

    @Autowired
    private PersonService personService;

    @RequestMapping
    public void query(@RequestParam("name") String name){

    }
}
