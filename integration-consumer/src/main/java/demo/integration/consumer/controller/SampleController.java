package demo.integration.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import demo.integration.api.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SampleController {

    @Reference(version = "${demo.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:23456")
    HelloService helloService;

    @GetMapping("sayHello")
    public String sayHello(@RequestParam("what") String what) {
        return helloService.sayHello(what);
    }
}
