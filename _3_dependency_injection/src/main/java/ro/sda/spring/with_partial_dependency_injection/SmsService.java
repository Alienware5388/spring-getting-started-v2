package ro.sda.spring.with_partial_dependency_injection;
public class SmsService implements MessageService {
    @Override
    public void sendMessage(String message, String receiver) {
        // logic to send sms
        System.out.println("SMS sent to " + receiver + " with message " + message);
    }
}
