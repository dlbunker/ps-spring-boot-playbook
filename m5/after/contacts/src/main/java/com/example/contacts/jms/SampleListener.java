package com.example.contacts.jms;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener {
    @JmsListener(destination = "DLQ")
    public void dlqMessage(Message message) throws JMSException {
        if (message instanceof TextMessage) {
            System.out.println(((TextMessage) message).getText());
        }
        else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}
