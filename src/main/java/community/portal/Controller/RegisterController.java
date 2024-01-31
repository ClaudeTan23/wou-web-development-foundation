package community.portal.Controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.regex.*;
import community.portal.Entity.UsersEntity;
import community.portal.Repository.Users;
import community.portal.Service.EmailRegistration;
import community.portal.Service.RegisterSevice;

@Controller
public class RegisterController 
{
    @Autowired
    private RegisterSevice registerSevice;

    @Autowired
    private EmailRegistration emailRegistration;

    @Autowired Users users;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegisterUser(RedirectAttributes redirect, UsersEntity user)
    {
        String regex = "^(.+)@(.+)$";

        if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty() || user.getFirstname().isEmpty() || user.getLastname().isEmpty())
        {
            redirect.addFlashAttribute("result", "Invalid");
            return "redirect:/register";

        } else
        {
            Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(user.getEmail());

            if(matcher.matches())
            {
                return registerSevice.User(user, redirect);

            } else 
            {
                redirect.addFlashAttribute("result", "Invalid Email");
                return "redirect:/register";
            }
        }

    } 

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Register()
    {
        // emailRegistration.Run();
        
        return "register";
    }  

    @RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    public String ConfirmationEmail()
    {
        return "email-confirmation";
    }  

    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String Verify(@RequestParam String u, @RequestParam String n)
    {
        UsersEntity user = users.findPendingUser(n, u, "pending");

        if(user != null)
        {
            user.setStatus("active");
            user.setVerify_code(null);

            users.save(user);

            return "thankyou";

        } else 
        {
            return "redirect:/register";
        }
    }  
    
}
