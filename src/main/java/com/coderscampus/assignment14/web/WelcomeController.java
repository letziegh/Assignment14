package com.coderscampus.assignment14.web;

//import com.coderscampus.assignment14.UserService;
import com.coderscampus.assignment14.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")

    public String welcome() {
        return "welcome";
    }
}




//@PostMapping("/welcome")
//    public String postUser (User user){
//    userService.save(user);
//
//}



