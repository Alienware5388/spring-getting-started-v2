package ro.sda.spring.without_dependency_injection;
/**
* Email service class that holds the logic to send email messages to recipient email addresses
* */
public class EmailService {

    public void sendEmail(String message, String receiver){

        System.out.println("Email sent to " + receiver + "with message " + message);
    }
}
