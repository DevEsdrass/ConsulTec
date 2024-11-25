package com.Consultorio.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void enviarEmail(String toEmail, String subject, String body) {
        try {

        System.out.println("Enviando e-mail para: " + toEmail);
        System.out.println("Assunto: " + subject);
        System.out.println("Corpo: " + body);

        // Código para envio de e-mail
            System.out.println("Enviando e-mail para: " + toEmail);


        if (toEmail == null || toEmail.isEmpty()) {
            throw new IllegalArgumentException("O e-mail do destinatário não pode ser nulo ou vazio.");
        }

    } catch (Exception e) {
        System.err.println("Erro ao enviar e-mail: " + e.getMessage());
        e.printStackTrace();
    }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("consultecagendamentos@outlook.com");

        javaMailSender.send(message);
    }
}
