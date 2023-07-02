package ro.sda.spring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring.config.ProjectConfig;
import ro.sda.spring.services.HelloService;
public class Main {
    public static void main(String[] args) {
        //try with resources !!!
        try (var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            //NameService myService = ctx.getBean("simple" , NameService.class);
            //System.out.println("The name generated by simple service is: " + myService.getName());
            HelloService helloService = ctx.getBean(HelloService.class);
            helloService.sayHello();
        }
    }
}