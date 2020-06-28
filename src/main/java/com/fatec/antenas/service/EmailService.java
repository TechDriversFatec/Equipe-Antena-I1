package com.fatec.antenas.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.SendFailedException;
import java.util.Base64;
import java.util.Calendar;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public void sendMail(String email, String url) throws SendFailedException {

        try {
            JSONObject userRequest = new JSONObject();
            userRequest.put("dateTime", Calendar.getInstance());
            userRequest.put("email", email);

            String b64 = Base64.getEncoder().encodeToString(userRequest.toString().getBytes());
            String link = url + b64;

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(remetente);
            message.setTo(email);
            message.setSubject("Antenas - Confirmação de e-mail");
            message.setText("Para acessar com seu usuário no Antenas, clique no link: " + link);
            emailSender.send(message);
        } catch (Exception ex) {
            throw new SendFailedException();
        }
    }
}
