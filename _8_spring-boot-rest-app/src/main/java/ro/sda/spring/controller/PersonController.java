package ro.sda.spring.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.spring.model.Person;
@RestController
public class PersonController {
    @GetMapping("/abc")
    public Person getPerson(){
        Person p = new Person("Catalin", 25);
        return  p;
    }

    @PostMapping("/person")
    public void postPerson(@RequestBody Person received){
        System.out.println(received);
    }

}