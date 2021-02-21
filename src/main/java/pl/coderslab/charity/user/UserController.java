package pl.coderslab.charity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.utils.Utils;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Utils utils;



    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUserFormGet(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserFormPost(@ModelAttribute @Validated User user,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/register";
        }
        userService.saveUser(user);
        return "user/success";
    }

    @ModelAttribute("currentUserFullName")
    public String currentUser(@AuthenticationPrincipal CurrentUser customUser) {
        return utils.currentUser(customUser);
    }
}
