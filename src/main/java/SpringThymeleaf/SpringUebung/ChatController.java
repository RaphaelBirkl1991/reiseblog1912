package SpringThymeleaf.SpringUebung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private List<Message> messages;

    public ChatController() {
        messages = new ArrayList<>();
        messages.add(new Message(LocalDateTime.now(), "Alice" , "Hello how are you?"));
        messages.add(new Message(LocalDateTime.now(), "Bob" , "Fine thank you"));
        messages.add(new Message(LocalDateTime.now(), "Alice" , "Glad to hear it"));
    }

    @GetMapping
    public String chat(Model model, @RequestParam(required = false, defaultValue = "") String senderFilter) {
        model.addAttribute("messages", messages.stream().filter(m -> m.getSender().contains(senderFilter))
                .collect(Collectors.toList()));
        model.addAttribute("filter", senderFilter);
        return "chat";
    }

    @PostMapping
    public String post(Model model, @RequestParam String sender, @RequestParam String content ) {
        Message message = new Message(LocalDateTime.now(), sender, content);
        messages.add(message);
        model.addAttribute("messages", messages);
        return "chat";
    }


}
