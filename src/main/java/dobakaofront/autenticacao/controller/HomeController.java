package dobakaofront.autenticacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "redirect:/home"; // redireciona raiz para /home (página protegida)
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // retorna a view home.html (requer autenticação)
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // retorna a view login.html (Spring Security já libera esta URL)
    }
}
