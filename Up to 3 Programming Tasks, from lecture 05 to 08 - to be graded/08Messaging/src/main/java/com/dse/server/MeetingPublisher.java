package com.dse.server;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingPublisher {

    private static final String EXCHANGE = "meetingExchange";
    private static final String ROUTING_KEY = "meetingKey";

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void publishMeeting(String meetingDetails) {
        amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, meetingDetails);
    }
}