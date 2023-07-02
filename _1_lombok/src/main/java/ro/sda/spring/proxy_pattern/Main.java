package ro.sda.spring.proxy_pattern;

public class Main {

    public static void main(String[] args) {

        MathService service = new MathServiceProxy();

        service.subtract(10, 20);
        service.add(30, 5);


    }
}
