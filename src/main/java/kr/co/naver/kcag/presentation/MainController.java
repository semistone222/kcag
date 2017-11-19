package kr.co.naver.kcag.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(@RequestParam(value="name", required=false, defaultValue="KCAG") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
	}
}
