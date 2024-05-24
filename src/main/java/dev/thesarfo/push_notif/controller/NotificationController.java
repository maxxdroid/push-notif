package dev.thesarfo.push_notif.controller;

import dev.thesarfo.push_notif.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping
    @SendTo("/all/messages")
    public Message send(final Message message) throws Exception{
        return message;
    }

    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload Message message){
        messagingTemplate.convertAndSendToUser(message.getTo(), "/specific", message);
    }
}
