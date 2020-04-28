package pl.sytomczak.supplementstore.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkout")
public class MainController {

    @RequestMapping("/checkout")
    public String showPage(Model model) {
        return "checkout";
    }
}

