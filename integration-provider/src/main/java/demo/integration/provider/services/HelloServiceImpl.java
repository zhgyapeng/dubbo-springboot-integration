package demo.integration.provider.services;

import com.alibaba.dubbo.config.annotation.Service;
import demo.integration.api.HelloService;

@Service(
        version = "${demo.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String what) {
        return "Hello, " + what;
    }
}
