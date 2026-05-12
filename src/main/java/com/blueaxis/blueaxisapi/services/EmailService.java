package com.blueaxis.blueaxisapi.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

    @Value("${BREVO_API_KEY}")
    private String brevoApiKey;

    public void sendEmail(String to, String subject, String text) {

        String url = "https://api.brevo.com/v3/smtp/email";

        
        System.out.println("BREVO API EMAIL SERVICE HIT");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", brevoApiKey);

        Map<String, Object> body = Map.of(
            "sender", Map.of(
                "name", "BlueAxis Media",
                "email", "kaverii1605@gmail.com"
            ),
            "to", List.of(
                Map.of("email", to)
            ),
            "subject", subject,
            "htmlContent", "<p>" + text.replace("\n", "<br>") + "</p>"
        );

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(url, request, String.class);
    }
}