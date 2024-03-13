package gg.ssocde.rabbitmqexp.config;

import gg.ssocde.rabbitmqexp.dto.ChatContent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MessageResolver {

    private final RabbitTemplate template;

    @MessageMapping("/chat.send.{chatRoomNum}")
    public void send2(ChatContent chatContent, @DestinationVariable(value = "chatRoomNum") String chatRumNum) {
        template.convertAndSend("app.chat.rooms", "room." + chatRumNum, chatContent);
    }

    @MessageMapping("/chat.notice.{chatRoomNum}")
    public void notice(ChatContent chatContent, @DestinationVariable(value = "chatRoomNum") String chatRumNum) {
        template.convertAndSend("app.chat.rooms", "room." + chatRumNum, chatContent);
    }

}
