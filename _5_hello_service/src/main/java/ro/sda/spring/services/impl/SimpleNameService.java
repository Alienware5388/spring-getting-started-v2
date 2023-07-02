package ro.sda.spring.services.impl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ro.sda.spring.services.NameService;
@Service(value = "simple")
public class SimpleNameService implements NameService {
    public SimpleNameService() {
        System.out.println("SimpleNameService instance created");
    }
    @Override
    public String getName() {
        return "Ionut";
    }
}