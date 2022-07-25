package com.gustavopeiretti.springemail;

import com.icegreen.greenmail.configuration.GreenMailConfiguration;
import com.icegreen.greenmail.junit5.GreenMailExtension;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import javax.mail.internet.MimeMessage;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmailServiceTest {

    @RegisterExtension
    static GreenMailExtension greenMail = new GreenMailExtension(ServerSetupTest.SMTP)
            .withConfiguration(GreenMailConfiguration
                    .aConfig().withUser("user@gmail.com", "password"));

    @Autowired
    private EmailService emailService;

    @Test
    void send() throws Exception {
        emailService.send("gus@gmail.com", "jhon@gmail.com",
                "Hello", "How are you?");

        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        MimeMessage receivedMessage = receivedMessages[0];

        assertEquals("gus@gmail.com", receivedMessage.getFrom()[0].toString());
        assertEquals("jhon@gmail.com", receivedMessage.getAllRecipients()[0].toString());
        assertEquals("Hello", receivedMessage.getSubject().trim());
        assertEquals("How are you?", receivedMessage.getContent().toString().trim());
        // others test assertions with receivedMessage..
    }

    @Test
    void sendWithAttach() throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("info.txt");
        File file = classPathResource.getFile();
        FileSystemResource fileResource = new FileSystemResource(file);
        emailService.sendWithAttach("gus@gmail.com", "jhon@gmail.com",
                "Hello", "How are you?", "info.txt", fileResource);

        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        MimeMessage receivedMessage = receivedMessages[0];

        assertEquals("gus@gmail.com", receivedMessage.getFrom()[0].toString());
        assertEquals("jhon@gmail.com", receivedMessage.getAllRecipients()[0].toString());
        assertEquals("Hello", receivedMessage.getSubject().trim());
        // others test assertions with receivedMessage..
    }
}