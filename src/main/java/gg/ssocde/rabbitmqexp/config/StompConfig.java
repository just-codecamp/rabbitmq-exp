package gg.ssocde.rabbitmqexp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/app/chat")
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry
                .setPathMatcher(new AntPathMatcher("."))
                .enableStompBrokerRelay("/temp-queue", "/exchange", "/topic", "/queue", "/amq/queue", "/reply-queue")
                    .setRelayHost("localhost")
                    .setRelayPort(61613)
                    .setClientLogin("admin")
                    .setClientPasscode("admin")
                    .setSystemLogin("admin")
                    .setSystemPasscode("admin");
    }

}
