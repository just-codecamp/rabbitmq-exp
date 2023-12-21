package gg.ssocde.rabbitmqexp.config;

import gg.ssocde.rabbitmqexp.dto.ChatContent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MessageResolver {

    private final RabbitTemplate template;

    @MessageMapping("/chat/send")
    public void send(ChatContent chatContent) {
        template.convertAndSend("app.chat.rooms", "room.1", chatContent);
//        template.convertAndSend("room.1", chatContent);
    }

}
