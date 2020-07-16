package pl.coderslab.charity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        user.setEnabled(true);
        userRepository.save(user);
    }
}
//    ConfirmationToken confirmationToken = new ConfirmationToken(user);
//        confirmationTokenRepository.save(confirmationToken);
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(user.getEmail());
//        mailMessage.setSubject("Complete Registration!");
//        mailMessage.setFrom("donotreply@gmail.com");
//        mailMessage.setText("To confirm your account, please click here : "
//                + "https://agreementgenerator.herokuapp.com/confirm-account?token=" + confirmationToken.getConfirmationToken());
//
//        emailSenderService.sendEmail(mailMessage);
//
//        model.addAttribute("emailId", user.getEmail());
//        String message = "Gratulacje, pomyślnie zarejestrowałeś się. " +
//                "Sprawdź swoją pocztę, wysłaliśmy link aktywacyjny.";
//        model.addAttribute("message", message);

//modelAndView.setViewName("successfulRegisteration");