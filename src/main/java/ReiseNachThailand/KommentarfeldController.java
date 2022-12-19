package ReiseNachThailand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class KommentarfeldController {
    @Autowired
    private KommentarfeldService kommentarfeldService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("kommentarfelde", kommentarfeldService.getKommentarfelde());
        model.addAttribute("kommentarfeld", new Kommentarfeld("", ""));
        return "kommentarfeld.html";
    }

    @PostMapping("/neuerEintrag")
    public String neuerEintrag(Model model, @Valid @ModelAttribute Kommentarfeld kommentarfeld, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("kommentarfelde", kommentarfeldService.getKommentarfelde());
            return "kommentarfeld.html";
        }
        kommentarfeldService.addEintrag(kommentarfeld);
        return "redirect:/";
    }
}
