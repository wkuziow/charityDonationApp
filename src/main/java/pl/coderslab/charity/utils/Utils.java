package pl.coderslab.charity.utils;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.CurrentUser;

@Service
public class Utils {

    public String currentUser (@AuthenticationPrincipal CurrentUser customUser) {
        String currentUser = "-1";
        if (customUser != null) {
            currentUser = customUser.getUser().getFullname();
        }
        return currentUser;
    }
}
