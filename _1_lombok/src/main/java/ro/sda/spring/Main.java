package ro.sda.spring;

public class Main {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setFirstName("Catalin");
        u1.setLastName("Manaila");
        u1.setAge(25);
        System.out.println(u1);

        User u2= new User("Leo", "Messi", 35);
        System.out.println(u2);

    }
}