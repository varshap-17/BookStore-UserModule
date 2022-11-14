package com.example.usermodule.consumer;

import com.example.usermodule.Dto.Email;
import com.example.usermodule.model.UserData;
import com.example.usermodule.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class User {
    @Autowired
    EmailService emailService;
    @RabbitListener(queues = MessageConfigure.QUEUE)
    public void consumeMessageFromQueue(UserData userDataDto){
        Email email=new Email(userDataDto.getEmail(),"BookStore Application", "Hai, "+userDataDto.getFirstname()+" "+userDataDto.getLastname() +" Welcome to Bookstore!! your user has been " +
                "registered successfully and your order is placed");
        try {
            emailService.sendEmail(email);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
