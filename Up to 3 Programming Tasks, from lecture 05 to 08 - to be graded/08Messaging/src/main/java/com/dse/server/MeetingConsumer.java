package com.dse.server;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MeetingConsumer {

    @RabbitListener(queues = "meetingQueue")
    public void receiveMessage(String message) {
        System.out.println("Received Message: " + message);    }
}