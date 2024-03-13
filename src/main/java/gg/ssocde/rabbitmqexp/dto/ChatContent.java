package gg.ssocde.rabbitmqexp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatContent {

    private String userId;
    private String msg;

}
