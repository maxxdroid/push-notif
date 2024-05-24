package dev.thesarfo.push_notif.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket configuration for the application.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configures the message broker.
     *
     * @param registry the MessageBrokerRegistry to modify
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // Enable simple broker with "/all" and "/specific" as destination prefixes
        registry.enableSimpleBroker("/all", "/specific");
        // Set application destination prefixes
        registry.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Registers STOMP endpoints.
     *
     * @param registry the StompEndpointRegistry to modify
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // Register "/ws" as a STOMP endpoint
        registry.addEndpoint("/ws");
        // Register "/ws" as a STOMP endpoint with SockJS as the fallback option
        registry.addEndpoint("/ws").withSockJS();
    }

}
