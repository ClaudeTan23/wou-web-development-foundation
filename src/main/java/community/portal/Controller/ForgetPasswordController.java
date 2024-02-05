package community.portal.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import community.portal.Entity.UsersEntity;
import community.portal.Exception.CustomException;
import community.portal.Repository.Users;
import community.portal.Service.ForgetPasswordEmail;


@Controller
public class ForgetPasswordController
{
    @Autowired
    private Users users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ForgetPasswordEmail forgetPasswordEmail;

    @RequestMapping(value = "/forget", method = RequestMethod.POST)
    public String Forget(Model model, @RequestParam String email) 
    {
        UsersEntity user = users.findActiveEmail(email, "active");
        String otp = UUID.randomUUID().toString().split("-")[0];

        if(user != null)
        {
            String encryptOtp = passwordEncoder.encode(otp);
            String username   = user.getUsername();
            String userEmail  = user.getEmail();

            user.setPassword(encryptOtp);
            user.setOtp(otp);
            users.save(user);

            if(forgetPasswordEmail.Run(username, otp, userEmail))
            {
                model.addAttribute("response", "We have sent password recovery to your email.");
                return "forget";

            } else 
            {
                model.addAttribute("response", "email failed error");
                return "forget";
            }

        } else 
        {
            model.addAttribute("response", "Invalid Email");
            return "forget";
        }
    }
        
}
