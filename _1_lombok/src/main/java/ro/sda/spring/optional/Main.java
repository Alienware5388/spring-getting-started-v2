package ro.sda.spring.optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<Product> opt1 = findByName("headset");

        if(opt1.isPresent()){
            Product p = opt1.get();
            System.out.println(p.getName());
        } else{
            System.out.println("Not present");
        }

        System.out.println("----------------------");


        Optional<Product> opt2 = findByName("iphone 10");

        if(opt2.isPresent()){
            Product p = opt2.get();
            System.out.println(p.getName());
        } else{
            System.out.println("Not present");
        }

    }

    public static Optional<Product> findByName(String name){
        if(name.equals("headset")){
            return Optional.of(new Product("headset"));
        } else{
            return Optional.empty();
        }
    }

    static class Product {
        private String name;

        public Product(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
