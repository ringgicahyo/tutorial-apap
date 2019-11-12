package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, Model model, @RequestParam("password") String password, @RequestParam("checkPassword") String checkPassword){
        if (userService.checkCharacter(user.getPassword())){
            UserModel tempUser = userService.findByUsername(user.getUsername());
            if (tempUser != null) {
                if (!userService.checkPassword(password, checkPassword)){
                    return "home.html";
                } else {
                    userService.addUser(user);
                }
            }
        }
        return "home.html";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    private String changePassword(@RequestParam("password") String password,
                                  @RequestParam("oldPassword") String oldPassword,
                                  @RequestParam("checkPassword") String checkPassword){
        String user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getUsername();
        if(!userService.checkOldPassword(user, oldPassword) ||
                !userService.checkCharacter(password) ||
                !userService.validatePassword(password, oldPassword, checkPassword)
        ) return "failed.html";
        userService.changePassword(user, password);
        return "update-password.html";
    }

}
