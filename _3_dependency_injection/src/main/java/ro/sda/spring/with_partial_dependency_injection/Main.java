package ro.sda.spring.with_partial_dependency_injection;
public class Main {
    public static void main(String[] args) {
        ServiceConsumer email = new ServiceConsumer(new EmailService());
        email.processMessage("ALERT", "ionut@abc.com");
        ServiceConsumer sms = new ServiceConsumer(new SmsService());
        sms.processMessage("ALERT", "0722222222");
//        MessageService service = new SmsService();
//        service.sendMessage("ALERT", "0722222222");
//        service = new EmailService();
//        service.sendMessage("ALERT", "ionut@abc.com");
    }
}