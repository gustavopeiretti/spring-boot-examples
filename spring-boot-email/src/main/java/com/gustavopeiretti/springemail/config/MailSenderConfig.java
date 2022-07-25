package com.gustavopeiretti.springemail.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MailSenderConfig {

//   Commented for the purpose of using the properties file autoconfiguration ..
//    @Bean("javaMailSender")
//    public JavaMailSender javaMailSender() {
//        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        sender.setHost("smtp.gmail.com");
//        sender.setPort(587);
//        sender.setUsername("gpeiretti@gmail.com");
//        sender.setPassword("rwwqudgdbjvewrfm");
//
//        Properties props = sender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        return sender;
//    }

}
