package dev.thesarfo.push_notif.controller;

import dev.thesarfo.push_notif.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Controller for handling notifications.
 */
@Controller
public class NotificationController {

    private final SimpMessagingTemplate messagingTemplate;

    /**
     * Constructor for NotificationController.
     *
     * @param messagingTemplate the SimpMessagingTemplate to use for messaging
     */
    public NotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * Handles messages sent to "/application" and forwards them to "/all/messages".
     *
     * @param message the Message to send
     * @return the sent Message
     * @throws Exception if an error occurs
     */
    @MessageMapping("/application")
    @SendTo("/all/messages")
    public Message send(final Message message) throws Exception{
        return message;
    }

    /**
     * Handles messages sent to "/private" and forwards them to a specific user.
     *
     * @param message the Message to send
     */
    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload Message message){
        messagingTemplate.convertAndSendToUser(message.getTo(), "/specific", message);
    }
}