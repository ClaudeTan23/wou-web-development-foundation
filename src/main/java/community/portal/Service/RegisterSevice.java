package community.portal.Service;

import java.util.*;

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
        UsersEntity existedEmail = userRepo.findActiveEmail(user.getEmail(), "active");

        if(existedUser == null)
        {
            if(existedEmail != null)
            {
                redirect.addFlashAttribute("result", "This Email have been used.");
                return "redirect:/register";
            }

            String encryptPassword  = passwordEncoder.encode(user.getPassword());
            UUID uid = UUID.randomUUID();

            user.setPassword(encryptPassword);
            user.setVerify_code(uid.toString());
            user.setStatus("pending");
            user.setImage("profile.png");
            
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
            if(existedEmail != null)
            {
                redirect.addFlashAttribute("result", "This Email have been used.");
                return "redirect:/register";
            }

            String encryptPassword = passwordEncoder.encode(user.getPassword());
            UUID uid = UUID.randomUUID();
            Set<RoleEntity> rolePosition = new HashSet<RoleEntity>();

            existedUser.setPassword(encryptPassword);
            existedUser.setVerify_code(uid.toString());
            existedUser.setFirstname(user.getFirstname());
            existedUser.setLastname(user.getLastname());
            existedUser.setEmail(user.getEmail());
            existedUser.setImage("profile.png");

            RoleEntity roleUser = roleRepo.findByRoles("user");
            RoleEntity roleAdmin = roleRepo.findByRoles("admin");

            if(user.getRoles().contains(roleAdmin))
            {
                rolePosition.add(roleAdmin);
                existedUser.roles = rolePosition;


            } else 
            {
                rolePosition.add(roleUser);
                existedUser.roles = rolePosition;
        
            }

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