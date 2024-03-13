package gg.ssocde.rabbitmqexp.view;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatViewController {

    private final WebServerApplicationContext context;

    @GetMapping("/")
    public String showChatPage(Model model) {
        model.addAttribute("port", context.getWebServer().getPort());
        return "index";
    }

}
