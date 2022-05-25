package spring.mail.validation.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.mail.validation.service.ValidateService;
import spring.mail.validation.service.impl.ValidateServiceImpl;

@Controller
public class EmailController {

    @GetMapping("/validate")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("view/validate.jsp");
        return modelAndView;
    }

    @PostMapping("/result")
    ModelAndView validateEmail(@RequestParam("email") String email) {
        ValidateService validateService = new ValidateServiceImpl();
        Boolean isvalid = validateService.validate(email);

        if (!isvalid) {
            ModelAndView modelAndView = new ModelAndView("view/validate.jsp");
            modelAndView.addObject("message", "Email is invalid");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("view/success.jsp");
        modelAndView.addObject("email", email);
        return modelAndView;
    }
}
