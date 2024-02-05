package community.portal.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import community.portal.Entity.UsersEntity;
import community.portal.Exception.CustomException;
import community.portal.Repository.Users;

@Controller
public class UpdateUser
{
    @Autowired
    Users users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/update-profile", method = RequestMethod.POST)  
    public String updateProfile(RedirectAttributes model, Principal p, UsersEntity user, @RequestParam("cPassword") String cPassword, @RequestParam("profileImage") MultipartFile file) throws IOException, InterruptedException
    {
        UsersEntity userProfile = users.findUserWithId(p.getName(), "active");

        if(userProfile != null)
        {
            if(user.getPassword() != null && !cPassword.trim().isEmpty())
            {
                if(user.getPassword().equals(cPassword))
                {
                    userProfile.setFirstname(user.getFirstname());
                    userProfile.setLastname(user.getLastname());
                    userProfile.setEmail(user.getEmail());
                    userProfile.setCity((user.getCity().trim().isEmpty()) ? null : user.getCity());
                    userProfile.setCompany_name((user.getCompany_name().trim().isEmpty()) ? null : user.getCompany_name());

                    userProfile.setPassword(passwordEncoder.encode(user.getPassword()));

                    if(!file.isEmpty())
                    {
                        String txt = String.valueOf(System.currentTimeMillis());
                        Path filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "images");
                        if(Files.notExists(filePath)) Files.createDirectory(filePath);

                        if(Files.notExists(Paths.get(filePath.toString(), file.getOriginalFilename()))) Files.write(Paths.get(filePath.toString(), txt + ".png"), file.getBytes());

                        userProfile.setImage(txt + ".png");

                        users.save(userProfile);
                        
                        TimeUnit.SECONDS.sleep(2);

                        model.addFlashAttribute("result", "Profile Updated");

                        return "redirect:/profile";

                    } else 
                    {
                        users.save(userProfile);

                        model.addFlashAttribute("result", "Profile Updated");

                        return "redirect:/profile";
                    }


                } else 
                {
                    model.addFlashAttribute("result", "Incorrect password");

                    return "redirect:/profile";
                }

            } else 
            {
                userProfile.setFirstname(user.getFirstname());
                userProfile.setLastname(user.getLastname());
                userProfile.setEmail(user.getEmail());
                userProfile.setCity((user.getCity().trim().isEmpty()) ? null : user.getCity());
                userProfile.setCompany_name((user.getCompany_name().trim().isEmpty()) ? null : user.getCompany_name());

                    if(!file.isEmpty())
                    {
                        String txt = String.valueOf(System.currentTimeMillis());
                        Path filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "images");
                        if(Files.notExists(filePath)) Files.createDirectory(filePath);

                        if(Files.notExists(Paths.get(filePath.toString(), file.getOriginalFilename()))) Files.write(Paths.get(filePath.toString(), txt + ".png"), file.getBytes());

                        userProfile.setImage(txt + ".png");

                        users.save(userProfile);
                        
                        TimeUnit.SECONDS.sleep(2);

                        model.addFlashAttribute("result", "Profile Updated");

                        return "redirect:/profile";

                    } else 
                    {
                        users.save(userProfile);

                        model.addFlashAttribute("result", "Profile Updated");

                        return "redirect:/profile";
                    }
            }

        } else 
        {
            model.addFlashAttribute("result", "Unauthorized");

            return "redirect:/profile";
        }
    }  

    @RequestMapping(value = "/modify", method = RequestMethod.POST)  
    public String updateProfileAdmin(RedirectAttributes model, Principal p, UsersEntity user, @RequestParam("cPassword") String cPassword, @RequestParam("profileImage") MultipartFile file) throws IOException, InterruptedException
    {
        UsersEntity userProfile = users.findUserWithId(user.getId().toString(), "active");

        if(userProfile != null)
        {
            if(user.getPassword() != null && !cPassword.trim().isEmpty())
            {
                if(user.getPassword().equals(cPassword))
                {
                    userProfile.setFirstname(user.getFirstname());
                    userProfile.setLastname(user.getLastname());
                    userProfile.setEmail(user.getEmail());
                    userProfile.setCity((user.getCity().trim().isEmpty()) ? null : user.getCity());
                    userProfile.setCompany_name((user.getCompany_name().trim().isEmpty()) ? null : user.getCompany_name());

                    userProfile.setPassword(passwordEncoder.encode(user.getPassword()));

                    if(!file.isEmpty())
                    {
                        String txt = String.valueOf(System.currentTimeMillis());
                        Path filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "images");
                        if(Files.notExists(filePath)) Files.createDirectory(filePath);

                        if(Files.notExists(Paths.get(filePath.toString(), file.getOriginalFilename()))) Files.write(Paths.get(filePath.toString(), txt + ".png"), file.getBytes());

                        userProfile.setImage(txt + ".png");

                        users.save(userProfile);
                        
                        TimeUnit.SECONDS.sleep(2);

                        model.addFlashAttribute("result", "User Info Updated");

                        return "redirect:/admin/modify/" + user.getId();

                    } else 
                    {
                        users.save(userProfile);

                        model.addFlashAttribute("result", "User Info Updated");

                        return "redirect:/admin/modify/" + user.getId();
                    }


                } else 
                {
                    model.addFlashAttribute("result", "Incorrect password");

                    return "redirect:/admin/modify/" + user.getId();
                }

            } else 
            {
                userProfile.setFirstname(user.getFirstname());
                userProfile.setLastname(user.getLastname());
                userProfile.setEmail(user.getEmail());
                userProfile.setCity((user.getCity().trim().isEmpty()) ? null : user.getCity());
                userProfile.setCompany_name((user.getCompany_name().trim().isEmpty()) ? null : user.getCompany_name());

                    if(!file.isEmpty())
                    {
                        String txt = String.valueOf(System.currentTimeMillis());
                        Path filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "images");
                        if(Files.notExists(filePath)) Files.createDirectory(filePath);

                        if(Files.notExists(Paths.get(filePath.toString(), file.getOriginalFilename()))) Files.write(Paths.get(filePath.toString(), txt + ".png"), file.getBytes());

                        userProfile.setImage(txt + ".png");

                        users.save(userProfile);
                        
                        TimeUnit.SECONDS.sleep(2);

                        model.addFlashAttribute("result", "User Info Updated");

                        return "redirect:/admin/modify/" + user.getId();

                    } else 
                    {
                        users.save(userProfile);

                        model.addFlashAttribute("result", "User Info Updated");

                        return "redirect:/admin/modify/" + user.getId();
                    }
            }

        } else 
        {
            model.addFlashAttribute("result", "Unauthorized");

            return "redirect:/admin/modify/" + user.getId();
        }
    }
}
