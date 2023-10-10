import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class JankenController {

  @GetMapping("/")
  public String index() {
    return "index"; // index.htmlを表示
  }

  @PostMapping("/janken")
  public String janken(@RequestParam("username") String username, Model model) {
    model.addAttribute("username", username);
    return "janken"; // janken.htmlを表示
  }

  @GetMapping("/janken.html")
  public String jankenPage() {
    return "janken"; // janken.htmlを表示
  }
}
