package ro.sda.spring.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.sda.spring.services.HelloService;
import ro.sda.spring.services.NameService;
@Service
public class HelloServiceImpl implements HelloService {
    private NameService nameService;
    public HelloServiceImpl(@Qualifier("random") NameService nameService) {
        this.nameService = nameService;
    }
    @Override
    public void sayHello() {
        String name = nameService.getName();
        System.out.println("Hello " + name + "!");
    }
}