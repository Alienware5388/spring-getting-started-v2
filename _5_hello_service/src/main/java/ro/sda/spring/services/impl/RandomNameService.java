package ro.sda.spring.services.impl;
import org.springframework.stereotype.Service;
import ro.sda.spring.services.NameService;
import java.util.List;
import java.util.Random;
@Service(value = "random")
public class RandomNameService implements NameService {
    public RandomNameService() {
        System.out.println("RandomNameService instance created");
    }
    @Override
    public String getName() {
        List<String> names = List.of("Catalin","Roland", "Tunde", "Daiana", "Beinur", "Mark", "Viorel","George","Irina","Tudor","Ionut");
        Random r = new Random();
        return names.get(r.nextInt(11));
    }
}