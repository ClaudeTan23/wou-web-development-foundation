package community.portal.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import community.portal.Entity.RoleEntity;
import community.portal.Entity.UsersEntity;
import community.portal.Repository.Roles;
import community.portal.Repository.Users;

@Service
public class RegisterSevice 
{
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private Users userRepo;

    @Autowired
    private Roles roleRepo;

    @Autowired
    private EmailRegistration emailRegistration;

    public String User(UsersEntity user, RedirectAttributes redirect)
    {
        UsersEntity existedUser = userRepo.findByUsername(user.getUsername());

        if(existedUser == null)
        {
            String encryptPassword  = passwordEncoder.encode(user.getPassword());
            UUID uid = UUID.randomUUID();

            user.setPassword(encryptPassword);
            user.setVerify_code(uid.toString());
            user.setStatus("pending");
            user.setImage("profile.png");

            RoleEntity role = roleRepo.findByRoles("user");

            user.setRoles(role);
            
            userRepo.save(user);

            if(emailRegistration.Run(uid.toString(), user.getUsername(), user.getEmail()))
            {
                redirect.addFlashAttribute("response", "success");
                redirect.addFlashAttribute("email", user.getEmail());

                return "redirect:/confirmation";

            } else 
            {
                redirect.addFlashAttribute("result", "error");
                return "redirect:/register";
            }

        } else if(existedUser != null && existedUser.getStatus().equals("pending"))
        {
            String encryptPassword = passwordEncoder.encode(user.getPassword());
            UUID uid = UUID.randomUUID();

            existedUser.setPassword(encryptPassword);
            existedUser.setVerify_code(uid.toString());
            existedUser.setFirstname(user.getFirstname());
            existedUser.setLastname(user.getLastname());
            existedUser.setEmail(user.getEmail());
            existedUser.setStatus("pending");
            existedUser.setImage("profile.png");

            RoleEntity role = roleRepo.findByRoles("user");

            existedUser.setRoles(role);

            userRepo.save(existedUser);

            if(emailRegistration.Run(uid.toString(), existedUser.getUsername(), user.getEmail()))
            {
                redirect.addFlashAttribute("response", "success");
                redirect.addFlashAttribute("email", user.getEmail());
                
                return "redirect:/confirmation";

            } else 
            {
                redirect.addFlashAttribute("result", "error");
                return "redirect:/register";
            }

        } else
        {
            redirect.addFlashAttribute("result", "The Username existed");
            return "redirect:/register";
        }
    }
}
